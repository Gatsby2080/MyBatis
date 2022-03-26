package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Adidas
 * @title: PageHelperTest
 * @projectName MyBatis
 * @description:
 * @date 2022/3/26 9:19
 */
public class PageHelperTest {

    /**
     * limit  index pageSize
     * index:当前页的起始索引  index=(pageNum-1)*pageSize
     * pageSize:每页显示的条数
     * pageNum:当前页码
     *
     * */
    @Test
    public void testPageHelper(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            PageHelper.startPage(1,4);//开启分页功能


            List<Emp> list = mapper.selectByExample(null);

            PageInfo<Emp> page = new PageInfo<>(list,5);
//            list.forEach(emp -> System.out.println(emp));
            System.out.println(page);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
