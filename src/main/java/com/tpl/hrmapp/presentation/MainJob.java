package com.tpl.hrmapp.presentation;

import com.tpl.hrmapp.domain.Job;
import org.apache.commons.lang3.StringUtils;

/**
 * 岗位信息
 */
public class MainJob {
    private Integer id;
    private String jobName;
    private WorkInfo workInfo1;
    private WorkInfo workInfo2;
    private WorkInfo workInfo3;
    private WorkInfo workInfo4;
    private WorkInfo workInfo5;
    private WorkInfo workInfo6;
    private WorkInfo workInfo7;
    private WorkInfo workInfo8;

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

    public WorkInfo getWorkInfo1() {
        return workInfo1;
    }

    public void setWorkInfo1(WorkInfo workInfo1) {
        this.workInfo1 = workInfo1;
    }

    public WorkInfo getWorkInfo2() {
        return workInfo2;
    }

    public void setWorkInfo2(WorkInfo workInfo2) {
        this.workInfo2 = workInfo2;
    }

    public WorkInfo getWorkInfo3() {
        return workInfo3;
    }

    public void setWorkInfo3(WorkInfo workInfo3) {
        this.workInfo3 = workInfo3;
    }

    public WorkInfo getWorkInfo4() {
        return workInfo4;
    }

    public void setWorkInfo4(WorkInfo workInfo4) {
        this.workInfo4 = workInfo4;
    }

    public WorkInfo getWorkInfo5() {
        return workInfo5;
    }

    public void setWorkInfo5(WorkInfo workInfo5) {
        this.workInfo5 = workInfo5;
    }

    public WorkInfo getWorkInfo6() {
        return workInfo6;
    }

    public void setWorkInfo6(WorkInfo workInfo6) {
        this.workInfo6 = workInfo6;
    }

    public WorkInfo getWorkInfo7() {
        return workInfo7;
    }

    public void setWorkInfo7(WorkInfo workInfo7) {
        this.workInfo7 = workInfo7;
    }

    public WorkInfo getWorkInfo8() {
        return workInfo8;
    }

    public void setWorkInfo8(WorkInfo workInfo8) {
        this.workInfo8 = workInfo8;
    }

    public Job createJob() {
        Job job = new Job();
        job.setId(this.id);
        job.setJobName(this.jobName);
        job.setDel(false);
        if (StringUtils.isNotBlank(this.workInfo1.getWorkName())) {
            job.setMainWork1(this.workInfo1.getWorkName());
        }
        if (StringUtils.isNotBlank(this.workInfo2.getWorkName())) {
            job.setMainWork2(this.workInfo2.getWorkName());
        }
        if (StringUtils.isNotBlank(this.workInfo3.getWorkName())) {
            job.setMainWork3(this.workInfo3.getWorkName());
        }
        if (StringUtils.isNotBlank(this.workInfo4.getWorkName())) {
            job.setMainWork4(this.workInfo4.getWorkName());
        }
        if (StringUtils.isNotBlank(this.workInfo5.getWorkName())) {
            job.setMainWork5(this.workInfo5.getWorkName());
        }
        if (StringUtils.isNotBlank(this.workInfo6.getWorkName())) {
            job.setMainWork6(this.workInfo6.getWorkName());
        }
        if (StringUtils.isNotBlank(this.workInfo7.getWorkName())) {
            job.setMainWork7(this.workInfo7.getWorkName());
        }
        if (StringUtils.isNotBlank(this.workInfo8.getWorkName())) {
            job.setMainWork8(this.workInfo8.getWorkName());
        }
        return job;
    }
}