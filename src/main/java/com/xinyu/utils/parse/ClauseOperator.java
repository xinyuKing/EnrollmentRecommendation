package com.xinyu.utils.parse;

// 条件操作符枚举类
public enum ClauseOperator {
    Equal("=", "等于"),
    NotEqual("!=", "不等于"),
    GreaterThan(">", "大于"),
    GreaterThanEqual(">=", "大于等于"),
    LessThan("<", "小于"),
    LessThanEqual("<=", "小于或等于"),
    Between("Between", "介于"),
    In("In", "范围"),
    NotIn("Not In", "排除范围"),
    Null("Is", "空值"),
    NotNull("Is Not", "非空值"),
    Like("Like", "模糊查询"),
    NotLike("Not Like", "NotLike"),
    Child("Child", "子查询");

    private final String description;
    private final String alias;

    private ClauseOperator(String alias, String description) {
        this.description = description;
        this.alias = alias;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getDescription() {
        return this.description;
    }
}
