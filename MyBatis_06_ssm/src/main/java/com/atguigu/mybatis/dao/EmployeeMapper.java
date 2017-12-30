package com.atguigu.mybatis.dao;

import java.util.List;

import com.atguigu.mybatis.bean.Employee;

/**
 * @author CYH
 * @date 2017/12/30 0030
 */
public interface EmployeeMapper {

    List<Employee> getEmps();
}
