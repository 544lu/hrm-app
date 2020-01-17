package com.tpl.hrmapp.presentation;

import com.tpl.hrmapp.domain.Employee;
import com.tpl.hrmapp.domain.Job;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DescriptionView {
    private String employeeName;
    private String deptName;
    private String jobName;
    private String mainWork1;
    private String mainWork2;
    private String mainWork3;
    private String mainWork4;
    private String mainWork5;
    private String mainWork6;
    private String mainWork7;
    private String mainWork8;
    private String mainWorkDes1;
    private String mainWorkDes2;
    private String mainWorkDes3;
    private String mainWorkDes4;
    private String mainWorkDes5;
    private String mainWorkDes6;
    private String mainWorkDes7;
    private String mainWorkDes8;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
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

    public String getMainWorkDes1() {
        return mainWorkDes1;
    }

    public void setMainWorkDes1(String mainWorkDes1) {
        this.mainWorkDes1 = mainWorkDes1;
    }

    public String getMainWorkDes2() {
        return mainWorkDes2;
    }

    public void setMainWorkDes2(String mainWorkDes2) {
        this.mainWorkDes2 = mainWorkDes2;
    }

    public String getMainWorkDes3() {
        return mainWorkDes3;
    }

    public void setMainWorkDes3(String mainWorkDes3) {
        this.mainWorkDes3 = mainWorkDes3;
    }

    public String getMainWorkDes4() {
        return mainWorkDes4;
    }

    public void setMainWorkDes4(String mainWorkDes4) {
        this.mainWorkDes4 = mainWorkDes4;
    }

    public String getMainWorkDes5() {
        return mainWorkDes5;
    }

    public void setMainWorkDes5(String mainWorkDes5) {
        this.mainWorkDes5 = mainWorkDes5;
    }

    public String getMainWorkDes6() {
        return mainWorkDes6;
    }

    public void setMainWorkDes6(String mainWorkDes6) {
        this.mainWorkDes6 = mainWorkDes6;
    }

    public String getMainWorkDes7() {
        return mainWorkDes7;
    }

    public void setMainWorkDes7(String mainWorkDes7) {
        this.mainWorkDes7 = mainWorkDes7;
    }

    public String getMainWorkDes8() {
        return mainWorkDes8;
    }

    public void setMainWorkDes8(String mainWorkDes8) {
        this.mainWorkDes8 = mainWorkDes8;
    }

    public Job createJob() {
        Job job = new Job();
        job.setJobName(this.getJobName());
        job.setDel(false);
        if (StringUtils.isNotBlank(this.getMainWork1())) {
            job.setMainWork1(this.getMainWork1());
        }
        if (StringUtils.isNotBlank(this.getMainWork2())) {
            job.setMainWork2(this.getMainWork2());
        }
        if (StringUtils.isNotBlank(this.getMainWork3())) {
            job.setMainWork3(this.getMainWork3());
        }
        if (StringUtils.isNotBlank(this.getMainWork4())) {
            job.setMainWork4(this.getMainWork4());
        }
        if (StringUtils.isNotBlank(this.getMainWork5())) {
            job.setMainWork5(this.getMainWork5());
        }
        if (StringUtils.isNotBlank(this.getMainWork6())) {
            job.setMainWork6(this.getMainWork6());
        }
        if (StringUtils.isNotBlank(this.getMainWork7())) {
            job.setMainWork7(this.getMainWork7());
        }
        if (StringUtils.isNotBlank(this.getMainWork8())) {
            job.setMainWork8(this.getMainWork8());
        }
        return job;
    }

    public List<Job> createJobDes(Integer pid) {
        List<Job> jobList=new ArrayList<>();
        if (StringUtils.isNotBlank(this.getMainWork1())) {
            Job job = new Job();
            job.setJobName(this.getMainWork1());
            job.setPid(pid);
            job.setDel(false);
            job.setMainWork1(this.getMainWorkDes1());
            jobList.add(job);
        }
        if (StringUtils.isNotBlank(this.getMainWork2())) {
            Job job = new Job();
            job.setJobName(this.getMainWork2());
            job.setPid(pid);
            job.setDel(false);
            job.setMainWork1(this.getMainWorkDes2());
            jobList.add(job);
        }
        if (StringUtils.isNotBlank(this.getMainWork3())) {
            Job job = new Job();
            job.setJobName(this.getMainWork3());
            job.setPid(pid);
            job.setDel(false);
            job.setMainWork1(this.getMainWorkDes3());
            jobList.add(job);
        }
        if (StringUtils.isNotBlank(this.getMainWork4())) {
            Job job = new Job();
            job.setJobName(this.getMainWork4());
            job.setPid(pid);
            job.setDel(false);
            job.setMainWork1(this.getMainWorkDes4());
            jobList.add(job);
        }
        if (StringUtils.isNotBlank(this.getMainWork5())) {
            Job job = new Job();
            job.setJobName(this.getMainWork5());
            job.setPid(pid);
            job.setDel(false);
            job.setMainWork1(this.getMainWorkDes5());
            jobList.add(job);
        }
        if (StringUtils.isNotBlank(this.getMainWork6())) {
            Job job = new Job();
            job.setJobName(this.getMainWork6());
            job.setPid(pid);
            job.setDel(false);
            job.setMainWork1(this.getMainWorkDes6());
            jobList.add(job);
        }
        if (StringUtils.isNotBlank(this.getMainWork7())) {
            Job job = new Job();
            job.setJobName(this.getMainWork7());
            job.setPid(pid);
            job.setDel(false);
            job.setMainWork1(this.getMainWorkDes7());
            jobList.add(job);
        }
        if (StringUtils.isNotBlank(this.getMainWork8())) {
            Job job = new Job();
            job.setJobName(this.getMainWork8());
            job.setPid(pid);
            job.setDel(false);
            job.setMainWork1(this.getMainWorkDes8());
            jobList.add(job);
        }
        return jobList;
    }

    public Employee createEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName(this.getEmployeeName());
        employee.setDel(false);
        return employee;
    }
}
