package com.tec.anji.controller;

import com.tec.anji.bean.Employee;
import com.tec.anji.mapper.EmployeeMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @PostMapping
    public Employee addEmp(@RequestBody Employee employee) {
        employeeMapper.insertEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict在方法执行之后调用，可以通过配置beforeInvocation改变执行顺序
     * @param id
     * @return
     */
    @CacheEvict(cacheNames = {"emp"}, key = "#id")
    @DeleteMapping("/{id}")
    public int deleteEmpById(@PathVariable int id) {
        boolean debug = true;
        return debug ? 1 : employeeMapper.deleteEmpById(id);
    }

    /**
     * @CachePut在方法执行后调用
     * @param employee
     * @return
     */
    @CachePut(cacheNames = {"emp"}, key = "#employee.id")
    @PutMapping
    public Employee updateEmp(@RequestBody Employee employee) {
        return 1 == employeeMapper.updateEmp(employee) ? getEmpById(employee.getId()) : null;
    }

    /**
     * @Cacheable在方法执行前调用
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"emp"}, condition = "#id > 1")
    @GetMapping("/{id}")
    public Employee getEmpById(@PathVariable int id) {
        return employeeMapper.getEmpById(id);
    }
}
