package com.tec.anji.mapper;

import com.tec.anji.bean.Department;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartementMapper {

    @Options(useGeneratedKeys = true)
    @Insert("insert into department(department_name) values(#{departmentName})")
    int insertDept(Department department);

    @Delete("delete from department where id=#{id}")
    int deleteDeptById(int id);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    int updateDept(Department department);

    @Select("select * from department where id=#{id}")
    Department getDeptById(int id);
}
