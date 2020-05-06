package com.tec.anji.mapper;

import com.tec.anji.bean.Employee;

public interface EmployeeMapper {

    int insertEmp(Employee employee);

    int deleteEmpById(int id);

    int updateEmp(Employee employee);

    Employee getEmpById(int id);
}
