package com.atguigu.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapperAnnotation {

    @Select("select * from tbl_employee where id = #{id}")
    Employee getEmpById(Integer id);
}
