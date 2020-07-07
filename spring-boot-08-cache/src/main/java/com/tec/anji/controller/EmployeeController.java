package com.tec.anji.controller;

import com.tec.anji.bean.Employee;
import com.tec.anji.mapper.EmployeeMapper;
import org.springframework.cache.annotation.*;
import org.springframework.web.bind.annotation.*;

@CacheConfig(cacheNames = {"emp"})
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
     * 注解@CacheEvict在方法执行之后调用，可以通过配置beforeInvocation改变执行顺序
     *
     * @param id
     * @return
     */
    @CacheEvict(key = "#id")
    @DeleteMapping("/{id}")
    public int deleteEmpById(@PathVariable int id) {
        boolean debug = true;
        return debug ? 1 : employeeMapper.deleteEmpById(id);
    }

    /**
     * 注解@CachePut在方法执行后调用
     *
     * @param employee
     * @return
     */
    @CachePut(key = "#employee.id")
    @PutMapping
    public Employee updateEmp(@RequestBody Employee employee) {
        return 1 == employeeMapper.updateEmp(employee) ? getEmpById(employee.getId()) : null;
    }

    /**
     * 注解@Cacheable在方法执行前调用
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#id", condition = "#id > 1")
    @GetMapping("/{id}")
    public Employee getEmpById(@PathVariable int id) {
        return employeeMapper.getEmpById(id);
    }

    @Caching(cacheable = {
            @Cacheable(key = "#email")
    }, put = {
            @CachePut(key = "#result.id")
    })
    @GetMapping("/email/{email}")
    public Employee getEmpByLastName(@PathVariable String email) {
        return employeeMapper.getEmpByEmail(email);
    }
}
