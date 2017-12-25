package com.atguigu.mybatis.bean;

import lombok.Data;

/**
 * @author CYH
 * @date 2017/12/25 0025
 */
@Data
public class Department {

    private Integer id;
    private String departmentName;

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", departmentName='" + departmentName + '\'' + '}';
    }
}
