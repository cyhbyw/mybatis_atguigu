package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.mybatis.bean.Department;
import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapperDynamicSQL;

/**
 * @author CYH
 * @date 2017/12/30 0030
 */
public class MyBatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testDynamicSql01() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(3, "%Y%", null, null);
            List<Employee> emps = mapper.getEmpsByConditionIf(employee);
            for (Employee emp : emps) {
                System.out.println(emp);
            }
        } finally {
            openSession.close();
        }
    }

    /**
     * 查询的时候如果某些条件没带可能sql拼装会有问题
     * 1、给where后面加上1=1，以后的条件都and xxx.
     * 2、mybatis使用where标签来将所有的查询条件包括在内。mybatis就会将where标签中拼装的sql，多出来的and或者or去掉
     *      !!但是这也只能处理 "and XXX" 这种情况，如果是 "XXX and" 也还是不能处理的!!
     *      !!where只会去掉第一个多出来的and或者or!!
     * @throws IOException
     */
    @Test
    public void testDynamicSql02() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(null, "%Y%", null, null);
            List<Employee> emps = mapper.getEmpsByConditionIf(employee);
            for (Employee emp : emps) {
                System.out.println(emp);
            }
        } finally {
            openSession.close();
        }
    }

    /**
     * 用 Trim 解决 "XXX and" 的问题
     * @throws IOException
     */
    @Test
    public void testDynamicSql03() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(null, "%Y%", null, null);
            List<Employee> emps2 = mapper.getEmpsByConditionTrim(employee);
            for (Employee emp : emps2) {
                System.out.println(emp);
            }
        } finally {
            openSession.close();
        }
    }

    /**
     * Choose分支查询：带了哪个条件就用哪个
     * @throws IOException
     */
    @Test
    public void testDynamicSql04() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(1, "%Y%", null, null);
            List<Employee> emps2 = mapper.getEmpsByConditionChoose(employee);
            for (Employee emp : emps2) {
                System.out.println(emp);
            }
        } finally {
            openSession.close();
        }
    }

    /**
     * 使用Set来更新
     * @throws IOException
     */
    @Test
    public void testDynamicSql05() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(1, "CYH1002", "CYH1002@qq.com", "1");
            mapper.updateEmpBySet(employee);
            openSession.commit();
        } finally {
            openSession.close();
        }
    }

    /**
     * 使用Trim来更新
     * @throws IOException
     */
    @Test
    public void testDynamicSql06() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(1, "CYH1004", "CYH1004@qq.com", null);
            mapper.updateEmpByTrim(employee);
            openSession.commit();
        } finally {
            openSession.close();
        }
    }

    /**
     * 查询员工id在给定集合中的
     * @throws IOException
     */
    @Test
    public void testDynamicSql07() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee> employeeList = mapper.getEmpsByConditionForeach(Arrays.asList(1, 2, 3));
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testBatchSave() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee> emps = new ArrayList<>();
            emps.add(new Employee(null, "smith0x1", "smith0x1@atguigu.com", "1", new Department(1)));
            emps.add(new Employee(null, "allen0x1", "allen0x1@atguigu.com", "0", new Department(1)));
            mapper.addEmps(emps);
            mapper.addEmps2(emps);
            openSession.commit();
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testInnerParam() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee2 = new Employee();
            employee2.setLastName("%Y%");
            List<Employee> list = mapper.getEmpsTestInnerParameter(employee2);
            for (Employee employee : list) {
                System.out.println(employee);
            }

            System.out.println("=========================================================");
            list = mapper.getEmpsTestInnerParameter(null);
            for (Employee employee : list) {
                System.out.println(employee);
            }
        } finally {
            openSession.close();
        }
    }

}
