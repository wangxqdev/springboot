package com.tec.anji.mapper;

import com.tec.anji.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Options(useGeneratedKeys = true)
    @Insert("insert into employee(last_name, email, gender, d_id) values(#{lastName}, #{email}, #{gender}, #{dId})")
    int insertEmp(Employee employee);

    @Delete("delete from employee where id = #{id}")
    int deleteEmpById(int id);

    @Update("update emp set last_name = #{lastName}, email = #{email}, gender = #{gender}, d_id = #{dId} where id = #{id}")
    int updateEmp(Employee employee);

    @Select("select * from employee where id = #{id}")
    Employee getEmpById(int id);
}
