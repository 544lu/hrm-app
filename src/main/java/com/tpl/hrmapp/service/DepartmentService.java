package com.tpl.hrmapp.service;

import com.tpl.hrmapp.domain.Department;
import com.tpl.hrmapp.domain.Employee;

import java.util.List;

public interface DepartmentService {
    //根据id及levelId查询Department
    List<Department> selectListByLevelId(Integer id, Integer levelId);

    //根据levelId查询Department
    List<Department> selectListByLevelId(Integer levelId);

    //根据pid或者查询Department
    List<Department> selectListByPid(Integer pid);

    //根据id查询Department
    Department selectById(Integer id);

    //根据deptName查询Department
    Department selectByDeptName(String deptName);
}
