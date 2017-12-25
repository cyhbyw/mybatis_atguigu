package com.atguigu.mybatis.bean;

import lombok.Data;

/**
 * @author CYH
 * @date 2017/12/25 0025
 */
@Data
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private String gender;

    public Employee() {
        super();
    }

    public Employee(Integer id, String lastName, String email, String gender) {
        super();
        this.id = id;
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
