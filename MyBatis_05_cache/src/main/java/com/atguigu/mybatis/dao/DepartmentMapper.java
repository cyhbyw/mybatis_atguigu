package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Department;

/**
 * @author CYH
 * @date 2017/12/30 0030
 */
public interface DepartmentMapper {

    Department getDeptById(Integer id);
}
