package com.tpl.hrmapp.controller;

import com.tpl.hrmapp.domain.Department;
import com.tpl.hrmapp.domain.Employee;
import com.tpl.hrmapp.domain.Job;
import com.tpl.hrmapp.presentation.DescriptionView;
import com.tpl.hrmapp.presentation.MainJob;
import com.tpl.hrmapp.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tpl.hrmapp.service.EmployeeService;
import com.tpl.hrmapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ModifyController {
    /**
     * 新增或者更新岗位信息
     * 编辑于 2020.1.16
     */

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JobService jobService;
    @Autowired
    private DepartmentService departmentService;

    /**
     * 新增人员及岗位信息
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public String insertEmployee(DescriptionView view) {
        String result = "success";
        Department dept = departmentService.selectByDeptName(view.getDeptName());
        Job job = view.createJob();
        List<Job> jobList1 = new ArrayList<>();
        jobList1.add(job);
        List<Job> jobs = jobService.insertJob(jobList1);

        Integer id = 0;
        List<Job> jobList = new ArrayList<>();
        if (jobs.size() != 0) {
            id = jobs.get(0).getId();
            jobList = view.createJobDes(id);
        }
        List<Job> jobList3 = jobService.insertJob(jobList);
        if (jobList3.size() == 0) {
            result = "false";
        }

        Employee employee = view.createEmployee();
        employee.setDepartmentId(dept.getId());
        employee.setJobId(id);
        employeeService.InsertEmployee(employee);
        return result;
    }

    /**
     * 修改人员及岗位信息
     */
    /**
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public String updateEmployee(MainJob mainJob){
        String result = "success";
        Job
        Department dept = departmentService.selectByDeptName(view.getDeptName());
        Job job = view.createJob();
        List<Job> jobList1 = new ArrayList<>();
        jobList1.add(job);
        List<Job> jobs = jobService.insertJob(jobList1);

        Integer id = 0;
        List<Job> jobList = new ArrayList<>();
        if (jobs.size() != 0) {
            id = jobs.get(0).getId();
            jobList = view.createJobDes(id);
        }
        List<Job> jobList3 = jobService.insertJob(jobList);
        if (jobList3.size() == 0) {
            result = "false";
        }

        Employee employee = view.createEmployee();
        employee.setDepartmentId(dept.getId());
        employee.setJobId(id);
        employeeService.InsertEmployee(employee);
        return result;
    }
    */
}
