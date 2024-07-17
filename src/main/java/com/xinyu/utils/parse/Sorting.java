package com.xinyu.utils.parse;

import org.apache.commons.lang3.StringUtils;

public class Sorting {
    private SortingMode mode;
    private String[] fields;

    public Sorting() {
    }

    public Sorting(String... fields) {
        this(SortingMode.Ascending, fields);
    }

    public Sorting(SortingMode mode, String... fields) {
        if (fields != null && fields.length != 0) {
            this.setMode(mode);
            this.fields = fields;
        } else {
            throw new IllegalArgumentException("fields");
        }
    }

    public String getFieldsText() {
        return this.fields != null && this.fields.length >= 1 ? StringUtils.join(this.fields, ",") : "";
    }

    public void setFieldsText(String value) {
        if (StringUtils.isBlank(value)) {
            throw new NullPointerException("fieldText");
        } else {
            this.fields = value.split(",");
        }
    }

    public void setFields(String[] fields) {
        if (fields != null && fields.length != 0) {
            this.fields = fields;
        } else {
            throw new IllegalArgumentException("fields");
        }
    }

    public String[] getFields() {
        return this.fields;
    }

    public SortingMode getMode() {
        return this.mode;
    }

    public void setMode(SortingMode mode) {
        this.mode = mode;
    }

    public String toString() {
        if (StringUtils.isBlank(this.getFieldsText())) {
            return "";
        } else {
            return SortingMode.Ascending == this.getMode() ? this.getFieldsText() + (this.getMode() == null ? "" : "  ASC") : this.getFieldsText() + (this.getMode() == null ? "" : "  DESC");
        }
    }

    public static Sorting ascending(String... fields) {
        return new Sorting(SortingMode.Ascending, fields);
    }

    public static Sorting descending(String... fields) {
        return new Sorting(SortingMode.Descending, fields);
    }

    public static enum SortingMode {
        Ascending,
        Descending;

        private SortingMode() {
        }
    }
}
