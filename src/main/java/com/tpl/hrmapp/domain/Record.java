package com.tpl.hrmapp.domain;


import javax.persistence.*;
import java.util.Date;

/**
 * 用于记录每次修改
 */

@Entity
@Table(name="record_tb")
public class Record {
    //主键
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    //修改人
    private String modifier;
    //修改时间
    private Date modifyTime;
    //操作行为
    private String operationCategory;
    //操作对象
    private String employeeName;
    //工作岗位
    private String jobName;
    //修改的列名称
    private String columnName;
    //原值
    private String beforeVal;
    //修改后的值
    private String afterVal;

    public Record(){}

    public Record(String modifier,String operationCate,Employee em){
        this.modifier=modifier;
        this.modifyTime=new Date();
        this.operationCategory=operationCate;
        this.employeeName=em.getEmployeeName();
    }

    public Record(String modifier,String operationCate,Employee em,String jobName){
        this.modifier=modifier;
        this.modifyTime=new Date();
        this.operationCategory=operationCate;
        this.employeeName=em.getEmployeeName();
        this.jobName=jobName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getBeforeVal() {
        return beforeVal;
    }

    public void setBeforeVal(String beforeVal) {
        this.beforeVal = beforeVal;
    }

    public String getAfterVal() {
        return afterVal;
    }

    public void setAfterVal(String afterVal) {
        this.afterVal = afterVal;
    }

    public String getOperationCategory() {
        return operationCategory;
    }

    public void setOperationCategory(String operationCategory) {
        this.operationCategory = operationCategory;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
}
