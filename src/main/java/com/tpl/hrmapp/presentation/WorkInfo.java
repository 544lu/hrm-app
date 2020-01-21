package com.tpl.hrmapp.presentation;

import com.tpl.hrmapp.domain.Job;

/**
 * 采集具体工作信息
 */
public class WorkInfo {
    private Integer id;
    private String workName;
    private String mainWorkDes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getMainWorkDes() {
        return mainWorkDes;
    }

    public void setMainWorkDes(String mainWorkDes) {
        this.mainWorkDes = mainWorkDes;
    }

    public Job createWork() {
        Job workContent = new Job();
        workContent.setId(this.id);
        workContent.setJobName(this.workName);
        workContent.setDel(false);
        workContent.setMainWork1(this.mainWorkDes);
        return workContent;
    }
}
