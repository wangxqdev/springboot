package com.tec.anji.controller;

import com.tec.anji.dao.DepartmentDao;
import com.tec.anji.dao.EmployeeDao;
import com.tec.anji.entities.Department;
import com.tec.anji.entities.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        log.info("Create employee = {}", employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable int id, Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmp(Employee employee) {
        log.info("Modify employee = {}", employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable int id) {
        log.info("Delete employee where id = {}", id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
