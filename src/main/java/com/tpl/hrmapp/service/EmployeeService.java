package com.tpl.hrmapp.service;

import com.tpl.hrmapp.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    //根据departmentId查询
    List<Employee> selectListByDepartmentId(Integer departmentId);

    //根据departmentId分页查询Employee
    Page<Employee> selectEmployeeByPage(Integer departmentId, Pageable pageable);

    //根据id查询Employee
    Employee selectById(Integer id);

    //根据employeeName查询数据
    List<Employee> selectByName(String employeeName);

    //根据jobId查询数据
    Employee selectByJobId(Integer jobId);

    //新增Employee
    Employee InsertEmployee(Employee employee);

    //更新Employee删除状态
    String deleteEmployee(Employee employee);
}
