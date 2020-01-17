package com.tpl.hrmapp.repository;

import com.tpl.hrmapp.domain.Employee;
import com.tpl.hrmapp.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
    //根据departmentId查询Job
    @Modifying
    @Query("select e from Employee e where departmentId=?1")
    List<Employee> selectById(Integer id);

    //根据employeeName查询
    @Query("select e from Employee e where employeeName like %?1%")
    List<Employee> selectByName(String employeeName);

    //根据jobId查询
    @Query("select e from Employee e where jobId=?1")
    Employee selectByJobId(Integer jobId);

    //更新员工关联deparrment_id及job_id
    @Query("update Employee e set deptId = ?1 , jobId = ?2 where employeeId = ?3")
    void updateDeptIdAndJobId(Integer deptId, Integer jobId, Integer employeeId);
}
