package com.atguigu.mybatis.dao;

import java.util.List;

import com.atguigu.mybatis.bean.Employee;

/**
 * @author CYH
 * @date 2017/12/27 0027
 */

public interface EmployeeMapperPlus {

    Employee getEmpById(Integer id);

    List<Employee> getEmpsByDeptId(Integer id);

}
