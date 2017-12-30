package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.mybatis.bean.Department;
import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.DepartmentMapper;
import com.atguigu.mybatis.dao.EmployeeMapper;

/**
 * @author CYH
 * @date 2017/12/30 0030
 */
public class SecondLevelCacheTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testSecondLevelCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        SqlSession openSession2 = sqlSessionFactory.openSession();
        EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
        EmployeeMapper mapper2 = openSession2.getMapper(EmployeeMapper.class);

        Employee emp01 = mapper.getEmpById(1);
        System.out.println(emp01);
        openSession.close();

        Employee emp02 = mapper2.getEmpById(1);
        System.out.println(emp02);
        openSession2.close();
    }

    /**
     * 二级缓存也是写在 namespace 下的，而 DepartmentMapper 的 namespace 并没有写，所以不具有二级缓存的功能
     * @throws IOException
     */
    @Test
    public void testSecondLevelCache02() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        SqlSession openSession2 = sqlSessionFactory.openSession();
        DepartmentMapper mapper = openSession.getMapper(DepartmentMapper.class);
        DepartmentMapper mapper2 = openSession2.getMapper(DepartmentMapper.class);

        Department deptById = mapper.getDeptById(1);
        System.out.println(deptById);
        openSession.close();

        Department deptById2 = mapper2.getDeptById(1);
        System.out.println(deptById2);
        openSession2.close();
    }


}
