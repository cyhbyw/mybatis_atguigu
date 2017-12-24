package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    Long addEmp(Employee employee);

    boolean updateEmp(Employee employee);

    void deleteEmpById(Integer id);

}
