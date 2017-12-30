package com.atguigu.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.bean.Employee;

/**
 * @author CYH
 * @date 2017/12/30 0030
 */
public interface EmployeeMapperDynamicSQL {

    /**
     * 携带了哪个字段查询条件就带上这个字段的值
     * @param employee
     * @return
     */
    List<Employee> getEmpsByConditionIf(Employee employee);

    /**
     * 使用Trim标签
     * @param employee
     * @return
     */
    List<Employee> getEmpsByConditionTrim(Employee employee);

    /**
     * Choose分支查询
     * @param employee
     * @return
     */
    List<Employee> getEmpsByConditionChoose(Employee employee);

    /**
     * 使用Set来更新
     * @param employee
     */
    void updateEmpBySet(Employee employee);

    /**
     * 使用Trim来更新
     * @param employee
     */
    void updateEmpByTrim(Employee employee);

    /**
     * 查询员工id在给定集合中的
     * @param ids
     * @return
     */
    List<Employee> getEmpsByConditionForeach(@Param("ids") List<Integer> ids);

    /**
     * 批量保存
     * @param emps
     */
    void addEmps(@Param("emps") List<Employee> emps);

    /**
     * 批量保存
     * @param emps
     */
    void addEmps2(@Param("emps") List<Employee> emps);

    /**
     * Mybatis的两个内置参数
     * @param employee
     * @return
     */
    List<Employee> getEmpsTestInnerParameter(Employee employee);
}
