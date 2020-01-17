package com.tpl.hrmapp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "job_tb")
public class Job {
    @Id
    private Integer id;
    private String jobName;
    private Integer levelId;
    private Integer pid;
    private boolean isDel;
    private String status;
    private String creator;
    private Integer creatorId;
    private Date createTime;
    private String modifier;
    private Integer modifierId;
    private Date modifyTime;
    private String mainWork1;
    private String mainWork2;
    private String mainWork3;
    private String mainWork4;
    private String mainWork5;
    private String mainWork6;
    private String mainWork7;
    private String mainWork8;
    private String keywords;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public boolean isDel() {
        return isDel;
    }

    public void setDel(boolean del) {
        isDel = del;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Integer getModifierId() {
        return modifierId;
    }

    public void setModifierId(Integer modifierId) {
        this.modifierId = modifierId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getMainWork1() {
        return mainWork1;
    }

    public void setMainWork1(String mainWork1) {
        this.mainWork1 = mainWork1;
    }

    public String getMainWork2() {
        return mainWork2;
    }

    public void setMainWork2(String mainWork2) {
        this.mainWork2 = mainWork2;
    }

    public String getMainWork3() {
        return mainWork3;
    }

    public void setMainWork3(String mainWork3) {
        this.mainWork3 = mainWork3;
    }

    public String getMainWork4() {
        return mainWork4;
    }

    public void setMainWork4(String mainWork4) {
        this.mainWork4 = mainWork4;
    }

    public String getMainWork5() {
        return mainWork5;
    }

    public void setMainWork5(String mainWork5) {
        this.mainWork5 = mainWork5;
    }

    public String getMainWork6() {
        return mainWork6;
    }

    public void setMainWork6(String mainWork6) {
        this.mainWork6 = mainWork6;
    }

    public String getMainWork7() {
        return mainWork7;
    }

    public void setMainWork7(String mainWork7) {
        this.mainWork7 = mainWork7;
    }

    public String getMainWork8() {
        return mainWork8;
    }

    public void setMainWork8(String mainWork8) {
        this.mainWork8 = mainWork8;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
