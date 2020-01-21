package com.tpl.hrmapp.presentation;

import com.tpl.hrmapp.domain.Job;
import org.apache.commons.lang3.StringUtils;

/**
 * 岗位信息
 */
public class MainJob {
    private Integer employeeId;
    private String employeeName;
    private Integer jobId;
    private String jobName;
    private Integer deptId;
    private String deptName;
    private WorkInfo workInfo1;
    private WorkInfo workInfo2;
    private WorkInfo workInfo3;
    private WorkInfo workInfo4;
    private WorkInfo workInfo5;
    private WorkInfo workInfo6;
    private WorkInfo workInfo7;
    private WorkInfo workInfo8;
    private WorkInfo workInfo9;
    private WorkInfo workInfo10;
    private WorkInfo workInfo11;
    private WorkInfo workInfo12;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public WorkInfo getWorkInfo9() {
        return workInfo9;
    }

    public void setWorkInfo9(WorkInfo workInfo9) {
        this.workInfo9 = workInfo9;
    }

    public WorkInfo getWorkInfo10() {
        return workInfo10;
    }

    public void setWorkInfo10(WorkInfo workInfo10) {
        this.workInfo10 = workInfo10;
    }

    public WorkInfo getWorkInfo11() {
        return workInfo11;
    }

    public void setWorkInfo11(WorkInfo workInfo11) {
        this.workInfo11 = workInfo11;
    }

    public WorkInfo getWorkInfo12() {
        return workInfo12;
    }

    public void setWorkInfo12(WorkInfo workInfo12) {
        this.workInfo12 = workInfo12;
    }

    public Job createJob() {
        Job job = new Job();
        job.setId(this.jobId);
        job.setJobName(this.jobName);
        job.setDel(false);
        if (this.workInfo1 != null && StringUtils.isNotBlank(this.workInfo1.getWorkName())) {
            if (StringUtils.isBlank(job.getMainWork1())) {
                job.setMainWork1(this.workInfo1.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork2())) {
                job.setMainWork2(this.workInfo1.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork3())) {
                job.setMainWork3(this.workInfo1.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork4())) {
                job.setMainWork4(this.workInfo1.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork5())) {
                job.setMainWork5(this.workInfo1.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork6())) {
                job.setMainWork6(this.workInfo1.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork7())) {
                job.setMainWork7(this.workInfo1.getWorkName());
            } else {
                job.setMainWork8(this.workInfo1.getWorkName());
            }
        }
        if (this.workInfo2 != null && StringUtils.isNotBlank(this.workInfo2.getWorkName())) {
            if (StringUtils.isBlank(job.getMainWork1())) {
                job.setMainWork1(this.workInfo2.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork2())) {
                job.setMainWork2(this.workInfo2.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork3())) {
                job.setMainWork3(this.workInfo2.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork4())) {
                job.setMainWork4(this.workInfo2.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork5())) {
                job.setMainWork5(this.workInfo2.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork6())) {
                job.setMainWork6(this.workInfo2.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork7())) {
                job.setMainWork7(this.workInfo2.getWorkName());
            } else {
                job.setMainWork8(this.workInfo2.getWorkName());
            }
        }
        if (this.workInfo3 != null && StringUtils.isNotBlank(this.workInfo3.getWorkName())) {
            if (StringUtils.isBlank(job.getMainWork1())) {
                job.setMainWork1(this.workInfo3.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork2())) {
                job.setMainWork2(this.workInfo3.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork3())) {
                job.setMainWork3(this.workInfo3.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork4())) {
                job.setMainWork4(this.workInfo3.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork5())) {
                job.setMainWork5(this.workInfo3.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork6())) {
                job.setMainWork6(this.workInfo3.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork7())) {
                job.setMainWork7(this.workInfo3.getWorkName());
            } else {
                job.setMainWork8(this.workInfo3.getWorkName());
            }
        }
        if (this.workInfo4 != null && StringUtils.isNotBlank(this.workInfo4.getWorkName())) {
            if (StringUtils.isBlank(job.getMainWork1())) {
                job.setMainWork1(this.workInfo4.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork2())) {
                job.setMainWork2(this.workInfo4.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork3())) {
                job.setMainWork3(this.workInfo4.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork4())) {
                job.setMainWork4(this.workInfo4.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork5())) {
                job.setMainWork5(this.workInfo4.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork6())) {
                job.setMainWork6(this.workInfo4.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork7())) {
                job.setMainWork7(this.workInfo4.getWorkName());
            } else {
                job.setMainWork8(this.workInfo4.getWorkName());
            }
        }
        if (this.workInfo5 != null && StringUtils.isNotBlank(this.workInfo5.getWorkName())) {
            if (StringUtils.isBlank(job.getMainWork1())) {
                job.setMainWork1(this.workInfo5.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork2())) {
                job.setMainWork2(this.workInfo5.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork3())) {
                job.setMainWork3(this.workInfo5.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork4())) {
                job.setMainWork4(this.workInfo5.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork5())) {
                job.setMainWork5(this.workInfo5.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork6())) {
                job.setMainWork6(this.workInfo5.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork7())) {
                job.setMainWork7(this.workInfo5.getWorkName());
            } else {
                job.setMainWork8(this.workInfo5.getWorkName());
            }
        }
        if (this.workInfo6 != null && StringUtils.isNotBlank(this.workInfo6.getWorkName())) {
            if (StringUtils.isBlank(job.getMainWork1())) {
                job.setMainWork1(this.workInfo6.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork2())) {
                job.setMainWork2(this.workInfo6.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork3())) {
                job.setMainWork3(this.workInfo6.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork4())) {
                job.setMainWork4(this.workInfo6.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork5())) {
                job.setMainWork5(this.workInfo6.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork6())) {
                job.setMainWork6(this.workInfo6.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork7())) {
                job.setMainWork7(this.workInfo6.getWorkName());
            } else {
                job.setMainWork8(this.workInfo6.getWorkName());
            }
        }
        if (this.workInfo7 != null && StringUtils.isNotBlank(this.workInfo7.getWorkName())) {
            if (StringUtils.isBlank(job.getMainWork1())) {
                job.setMainWork1(this.workInfo7.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork2())) {
                job.setMainWork2(this.workInfo7.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork3())) {
                job.setMainWork3(this.workInfo7.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork4())) {
                job.setMainWork4(this.workInfo7.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork5())) {
                job.setMainWork5(this.workInfo7.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork6())) {
                job.setMainWork6(this.workInfo7.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork7())) {
                job.setMainWork7(this.workInfo7.getWorkName());
            } else {
                job.setMainWork8(this.workInfo7.getWorkName());
            }
        }
        if (this.workInfo8 != null && StringUtils.isNotBlank(this.workInfo8.getWorkName())) {
            if (StringUtils.isBlank(job.getMainWork1())) {
                job.setMainWork1(this.workInfo8.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork2())) {
                job.setMainWork2(this.workInfo8.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork3())) {
                job.setMainWork3(this.workInfo8.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork4())) {
                job.setMainWork4(this.workInfo8.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork5())) {
                job.setMainWork5(this.workInfo8.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork6())) {
                job.setMainWork6(this.workInfo8.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork7())) {
                job.setMainWork7(this.workInfo8.getWorkName());
            } else {
                job.setMainWork8(this.workInfo8.getWorkName());
            }
        }
        if (this.workInfo9 != null && StringUtils.isNotBlank(this.workInfo9.getWorkName())) {
            if (StringUtils.isBlank(job.getMainWork1())) {
                job.setMainWork1(this.workInfo9.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork2())) {
                job.setMainWork2(this.workInfo9.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork3())) {
                job.setMainWork3(this.workInfo9.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork4())) {
                job.setMainWork4(this.workInfo9.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork5())) {
                job.setMainWork5(this.workInfo9.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork6())) {
                job.setMainWork6(this.workInfo9.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork7())) {
                job.setMainWork7(this.workInfo9.getWorkName());
            } else {
                job.setMainWork8(this.workInfo9.getWorkName());
            }
        }
        if (this.workInfo10 != null && StringUtils.isNotBlank(this.workInfo10.getWorkName())) {
            if (StringUtils.isBlank(job.getMainWork1())) {
                job.setMainWork1(this.workInfo10.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork2())) {
                job.setMainWork2(this.workInfo10.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork3())) {
                job.setMainWork3(this.workInfo10.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork4())) {
                job.setMainWork4(this.workInfo10.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork5())) {
                job.setMainWork5(this.workInfo10.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork6())) {
                job.setMainWork6(this.workInfo10.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork7())) {
                job.setMainWork7(this.workInfo10.getWorkName());
            } else {
                job.setMainWork8(this.workInfo10.getWorkName());
            }
        }
        if (this.workInfo11 != null && StringUtils.isNotBlank(this.workInfo11.getWorkName())) {
            if (StringUtils.isBlank(job.getMainWork1())) {
                job.setMainWork1(this.workInfo11.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork2())) {
                job.setMainWork2(this.workInfo11.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork3())) {
                job.setMainWork3(this.workInfo11.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork4())) {
                job.setMainWork4(this.workInfo11.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork5())) {
                job.setMainWork5(this.workInfo11.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork6())) {
                job.setMainWork6(this.workInfo11.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork7())) {
                job.setMainWork7(this.workInfo11.getWorkName());
            } else {
                job.setMainWork8(this.workInfo11.getWorkName());
            }
        }
        if (this.workInfo12 != null && StringUtils.isNotBlank(this.workInfo12.getWorkName())) {
            if (StringUtils.isBlank(job.getMainWork1())) {
                job.setMainWork1(this.workInfo12.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork2())) {
                job.setMainWork2(this.workInfo12.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork3())) {
                job.setMainWork3(this.workInfo12.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork4())) {
                job.setMainWork4(this.workInfo12.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork5())) {
                job.setMainWork5(this.workInfo12.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork6())) {
                job.setMainWork6(this.workInfo12.getWorkName());
            } else if (StringUtils.isBlank(job.getMainWork7())) {
                job.setMainWork7(this.workInfo12.getWorkName());
            } else {
                job.setMainWork8(this.workInfo12.getWorkName());
            }
        }
        return job;
    }
}