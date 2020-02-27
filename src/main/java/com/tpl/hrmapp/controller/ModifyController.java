package com.tpl.hrmapp.controller;

import com.tpl.hrmapp.common.util.IpMapping;
import com.tpl.hrmapp.domain.Department;
import com.tpl.hrmapp.domain.Employee;
import com.tpl.hrmapp.domain.Job;
import com.tpl.hrmapp.domain.Record;
import com.tpl.hrmapp.presentation.DescriptionView;
import com.tpl.hrmapp.presentation.HandleInfo;
import com.tpl.hrmapp.presentation.MainJob;
import com.tpl.hrmapp.service.DepartmentService;
import com.tpl.hrmapp.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tpl.hrmapp.service.EmployeeService;
import com.tpl.hrmapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private RecordService recordService;

    /**
     * 新增人员及岗位信息
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public HandleInfo insertEmployee(MainJob mainJob, HttpServletRequest request) {
        //验证操作是否被允许
        String requestUrl = request.getRemoteAddr();
        if (!(requestUrl.equals("0:0:0:0:0:0:0:1") || requestUrl.equals("10.122.4.86") || requestUrl.equals("10.122.4.100") || requestUrl.equals("10.122.4.202"))) {
            return new HandleInfo("false", "无相关操作权限！" + request.getRemoteAddr());
        }

        Job job = mainJob.createJob();

        //保存Employee
        Department dept = departmentService.selectByDeptName(mainJob.getDeptName());
        if (dept == null) {
            return new HandleInfo("false", "部门名称输入有误");
        }

        //保存人员岗位信息（岗位名称）
        Job jobUpdate = jobService.updateJob(job);
        //更新人员岗位信息失败
        if (jobUpdate.getId() == null) {
            return new HandleInfo("false", "更新人员岗位信息失败");
        }

        //获取工作内容
        List<Job> works = new ArrayList<>();
        if (mainJob.getWorkInfo1() != null) {
            Job workContent1 = mainJob.getWorkInfo1().createWork();
            workContent1.setPid(job.getId());
            works.add(workContent1);
        }
        if (mainJob.getWorkInfo2() != null) {
            Job workContent2 = mainJob.getWorkInfo2().createWork();
            workContent2.setPid(job.getId());
            works.add(workContent2);
        }
        if (mainJob.getWorkInfo3() != null) {
            Job workContent3 = mainJob.getWorkInfo3().createWork();
            workContent3.setPid(job.getId());
            works.add(workContent3);
        }
        if (mainJob.getWorkInfo4() != null) {
            Job workContent4 = mainJob.getWorkInfo4().createWork();
            workContent4.setPid(job.getId());
            works.add(workContent4);
        }
        if (mainJob.getWorkInfo5() != null) {
            Job workContent5 = mainJob.getWorkInfo5().createWork();
            workContent5.setPid(job.getId());
            works.add(workContent5);
        }
        if (mainJob.getWorkInfo6() != null) {
            Job workContent6 = mainJob.getWorkInfo6().createWork();
            workContent6.setPid(job.getId());
            works.add(workContent6);
        }
        if (mainJob.getWorkInfo7() != null) {
            Job workContent7 = mainJob.getWorkInfo7().createWork();
            workContent7.setPid(job.getId());
            works.add(workContent7);
        }
        if (mainJob.getWorkInfo8() != null) {
            Job workContent8 = mainJob.getWorkInfo8().createWork();
            workContent8.setPid(job.getId());
            works.add(workContent8);
        }
        if (mainJob.getWorkInfo9() != null) {
            Job workContent9 = mainJob.getWorkInfo9().createWork();
            workContent9.setPid(job.getId());
            works.add(workContent9);
        }
        if (mainJob.getWorkInfo10() != null) {
            Job workContent10 = mainJob.getWorkInfo10().createWork();
            workContent10.setPid(job.getId());
            works.add(workContent10);
        }
        if (mainJob.getWorkInfo11() != null) {
            Job workContent11 = mainJob.getWorkInfo11().createWork();
            workContent11.setPid(job.getId());
            works.add(workContent11);
        }
        if (mainJob.getWorkInfo12() != null) {
            Job workContent12 = mainJob.getWorkInfo12().createWork();
            workContent12.setPid(job.getId());
            works.add(workContent12);
        }

        for (Job jobInsert : works) {
            Job j = jobService.insertJob(jobInsert);
            if (j == null) {
                return new HandleInfo("false", "添加操作失败");
            }
        }

        Employee employee = mainJob.createEmployee();
        employee.setDepartmentId(dept.getId());
        employee.setJobId(jobUpdate.getId());
        Employee emp = employeeService.InsertEmployee(employee);
        if (emp != null) {
            //添加记录
            boolean operateRe = this.addModifyRecord(requestUrl, "添加", emp);
            if (operateRe == false) {
                log.info("操作：添加员工，写入历史记录失败");
            }
            return new HandleInfo("success", "添加操作成功");
        } else {
            return new HandleInfo("false", "添加操作失败");
        }
    }

    /**
     * 修改人员及岗位信息
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public HandleInfo updateEmployee(MainJob mainJob, HttpServletRequest request) {
        boolean addRecord = false;
        //验证操作是否被允许
        String requestUrl = request.getRemoteAddr();
        if (!(requestUrl.equals("0:0:0:0:0:0:0:1") || requestUrl.equals("10.122.4.86") || requestUrl.equals("10.122.4.100") || requestUrl.equals("10.122.4.202"))) {
            IpMapping ipMapping = new IpMapping();
            boolean result = ipMapping.permissionVerif(requestUrl);
            if (result == true) {
                String deptName = ipMapping.limitOperation(requestUrl);
                if (!deptName.equals(mainJob.getDeptName())) {
                    return new HandleInfo("false", "无操作该部门权限！" + request.getRemoteAddr());
                }
            } else {
                return new HandleInfo("false", "无相关操作权限！" + request.getRemoteAddr());
            }
        }

        //工作转换，直接更改employeeName
        Employee employee = employeeService.selectById(mainJob.getEmployeeId());
        if (!employee.getEmployeeName().equals(mainJob.getEmployeeName())) {
            employee.setEmployeeName(mainJob.getEmployeeName());
            Employee updatedEmployee = employeeService.updateEmployee(employee);
            if (updatedEmployee == null) {
                return new HandleInfo("false", "更新人员岗位信息失败");
            }
            //添加记录
            boolean operateRe = this.addModifyRecord(requestUrl, "交接", updatedEmployee, mainJob.getJobName());
            addRecord = true;
            if (operateRe == false) {
                log.info("操作：添加员工，写入历史记录失败");
            }
        }

        Job job = mainJob.createJob();

        //获取工作内容
        List<Job> works = new ArrayList<>();
        if (mainJob.getWorkInfo1() != null) {
            Job workContent1 = mainJob.getWorkInfo1().createWork();
            workContent1.setPid(job.getId());
            works.add(workContent1);
        }
        if (mainJob.getWorkInfo2() != null) {
            Job workContent2 = mainJob.getWorkInfo2().createWork();
            workContent2.setPid(job.getId());
            works.add(workContent2);
        }
        if (mainJob.getWorkInfo3() != null) {
            Job workContent3 = mainJob.getWorkInfo3().createWork();
            workContent3.setPid(job.getId());
            works.add(workContent3);
        }
        if (mainJob.getWorkInfo4() != null) {
            Job workContent4 = mainJob.getWorkInfo4().createWork();
            workContent4.setPid(job.getId());
            works.add(workContent4);
        }
        if (mainJob.getWorkInfo5() != null) {
            Job workContent5 = mainJob.getWorkInfo5().createWork();
            workContent5.setPid(job.getId());
            works.add(workContent5);
        }
        if (mainJob.getWorkInfo6() != null) {
            Job workContent6 = mainJob.getWorkInfo6().createWork();
            workContent6.setPid(job.getId());
            works.add(workContent6);
        }
        if (mainJob.getWorkInfo7() != null) {
            Job workContent7 = mainJob.getWorkInfo7().createWork();
            workContent7.setPid(job.getId());
            works.add(workContent7);
        }
        if (mainJob.getWorkInfo8() != null) {
            Job workContent8 = mainJob.getWorkInfo8().createWork();
            workContent8.setPid(job.getId());
            works.add(workContent8);
        }
        if (mainJob.getWorkInfo9() != null) {
            Job workContent9 = mainJob.getWorkInfo9().createWork();
            workContent9.setPid(job.getId());
            works.add(workContent9);
        }
        if (mainJob.getWorkInfo10() != null) {
            Job workContent10 = mainJob.getWorkInfo10().createWork();
            workContent10.setPid(job.getId());
            works.add(workContent10);
        }
        if (mainJob.getWorkInfo11() != null) {
            Job workContent11 = mainJob.getWorkInfo11().createWork();
            workContent11.setPid(job.getId());
            works.add(workContent11);
        }
        if (mainJob.getWorkInfo12() != null) {
            Job workContent12 = mainJob.getWorkInfo12().createWork();
            workContent12.setPid(job.getId());
            works.add(workContent12);
        }

        //更新人员岗位信息（岗位名称）
        Job jobUpdate = jobService.updateJob(job);
        //更新人员岗位信息失败
        if (jobUpdate.getId() == null) {
            return new HandleInfo("false", "更新人员岗位信息失败");
        }

        //查询更新前每个岗位包含的工作内容
        List<Job> jobList = jobService.selectJobByPid(mainJob.getJobId());
        if (jobList.size() == 0) {
            return new HandleInfo("false", "查询工作内容失败");
        }
        //更新或者删除旧的工作内容
        for (Job jobOld : jobList) {
            int index = 1;
            for (Job jobNew : works) {
                if (jobNew.getId().intValue() == jobOld.getId().intValue()) {
                    jobService.updateJob(jobNew);
                    break;
                }
                if (index == works.size()) {
                    jobService.deleteJob(jobOld);
                }
                index++;
            }
        }
        //添加新增工作内容
        for (Job jobInsert : works) {
            if (jobInsert.getId() == null) {
                jobService.insertJob(jobInsert);
            }
        }
        //添加记录
        if (!addRecord) {
            boolean operateRe = this.addModifyRecord(requestUrl, "更新", employee);
            if (operateRe == false) {
                log.info("操作：更新员工工作内容，写入历史记录失败");
            }
        }
        return new HandleInfo("success", "更新成功");
    }

    /**
     * 删除部门人员
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ResponseBody
    public HandleInfo deleteEmployee(@RequestParam("id") Integer id, HttpServletRequest request) {
        //验证操作是否被允许
        String requestUrl = request.getRemoteAddr();

        if (id == null) {
            return new HandleInfo("false", "查询参数为空");
        }

        Employee employee = employeeService.selectById(id);
        System.out.print(employee.getEmployeeName());
        if (employee == null) {
            System.out.print(employee.getEmployeeName());
            return new HandleInfo("false", "无对应数据");
        }

        //验证操作权限
        if (!(requestUrl.equals("0:0:0:0:0:0:0:1") || requestUrl.equals("10.122.4.86") || requestUrl.equals("10.122.4.100") || requestUrl.equals("10.122.4.202"))) {
            Department dept = departmentService.selectById(employee.getDepartmentId());
            IpMapping ipMapping = new IpMapping();
            boolean re = ipMapping.permissionVerif(requestUrl);
            if (re == true) {
                String deptName = ipMapping.limitOperation(requestUrl);
                if (!deptName.equals(dept.getText())) {
                    return new HandleInfo("false", "无操作该部门权限！" + request.getRemoteAddr());
                }
            } else {
                return new HandleInfo("false", "无相关操作权限！" + request.getRemoteAddr());
            }
        }

        employee.setDel(true);
        String result = employeeService.deleteEmployee(employee);
        if (result.equals("falure")) {
            return new HandleInfo("false", "删除失败");
        }
        return new HandleInfo("success", "删除成功");
    }

    //添加操作记录
    public boolean addModifyRecord(String modifier, String operationCate, Employee em) {
        Record record = new Record(modifier, operationCate, em);
        Record re = recordService.insertRecord(record);
        if (re == null) {
            return false;
        }
        return true;
    }

    //添加操作记录
    public boolean addModifyRecord(String modifier, String operationCate, Employee em, String jobName) {
        Record record = new Record(modifier, operationCate, em, jobName);
        Record re = recordService.insertRecord(record);
        if (re == null) {
            return false;
        }
        return true;
    }
}
