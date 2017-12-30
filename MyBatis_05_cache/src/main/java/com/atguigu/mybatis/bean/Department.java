package com.atguigu.mybatis.bean;

import java.io.Serializable;

/**
 * Created by CYH on 2017/12/30 0030.
 */
public class Department implements Serializable {

    private Integer id;
    private String departmentName;

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", departmentName='" + departmentName + '\'' + '}';
    }
}
