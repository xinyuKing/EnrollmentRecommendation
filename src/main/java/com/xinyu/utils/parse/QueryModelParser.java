package com.xinyu.utils.parse;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class QueryModelParser {
    private static final Logger logger = LoggerFactory.getLogger(QueryModelParser.class);

    private QueryModelParser() {
    }

    /**
     * 将condition转为where语句
     *
     * @param condition  过滤条件
     * @param tableAlias 别名
     * @return where list
     */
    public static <T> List<String> parseCondition(T condition, String tableAlias) {
        if (condition == null) {
            return null;
        }
        String formatAlias = formatAlias(tableAlias);
        Class<?> conditionClass = condition.getClass();
        Field[] fields = conditionClass.getDeclaredFields();
        List<String> list = new ArrayList<>(fields.length);
        for (Field field : fields) {
            Object fieldValue = null;
            try {
                String fieldName = field.getName();
                String getMethodName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
                Method getMethod = conditionClass.getMethod(getMethodName);
                fieldValue = getMethod.invoke(condition);
            } catch (Exception e) {
                logger.error("获取Condition字段值 {}失败", field);
            }
            //字段值为空或者包含ConditionIgnore注解，跳过
            if (fieldValue == null || field.isAnnotationPresent(ConditionIgnore.class)) {
                continue;
            }
            ConditionOperator operator = field.getAnnotation(ConditionOperator.class);
            String filedStr = "";
            if (operator.operator() == ClauseOperator.Null || operator.operator() == ClauseOperator.NotNull) {
                list.add(String.format("%s`%s` %s NULL", formatAlias, operator.name(), operator.operator().getAlias()));
            } else {
                if (operator.operator() == ClauseOperator.Like || operator.operator() == ClauseOperator.NotLike) {
                    filedStr = String.format("'%%%s%%'", fieldValue);
                } else if (operator.operator() == ClauseOperator.In || operator.operator() == ClauseOperator.NotIn || operator.operator() == ClauseOperator.Between) {
                    if (fieldValue instanceof ArrayList) {
                        ArrayList<Object> valueList = (ArrayList<Object>) fieldValue;
                        if (!valueList.isEmpty()) {
                            List<String> valueStrList = valueList.stream().map(p -> String.format("'%s'", p)).collect(Collectors.toList());
                            if (operator.operator() == ClauseOperator.Between) {
                                filedStr = String.join(" AND ", valueStrList);
                            } else {
                                filedStr = String.format("(%s)", String.join(",", valueStrList));
                            }
                        }
                    }
                } else {
                    filedStr = String.format("'%s'", fieldValue);
                }
                if (StringUtils.isNotEmpty(filedStr)) {
                    list.add(String.format("%s`%s` %s %s", formatAlias, operator.name(), operator.operator().getAlias(), filedStr));
                }
            }
        }
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    /**
     * 将Sorting转换为order by语句
     *
     * @param sorting     排序数据
     * @param entityClazz 实体类，用于获取字段对应的表名
     * @param tableAlias  sql使用时的别名
     * @return order by list
     */
    public static List<String> parseOrder(Sorting[] sorting, Class<?> entityClazz, String tableAlias) {
        if (sorting == null || sorting.length == 0) {
            return null;
        }
        String formatAlias = formatAlias(tableAlias);
        Map<String, String> columnMap = getColumnMap(sorting, entityClazz);
        List<String> resList = new ArrayList<>(sorting.length);
        for (Sorting sort : sorting) {
            if (sort.getFields() == null || sort.getFields().length == 0) {
                continue;
            }
            List<String> formatFieldList = Arrays.stream(sort.getFields()).filter(StringUtils::isNotEmpty)
                    .map(field -> String.format("%s`%s`", formatAlias, columnMap.getOrDefault(field, field)))
                    .collect(Collectors.toList());
            String fieldsText = StringUtils.join(formatFieldList, ",");
            String sortStr;
            if (Sorting.SortingMode.Ascending == sort.getMode()) {
                sortStr = fieldsText + (sort.getMode() == null ? "" : " ASC");
            } else {
                sortStr = fieldsText + (sort.getMode() == null ? "" : " DESC");
            }
            resList.add(sortStr);
        }
        if (resList.isEmpty()) {
            return null;
        }
        return resList;
    }

    /**
     * 获取字段对应的数据库字段名
     *
     * @param sortingArray 排序条件
     * @return 数据库字段名映射
     */
    private static Map<String, String> getColumnMap(Sorting[] sortingArray, Class<?> entityClazz) {
        Map<String, String> columnMap = new HashMap<>(sortingArray.length);
        if (entityClazz == null) {
            return columnMap;
        }
        Field[] fields = entityClazz.getDeclaredFields();
        for (Sorting sorting : sortingArray) {
            if (sorting.getFields() == null) {
                continue;
            }
            for (String filedName : sorting.getFields()) {
                for (Field field : fields) {
                    if (field.getName().equals(filedName)) {
                        Column column = field.getAnnotation(Column.class);
                        if (column != null) {
                            columnMap.put(filedName, column.name());
                            break;
                        }
                    }
                }
            }
        }
        return columnMap;
    }

    private static String formatAlias(String tableAlias) {
        if (StringUtils.isEmpty(tableAlias)) {
            return "";
        }
        return tableAlias.endsWith(".") ? tableAlias : String.format("%s.", tableAlias);
    }
}
