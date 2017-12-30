package com.atguigu.mybatis.bean;

import java.io.Serializable;

import lombok.Data;

/**
 * @author CYH
 * @date 2017/12/30 0030
 */
@Data
public class Employee implements Serializable {

    private Integer id;
    private String lastName;
    private String email;
    private String gender;


    public Employee() {}

    public Employee(String lastName, String email, String gender) {
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", gender='"
                + gender + '\'' + '}';
    }
}
