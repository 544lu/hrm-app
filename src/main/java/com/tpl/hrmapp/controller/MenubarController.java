package com.tpl.hrmapp.controller;

import com.tpl.hrmapp.domain.Department;
import com.tpl.hrmapp.presentation.MenuBarView;
import com.tpl.hrmapp.service.impl.DepartmentServiceImpl;
import com.tpl.hrmapp.service.impl.EmployeeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenubarController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DepartmentServiceImpl departmentService;
    @Autowired
    private EmployeeServiceImpl employeeService;

    /**
     * 根据levelId获取Department
     *
     * @return
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "getListByLevelId", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<MenuBarView> getListByLevelId() {
        Department department_1=departmentService.selectById(3);
        List<Department> departments_1;
        departments_1 = departmentService.selectListByPid(3);
        MenuBarView view_1=new MenuBarView();
        view_1.setId(department_1.getId());
        view_1.setText(department_1.getText());
        view_1.setChildren(departments_1);

        Department department_2=departmentService.selectById(4);
        List<Department> departments_2;
        departments_2 = departmentService.selectListByPid(4);
        MenuBarView view_2=new MenuBarView();
        view_2.setId(department_2.getId());
        view_2.setText(department_2.getText());
        view_2.setChildren(departments_2);

        List<MenuBarView> views=new ArrayList<>();
        views.add(view_1);
        views.add(view_2);
        return views;
    }

    /**
     * 根据pid获取Department
     *
     * @param pid
     * @return
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "getListByPid",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<Department> getListByPid(@RequestParam("pid") Integer pid) {
        List<Department> departments;
        departments = departmentService.selectListByPid(pid);
        return departments;
    }

    /**
     * 根据levelId获取Department
     *
     * @param levelId
     * @return
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "getListByLevelId", method = RequestMethod.POST)
    @ResponseBody
    public List<Department> getListByLevelId(@RequestParam("levelId") Integer levelId) {
        List<Department> departments;
        departments = departmentService.selectListByLevelId(levelId);
        return departments;
    }
     **/
}
