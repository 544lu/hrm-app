package com.tpl.hrmapp.controller;

import com.tpl.hrmapp.domain.Department;
import com.tpl.hrmapp.domain.Employee;
import com.tpl.hrmapp.domain.Job;
import com.tpl.hrmapp.presentation.DescriptionView;
import com.tpl.hrmapp.presentation.EmployeeView;
import com.tpl.hrmapp.presentation.QueryEmployeeParam;
import com.tpl.hrmapp.service.impl.DepartmentServiceImpl;
import com.tpl.hrmapp.service.impl.EmployeeServiceImpl;
import com.tpl.hrmapp.service.impl.JobServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FormPageController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private JobServiceImpl jobService;
    @Autowired
    private DepartmentServiceImpl departmentService;

    //检索功能实现
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "getPageSet", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public EmployeeView getPageSet(QueryEmployeeParam param, HttpServletRequest request) {
        String name = param.getName();
        if (StringUtils.isBlank(name)) {
            String[] pros = {"id"};
            Pageable pageable = PageRequest.of(param.getPage() - 1, param.getRows(), Sort.Direction.ASC, pros);
            Integer departmentId = param.getId();
            Page<Employee> employees;
            try {
                employees = employeeService.selectEmployeeByPage(departmentId, pageable);
            } catch (Exception e) {
                log.error("在查询Employee集合时出错");
                e.printStackTrace();
                return null;
            }
            List<Employee> employeeList = employees.toList();
            for (Employee employee : employeeList) {
                if (employee.getDepartmentId() != null) {
                    Department dept = departmentService.selectById(employee.getDepartmentId());
                    employee.setDepartmentName(dept.getText());
                    Job job = jobService.selectById(employee.getJobId());
                    employee.setJobName(job.getJobName());
                }
            }
            long total = employees.getTotalElements();
            EmployeeView view = new EmployeeView(param.getPage(), employeeList, total);
            return view;
        } else if (name.equals("overall")) {
            Map<Integer, Employee> employeeMap = new HashMap<>();
            try {
                //检索员工姓名
                List<Employee> employeeList_1 = employeeService.selectByName(param.getValue());
                for (Employee employee : employeeList_1) {
                    employeeMap.put(employee.getId(), employee);
                }
                //检索岗位名称
                List<Job> jobList_1 = jobService.overallByJobName(param.getValue());
                if (jobList_1.size() != 0) {
                    for (Job job : jobList_1) {
                        Employee employee = employeeService.selectByJobId(job.getId());
                        if (employee != null && !employeeMap.containsKey(employee.getId())) {
                            employeeMap.put(employee.getId(), employee);
                        }
                    }
                }
                //检索主要工作
                List<Job> jobList_2 = jobService.overallByMainWork(param.getValue());
                if (jobList_2.size() != 0) {
                    for (Job job : jobList_2) {
                        Employee employee = employeeService.selectByJobId(job.getPid());
                        if (employee != null && !employeeMap.containsKey(employee.getId())) {
                            employeeMap.put(employee.getId(), employee);
                        }
                    }
                }
                //检索关键字
                List<Job> jobList_3 = jobService.selectJobByKeywords(param.getValue());
                if (jobList_3.size() != 0) {
                    for (Job job : jobList_3) {
                        Employee employee = employeeService.selectByJobId(job.getId());
                        if (employee != null && !employeeMap.containsKey(employee.getId())) {
                            employeeMap.put(employee.getId(), employee);
                        }
                    }
                }
            } catch (Exception e) {
                log.error("在查询Employee集合时出错");
                e.printStackTrace();
                return null;
            }
            List<Employee> employeeList = new ArrayList<>(employeeMap.values());
            for (Employee employee : employeeList) {
                if (employee.getDepartmentId() != null) {
                    Department dept = departmentService.selectById(employee.getDepartmentId());
                    employee.setDepartmentName(dept.getText());
                    Job job = jobService.selectById(employee.getJobId());
                    employee.setJobName(job.getJobName());
                }
            }
            long total = employeeList.size();
            int pageNum = param.getPage();
            int pageSize = param.getRows();
            if (total < pageSize && pageNum == 1) {
                EmployeeView view = new EmployeeView(param.getPage(), employeeList, total);
                return view;
            } else if (total >= pageSize && pageNum == 1) {
                EmployeeView view = new EmployeeView(param.getPage(), employeeList.subList(0, pageSize), total);
                return view;
            } else {
                if (employeeList.size() > pageNum * pageSize) {
                    EmployeeView view = new EmployeeView(param.getPage(), employeeList.subList((pageNum - 1) * pageSize, pageNum * pageSize), total);
                    return view;
                } else {
                    EmployeeView view = new EmployeeView(param.getPage(), employeeList.subList((pageNum - 1) * pageSize, employeeList.size()), total);
                    return view;
                }
            }
        } else {
            List<Employee> employeeList = new ArrayList<>();
            try {
                if (name.equals("name")) {
                    employeeList = employeeService.selectByName(param.getValue());
                } else {
                    List<Job> jobs = jobService.selectJobByKeywords(param.getValue());
                    for (Job job : jobs) {
                        Employee employee = employeeService.selectByJobId(job.getId());
                        if (employee != null) {
                            employeeList.add(employee);
                        }
                    }
                }
            } catch (Exception e) {
                log.error("在查询Employee集合时出错");
                e.printStackTrace();
                return null;
            }
            for (Employee employee : employeeList) {
                if (employee.getDepartmentId() != null) {
                    Department dept = departmentService.selectById(employee.getDepartmentId());
                    employee.setDepartmentName(dept.getText());
                    Job job = jobService.selectById(employee.getJobId());
                    employee.setJobName(job.getJobName());
                }
            }
            long total = employeeList.size();
            EmployeeView view = new EmployeeView(param.getPage(), employeeList, total);
            return view;
        }
    }

    //查看员工岗位信息
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "getById", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public DescriptionView getEmployeeById(@RequestParam("id") Integer id) {
        Employee employee = employeeService.selectById(id);
        Integer deptId = employee.getDepartmentId();
        Integer jobId = employee.getJobId();
        DescriptionView view = new DescriptionView();
        view.setEmployeeId(employee.getId());
        view.setEmployeeName(employee.getEmployeeName());
        Department dept = departmentService.selectById(deptId);
        view.setDeptId(dept.getId());
        view.setDeptName(dept.getText());
        Job job = jobService.selectById(jobId);
        view.setJobId(job.getId());
        view.setJobName(job.getJobName());
        List<String> works = new ArrayList<>();
        if (job.getMainWork1() != null) {
            works.add(job.getMainWork1());
            view.setMainWork1(job.getMainWork1());
        }
        if (job.getMainWork2() != null) {
            works.add(job.getMainWork2());
            view.setMainWork2(job.getMainWork2());
        }
        if (job.getMainWork3() != null) {
            works.add(job.getMainWork3());
            view.setMainWork3(job.getMainWork3());
        }
        if (job.getMainWork4() != null) {
            works.add(job.getMainWork4());
            view.setMainWork4(job.getMainWork4());
        }
        if (job.getMainWork5() != null) {
            works.add(job.getMainWork5());
            view.setMainWork5(job.getMainWork5());
        }
        if (job.getMainWork6() != null) {
            works.add(job.getMainWork6());
            view.setMainWork6(job.getMainWork6());
        }
        if (job.getMainWork7() != null) {
            works.add(job.getMainWork7());
            view.setMainWork7(job.getMainWork7());
        }
        if (job.getMainWork8() != null) {
            works.add(job.getMainWork8());
            view.setMainWork8(job.getMainWork8());
        }
        for (String str : works) {
            Job mainJob = jobService.selectByPidAndJobName(jobId, str);
            if (mainJob != null && view.getMainWorkDes1() == null) {
                view.setWork1Id(mainJob.getId());
                view.setMainWorkDes1(mainJob.getMainWork1());
                continue;
            }
            if (mainJob != null && view.getMainWorkDes2() == null) {
                view.setWork2Id(mainJob.getId());
                view.setMainWorkDes2(mainJob.getMainWork1());
                continue;
            }
            if (mainJob != null && view.getMainWorkDes3() == null) {
                view.setWork3Id(mainJob.getId());
                view.setMainWorkDes3(mainJob.getMainWork1());
                continue;
            }
            if (mainJob != null && view.getMainWorkDes4() == null) {
                view.setWork4Id(mainJob.getId());
                view.setMainWorkDes4(mainJob.getMainWork1());
                continue;
            }
            if (mainJob != null && view.getMainWorkDes5() == null) {
                view.setWork5Id(mainJob.getId());
                view.setMainWorkDes5(mainJob.getMainWork1());
                continue;
            }
            if (mainJob != null && view.getMainWorkDes6() == null) {
                view.setWork6Id(mainJob.getId());
                view.setMainWorkDes6(mainJob.getMainWork1());
                continue;
            }
            if (mainJob != null && view.getMainWorkDes7() == null) {
                view.setWork7Id(mainJob.getId());
                view.setMainWorkDes7(mainJob.getMainWork1());
                continue;
            }
            if (mainJob != null && view.getMainWorkDes8() == null) {
                view.setWork8Id(mainJob.getId());
                view.setMainWorkDes8(mainJob.getMainWork1());
                continue;
            }
        }
        return view;
    }

    /**
     @CrossOrigin(origins = "*")
     @RequestMapping(value = "searchEmployee", method = RequestMethod.POST)
     @ResponseBody public EmployeeView searchEmployee(QueryEmployeeParam param) {
     String name = param.getName();
     List<Employee> employeeList=new ArrayList<>();
     try {
     if (name.equals("name")) {
     employeeList = employeeService.selectByName(param.getValue());
     } else {
     List<Job> jobs = jobService.selectJobByKeywords(param.getValue());
     for(Job job:jobs){
     Employee employee=employeeService.selectByJobId(job.getId());
     employeeList.add(employee);
     }
     }
     } catch (Exception e) {
     log.error("在查询Employee集合时出错");
     e.printStackTrace();
     return null;
     }
     for (Employee employee : employeeList) {
     Department dept = departmentService.selectById(employee.getDepartmentId());
     employee.setDepartmentName(dept.getText());
     Job job = jobService.selectById(employee.getJobId());
     employee.setJobName(job.getJobName());
     }
     long total = employeeList.size();
     EmployeeView view = new EmployeeView(param.getPage(), employeeList, total);
     return view;
     }
     **/
}
