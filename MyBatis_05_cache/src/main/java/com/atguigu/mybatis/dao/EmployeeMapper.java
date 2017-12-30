package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;

/**
 * @author CYH
 * @date 2017/12/30 0030
 */
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    Long addEmp(Employee employee);
}
