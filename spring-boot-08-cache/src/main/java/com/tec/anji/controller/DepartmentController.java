package com.tec.anji.controller;

import com.tec.anji.bean.Department;
import com.tec.anji.mapper.DepartementMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@CacheConfig(cacheNames = {"dept"}, cacheManager = "departmentCacheManager")
@RestController
@RequestMapping("/dept")
public class DepartmentController {

    public final DepartementMapper departementMapper;

    public DepartmentController(DepartementMapper departementMapper) {
        this.departementMapper = departementMapper;
    }

    @PostMapping
    public Department addDept(Department department) {
        departementMapper.insertDept(department);
        return department;
    }

    @Cacheable(key = "#id")
    @GetMapping("/{id}")
    public Department getDeptById(@PathVariable int id) {
        return departementMapper.getDeptById(id);
    }
}
