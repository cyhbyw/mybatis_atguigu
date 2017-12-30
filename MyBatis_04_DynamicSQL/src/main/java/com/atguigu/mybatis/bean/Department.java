package com.atguigu.mybatis.bean;

import lombok.Data;

/**
 * @author CYH
 * @date 2017/12/30 0030
 */
@Data
public class Department {

    private Integer id;

    public Department() {}

    public Department(Integer id) {
        this.id = id;
    }

}
