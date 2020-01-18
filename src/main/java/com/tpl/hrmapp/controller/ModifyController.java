package com.tpl.hrmapp.controller;

import com.tpl.hrmapp.domain.Department;
import com.tpl.hrmapp.domain.Employee;
import com.tpl.hrmapp.domain.Job;
import com.tpl.hrmapp.presentation.DescriptionView;
import com.tpl.hrmapp.presentation.MainJob;
import com.tpl.hrmapp.service.DepartmentService;
import org.apache.commons.lang3.StringUtils;
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
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public String updateEmployee(MainJob mainJob) {
        String result = "success";
        Job job = mainJob.createJob();

        //获取工作内容
        List<Job> works = new ArrayList<>();
        Job workContent1 = mainJob.getWorkInfo1().createWork();
        workContent1.setPid(job.getId());
        Job workContent2 = mainJob.getWorkInfo2().createWork();
        workContent2.setPid(job.getId());
        Job workContent3 = mainJob.getWorkInfo3().createWork();
        workContent3.setPid(job.getId());
        Job workContent4 = mainJob.getWorkInfo4().createWork();
        workContent4.setPid(job.getId());
        Job workContent5 = mainJob.getWorkInfo5().createWork();
        workContent5.setPid(job.getId());
        Job workContent6 = mainJob.getWorkInfo6().createWork();
        workContent6.setPid(job.getId());
        Job workContent7 = mainJob.getWorkInfo7().createWork();
        workContent7.setPid(job.getId());
        Job workContent8 = mainJob.getWorkInfo8().createWork();
        workContent8.setPid(job.getId());
        works.add(workContent1);
        works.add(workContent2);
        works.add(workContent3);
        works.add(workContent4);
        works.add(workContent5);
        works.add(workContent6);
        works.add(workContent7);
        works.add(workContent8);

        //更新人员岗位信息（岗位名称）
        Job jobUpdate = jobService.updateJob(job);
        //更新人员岗位信息失败
        if (jobUpdate.getId() == null) {
            result = "false";
            return result;
        }

        //批量更新工作内容
        List<Job> jobUpList = jobService.insertJob(works);
        //批量更新失败
        if (jobUpList.size() == 0) {
            result = "false";
            return result;
        }

        return result;
    }

    /**
     * 删除部门人员
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteEmployee(@RequestParam("id") Integer id) {
        String result = "success";
        if (id == null) {
            return "false";
        }

        Employee employee = employeeService.selectById(id);
        if (employee == null) {
            result = "false";
            return result;
        }
        employee.setDel(true);
        Employee newEmployee = employeeService.deleteEmployee(employee);
        if (newEmployee == null) {
            result = "false";
            return result;
        }
        return result;
    }
}
