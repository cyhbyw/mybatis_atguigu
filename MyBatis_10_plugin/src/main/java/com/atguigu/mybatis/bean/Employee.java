package com.atguigu.mybatis.bean;


import lombok.Data;

@Data
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private String gender;

    @Override
    public String toString() {
        return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + "]";
    }



}
