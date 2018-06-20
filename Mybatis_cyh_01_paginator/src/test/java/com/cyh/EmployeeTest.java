package com.cyh;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import com.cyh.bean.Employee;
import com.cyh.mapper.EmployeeMapper;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public class EmployeeTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testMybatisPaginator() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int pageNum = 1;
        int pageSize = 3;
        Order order1 = new Order("last_name", Order.Direction.ASC, null);
        Order order2 = new Order("id", Order.Direction.ASC, null);
        PageBounds pageBounds = new PageBounds(pageNum, pageSize, order1, order2);
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> resultList = employeeMapper.findByGender(1, pageBounds);
            System.out.println(resultList.getClass().getName() + " ,, " + resultList.size());
            Assert.assertTrue(resultList instanceof PageList);
            PageList<Employee> pageList = (PageList<Employee>) resultList;
            System.out.println(pageList.getPaginator());
        } finally {
            sqlSession.close();
        }
    }

}
