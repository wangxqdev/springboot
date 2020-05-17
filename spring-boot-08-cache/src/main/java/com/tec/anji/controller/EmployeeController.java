package com.tec.anji.controller;

import com.tec.anji.bean.Employee;
import com.tec.anji.mapper.EmployeeMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @PostMapping
    public Employee addEmp(Employee employee) {
        employeeMapper.insertEmp(employee);
        return employee;
    }

    @DeleteMapping("/{id}")
    public int deleteEmpById(@PathVariable int id) {
        return employeeMapper.deleteEmpById(id);
    }

    @PutMapping
    public int updateEmp(Employee employee) {
        return employeeMapper.updateEmp(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmpById(@PathVariable int id) {
        return employeeMapper.getEmpById(id);
    }
}
