package com.cyh.bean;

import lombok.Data;

/**
 * @author CYH
 * @date 2018-06-21
 */
@Data
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private String gender;


    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", gender='"
                + gender + '\'' + '}';
    }
}
