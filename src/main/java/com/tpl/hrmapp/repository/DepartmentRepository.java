package com.tpl.hrmapp.repository;

import com.tpl.hrmapp.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    //根据id及levelId查询Department
    @Modifying
    @Query("select d from Department d where id=?1 and levelId =?2")
    List<Department> selectDepartmentByLevelId(Integer id, Integer levelId);

    //根据levelId查询department
    @Modifying
    @Query("select d from Department d where levelId =?1")
    List<Department> selectDepartmentByLevelId(Integer levelId);

    //根据pid查询department
    @Modifying
    @Query("select d from Department d where pid =?1")
    List<Department> selectDepartmentByPid(Integer pid);

    //根据deptName查询Department
    @Query("select d from Department d where text =?1")
    Department selectDepartmentByDeptName(String deptName);
}
