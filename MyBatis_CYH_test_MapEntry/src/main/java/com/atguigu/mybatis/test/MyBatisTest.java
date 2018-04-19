package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.mybatis.bean.CYHPair;
import com.atguigu.mybatis.dao.EmployeeMapper;

public class MyBatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 正常Case
     * @throws Exception
     */
    @Test
    public void testUpdateByCYHPair() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        // 提示：使用的是 CYHPair
        mapper.updateByCYHPair(Arrays.asList(new CYHPair<>(1, "CYHPair")));
        sqlSession.commit();
    }

    /**
     * 异常Case
     * @throws Exception
     */
    @Test
    public void testUpdateByApacheCommonsPair() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        // 提示：使用的是 ImmutablePair
        mapper
            .updateByApacheCommonsPair(Arrays.asList(new ImmutablePair<>(1, "ApacheCommonsPair")));
        sqlSession.commit();
    }

}
