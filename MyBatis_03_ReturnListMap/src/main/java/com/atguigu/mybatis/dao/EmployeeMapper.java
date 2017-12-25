package com.atguigu.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.atguigu.mybatis.bean.Employee;

/**
 * @author CYH
 * @date 2017/12/25 0025
 */
public interface EmployeeMapper {

    /**
     * 多条记录封装一个map：Map<Integer,Employee>:键是这条记录的主键，值是记录封装后的javaBean
     * @param lastName
     * @return
     */
    @MapKey("id")
    Map<Integer, Employee> getEmpByLastNameLikeReturnMap(String lastName);

    /**
     * 多条记录封装一个map：Map<Integer,Employee>:键是这条记录的主键，值是记录封装后的javaBean
     * @MapKey:告诉mybatis封装这个map的时候使用哪个属性作为map的key
     * @param lastName
     * @return
     */
    @MapKey("lastName")
    Map<String, Employee> getEmpByLastNameLikeReturnMap2(String lastName);

    /**
     * 返回一条记录的map；key就是列名，值就是对应的值
     * @param id
     * @return
     */
    Map<String, Object> getEmpByIdReturnMap(Integer id);

    List<Employee> getEmpsByLastNameLike(String lastName);
}
