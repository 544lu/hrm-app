package com.tpl.hrmapp.presentation;

import com.tpl.hrmapp.domain.Employee;

import java.util.List;

public class EmployeeView {
    private Integer pages;
    private List<Employee> rows;
    private long total;

    public EmployeeView(Integer pages, List<Employee> rows, long total) {
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

    public List<Employee> getRows() {
        return rows;
    }

    public void setRows(List<Employee> employees) {
        this.rows = employees;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
