package com.xinyu.utils.parse;

import java.io.Serializable;

public class Paging implements Serializable {
    private static final long serialVersionUID = 754828768811350476L;
    private Long totalCount;
    private Long pageIndex;
    private long pageSize;
    private boolean enableTotalCount;

    public Paging() {
        this(1L, 10L);
    }

    public Paging(Long pageIndex, Long pageSize) {
        this(pageIndex, pageSize, 0L);
    }

    public Paging(long pageIndex, long pageSize, long totalCount) {
        if (pageSize < 1L) {
            pageSize = 10L;
        }

        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.pageIndex = pageIndex;
        this.enableTotalCount = true;
    }

    public Long getTotalCount() {
        return this.totalCount;
    }

    public Long getPageIndex() {
        return this.pageIndex;
    }

    public Long getPageSize() {
        return this.pageSize;
    }

    public Long getPageCount() {
        return this.totalCount < 1L ? 0L : Math.round(Math.ceil((double)this.totalCount / (double)this.pageSize));
    }

    public boolean getEnableTotalCount() {
        return this.enableTotalCount;
    }

    public void setPageIndex(Long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public void setEnableTotalCount(boolean enableTotalCount) {
        this.enableTotalCount = enableTotalCount;
    }

    @Override
    public String toString() {
        return "Paging [totalCount=" + this.totalCount + ", pageIndex=" + this.pageIndex + ", pageSize=" + this.pageSize + ", enableTotalCount=" + this.enableTotalCount + "]";
    }

    public static Paging build(Long pageIndex, Long pageSize) {
        return new Paging(pageIndex, pageSize);
    }

    public static Paging build() {
        return new Paging();
    }
}

