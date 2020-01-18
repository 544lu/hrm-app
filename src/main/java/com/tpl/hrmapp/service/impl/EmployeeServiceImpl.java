package com.tpl.hrmapp.service.impl;

import com.tpl.hrmapp.domain.Employee;
import com.tpl.hrmapp.repository.EmployeeRepository;
import com.tpl.hrmapp.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeRepository employeeRepo;

    /**
     * 按departmentId查询Employee集合
     *
     * @param departmentId
     * @return
     */
    @Override
    public List<Employee> selectListByDepartmentId(Integer departmentId) {
        List<Employee> employees = new ArrayList<>();
        try {
            employees = employeeRepo.selectById(departmentId);
        } catch (Exception e) {
            log.error("通过departmentId查询Employee时出错");
            e.printStackTrace();
        }
        return employees;
    }

    /**
     * 根据departmentId分页查询Employee
     *
     * @param departmentId
     * @param pageable
     * @return
     */
    @Override
    public Page<Employee> selectEmployeeByPage(Integer departmentId, Pageable pageable) {
        return employeeRepo.findAll(new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                Predicate idEqual = null;
                if (null != departmentId) {
                    idEqual = cb.equal(root.<Integer>get("departmentId"), departmentId);
                }
                if (null != idEqual) query.where(idEqual);
                return idEqual;
            }
        }, pageable);
    }

    /**
     * 根据id查询Employee
     *
     * @param id
     * @return
     */
    @Override
    public Employee selectById(Integer id) {
        Employee employee = new Employee();
        try {
            employee = employeeRepo.getOne(id);
        } catch (Exception e) {
            log.error("根据id查询Employee时出错");
            e.printStackTrace();
        }
        return employee;
    }

    /**
     * 根据emploeeName查询Employee
     *
     * @param employeeName
     * @return
     */
    @Override
    public List<Employee> selectByName(String employeeName) {
        List<Employee> employees = new ArrayList<>();
        try {
            employees = employeeRepo.selectByName(employeeName);
        } catch (Exception e) {
            log.error("根据employeeName查询Employee时出错");
            e.printStackTrace();
        }
        return employees;
    }

    /**
     * 根据jobId查询Employee
     *
     * @param jobId
     * @return
     */
    @Override
    public Employee selectByJobId(Integer jobId) {
        Employee employee = new Employee();
        try {
            employee = employeeRepo.selectByJobId(jobId);
        } catch (Exception e) {
            log.error("根据employeeName查询Employee时出错");
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void InsertEmployee(Employee employee) {
        try {
            employeeRepo.save(employee);
        } catch (Exception e) {
            log.error("新增/更新Employee时出错");
            e.printStackTrace();
        }
    }

    //更新Employee删除状态
    @Override
    public Employee deleteEmployee(Employee employee) {
        Employee ep = null;
        try {
            ep = employeeRepo.save(employee);
        } catch (Exception e) {
            log.error("更新Employee删除状态时出错");
            e.printStackTrace();
        }
        return ep;
    }
}
