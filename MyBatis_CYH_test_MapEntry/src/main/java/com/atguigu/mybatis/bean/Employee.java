package com.atguigu.mybatis.bean;

import lombok.Data;

@Data
public class Employee {

    private Integer id;
    private String  name;

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", lastName='" + name + '\'' + '}';
    }
}
