package com.tpl.hrmapp.presentation;

import java.util.List;

public class FrontView<T> {
    private Integer pages;
    private List<T> rows;
    private long total;

    public FrontView(Integer pages, List<T> rows, long total) {
        this.pages = pages;
        this.rows = rows;
        this.total = total;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
