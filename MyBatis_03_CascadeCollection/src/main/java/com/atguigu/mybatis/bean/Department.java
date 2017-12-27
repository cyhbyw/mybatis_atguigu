package com.atguigu.mybatis.bean;

import java.util.List;

import lombok.Data;

/**
 * @author CYH
 * @date 2017/12/27 0027
 */
@Data
public class Department {

    private Integer id;
    private String departmentName;
    private List<Employee> employeeList;

    @Override
    public String toString() {
        return "Department [id=" + id + ", departmentName=" + departmentName + "]";
    }


}
