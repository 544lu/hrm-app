package com.tpl.hrmapp.service.impl;

import com.tpl.hrmapp.domain.Department;
import com.tpl.hrmapp.domain.Employee;
import com.tpl.hrmapp.repository.DepartmentRepository;
import com.tpl.hrmapp.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DepartmentRepository departmentRepo;

    /**
     * 按levelId查询Department
     *
     * @param id
     * @param levelId
     * @return
     */
    @Override
    public List<Department> selectListByLevelId(Integer id, Integer levelId) {
        List<Department> departments = new ArrayList<>();
        try {
            departments = departmentRepo.selectDepartmentByLevelId(id, levelId);
        } catch (Exception e) {
            log.error("查询部门时出错");
            e.printStackTrace();
        }
        return departments;
    }

    /**
     * 根据levelId查询Department
     *
     * @param levelId
     * @return
     */
    @Override
    public List<Department> selectListByLevelId(Integer levelId) {
        List<Department> departments = new ArrayList<>();
        try {
            departments = departmentRepo.selectDepartmentByLevelId(levelId);
        } catch (Exception e) {
            log.error("查询部门时出错");
            e.printStackTrace();
        }
        return departments;
    }

    /**
     * 根据pid查询Department
     *
     * @param pid
     * @return
     */
    @Override
    public List<Department> selectListByPid(Integer pid) {
        List<Department> departments = new ArrayList<>();
        try {
            departments = departmentRepo.selectDepartmentByPid(pid);
        } catch (Exception e) {
            log.error("查询部门时出错");
            e.printStackTrace();
        }
        return departments;
    }

    /**
     * 根据主键id查询Department
     *
     * @param id
     * @return
     */
    @Override
    public Department selectById(Integer id) {
        Department department = new Department();
        try {
            department = departmentRepo.getOne(id);
        } catch (Exception e) {
            log.error("查询部门时出错");
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public Department selectByDeptName(String deptName) {
        Department dept = null;
        try {
            dept = departmentRepo.selectDepartmentByDeptName(deptName);
        } catch (Exception e) {
            log.error("根据deptName查询Department时出错");
            e.printStackTrace();
        }
        return dept;
    }
}
