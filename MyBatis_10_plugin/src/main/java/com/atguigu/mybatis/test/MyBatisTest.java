package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;

/**
 * @author CYH
 * @date 2017/12/31 0031
 */
public class MyBatisTest {

    /**
     * 1、获取 SqlSessionFactory 对象:
     * 		解析文件的每一个信息保存在Configuration中，返回包含 Configuration 的 DefaultSqlSessionFactory
     * 		注意：【MappedStatement】：代表一个增删改查的详细信息
     *
     * 2、获取 SqlSession 对象
     * 		返回一个 DefaultSqlSession 对象，包含 Executor 和 Configuration;
     * 		这一步会创建 Executor 对象；
     *
     * 3、获取接口的代理对象（MapperProxy）
     * 		getMapper，使用 MapperProxyFactory 创建一个 MapperProxy 的代理对象
     * 		代理对象里面包含了，DefaultSqlSession（Executor）
     *
     * 4、执行增删改查方法
     *
     * 总结：
     * 	1、根据配置文件（全局，sql映射）初始化出 Configuration 对象
     * 	2、创建一个 DefaultSqlSession 对象，
     * 		他里面包含 Configuration 以及
     * 		Executor（根据全局配置文件中的defaultExecutorType创建出对应的Executor）
     *  3、DefaultSqlSession.getMapper（）：拿到 Mapper 接口对应的 MapperProxy；
     *  4、MapperProxy 里面有（DefaultSqlSession）；
     *  5、执行增删改查方法：
     *  		1）、调用 DefaultSqlSession 的增删改查（Executor）；
     *  		2）、会创建一个 StatementHandler 对象。（同时也会创建出 ParameterHandler 和 ResultSetHandler ）
     *  		3）、调用 StatementHandler 预编译参数以及设置参数值; 使用 ParameterHandler 来给sql设置参数
     *  		4）、调用 StatementHandler 的增删改查方法；
     *  		5）、ResultSetHandler 封装结果
     *  注意：
     *  	四大对象每个创建的时候都有一个 interceptorChain.pluginAll(parameterHandler);
     *
     * @throws IOException
     */


    /**
     * 插件原理
     * 在四大对象创建的时候
     * 1、每个创建出来的对象不是直接返回的，而是
     * 		interceptorChain.pluginAll(parameterHandler);
     * 2、获取到所有的Interceptor（拦截器）（插件需要实现的接口）；
     * 		调用 interceptor.plugin(target); 返回target包装后的对象
     * 3、插件机制，我们可以使用插件为目标对象创建一个代理对象；AOP（面向切面）
     * 		我们的插件可以为四大对象创建出代理对象；
     * 		代理对象就可以拦截到四大对象的每一个执行；
     *
    
     public Object pluginAll(Object target) {
        for (Interceptor interceptor : interceptors) {
            target = interceptor.plugin(target);
        }
        return target;
     }
    
     */

    /**
     * 插件编写：
     * 1、编写 Interceptor 的实现类
     * 2、使用 @Intercepts 注解完成插件签名
     * 3、将写好的插件注册到全局配置文件中
     */
    @Test
    public void test01() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            System.out.println(mapper);
            System.out.println("=============================================================");
            Employee employee = mapper.getEmpById(1);
            System.out.println(employee);
        } finally {
            openSession.close();
        }
    }

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }


}
