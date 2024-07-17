package com.xinyu.utils.parse;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class QueryModel<T> {
    private T condition;
    private Paging paging;
    private Sorting[] sorts;
    private Map<String, Object> extras;

    public QueryModel() {
    }

    public QueryModel(T condition) {
        this.condition = condition;
    }

    public QueryModel(T condition, Paging paging) {
        this.condition = condition;
        this.paging = paging;
    }

    public QueryModel(T condition, Paging paging, Sorting[] sorts) {
        this.condition = condition;
        this.paging = paging;
        this.sorts = sorts;
    }

    public Object get(String name) {
        return this.extras == null ? null : this.extras.get(name);
    }

    public void set(String name, Object value) {
        if (this.extras == null) {
            this.extras = new LinkedHashMap();
        }

        this.extras.put(name, value);
    }

    public boolean contains(String name) {
        return this.extras == null ? false : this.extras.containsKey(name);
    }

    @Override
    public String toString() {
        Sorting[] sorts = this.sorts;
        StringBuilder sb = new StringBuilder("[");
        if (sorts != null) {
            Sorting[] var3 = sorts;
            int var4 = sorts.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Sorting sort = var3[var5];
                sb.append(sort).append(",");
            }
        }

        sb.append("]");
        return "QueryModel{condition=" + this.condition + ", paging=" + this.paging + ", sorts=" + sb + ", extras=" + this.extras + '}';
    }

    public static <V> QueryModel<V> build(V condition, Paging paging, Sorting[] sorts) {
        QueryModel<V> queryModel = new QueryModel(condition, paging, sorts);
        return queryModel;
    }

    public static <V> QueryModel<V> build(V condition, Paging paging) {
        QueryModel<V> queryModel = new QueryModel(condition, paging, (Sorting[])null);
        return queryModel;
    }

    public static <V> QueryModel<V> build(V condition) {
        QueryModel<V> queryModel = new QueryModel(condition, new Paging(), (Sorting[])null);
        return queryModel;
    }

    public T getCondition() {
        return this.condition;
    }

    public Paging getPaging() {
        return this.paging;
    }

    public Sorting[] getSorts() {
        return this.sorts;
    }

    public Map<String, Object> getExtras() {
        return this.extras;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public void setSorts(Sorting[] sorts) {
        this.sorts = sorts;
    }

    public void setExtras(Map<String, Object> extras) {
        this.extras = extras;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof QueryModel)) {
            return false;
        } else {
            QueryModel<?> other = (QueryModel)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$condition = this.getCondition();
                Object other$condition = other.getCondition();
                if (this$condition == null) {
                    if (other$condition != null) {
                        return false;
                    }
                } else if (!this$condition.equals(other$condition)) {
                    return false;
                }

                Object this$paging = this.getPaging();
                Object other$paging = other.getPaging();
                if (this$paging == null) {
                    if (other$paging != null) {
                        return false;
                    }
                } else if (!this$paging.equals(other$paging)) {
                    return false;
                }

                if (!Arrays.deepEquals(this.getSorts(), other.getSorts())) {
                    return false;
                } else {
                    Object this$extras = this.getExtras();
                    Object other$extras = other.getExtras();
                    if (this$extras == null) {
                        if (other$extras != null) {
                            return false;
                        }
                    } else if (!this$extras.equals(other$extras)) {
                        return false;
                    }

                    return true;
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof QueryModel;
    }


    @Override
    public int hashCode() {
//        int PRIME = true;
        int result = 1;
        Object $condition = this.getCondition();
        result = result * 59 + ($condition == null ? 43 : $condition.hashCode());
        Object $paging = this.getPaging();
        result = result * 59 + ($paging == null ? 43 : $paging.hashCode());
        result = result * 59 + Arrays.deepHashCode(this.getSorts());
        Object $extras = this.getExtras();
        result = result * 59 + ($extras == null ? 43 : $extras.hashCode());
        return result;
    }
}

