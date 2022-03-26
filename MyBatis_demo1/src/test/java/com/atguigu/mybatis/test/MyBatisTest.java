package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Adidas
 * @title: MyBatisTest
 * @projectName MyBatis
 * @description:
 * @date 2022/3/20 13:18
 */
public class MyBatisTest {


    /**
     * sqlSession默认不自动提交事务，若需要自动提交事务
     * sqlSessionFactory.openSession(true),
     *
     * */
    @Test
    public void testMyBatis() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SQLSessionFactoryBuilder
       SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
       //获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sqlSession;java程序和数据库进行的会话
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//ctrl+p   boolean autoCommit
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //测试功能
        int result = mapper.insertUser();
        //提交事务
       // sqlSession.commit();
        System.out.println("result = " + result);


    }
}
