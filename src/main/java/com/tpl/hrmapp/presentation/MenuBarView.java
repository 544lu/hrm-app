package com.tpl.hrmapp.presentation;

import com.tpl.hrmapp.domain.Department;

import java.util.ArrayList;
import java.util.List;

public class MenuBarView {
    private Integer id;
    private String text;
    private List<Department> children=new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }
}
