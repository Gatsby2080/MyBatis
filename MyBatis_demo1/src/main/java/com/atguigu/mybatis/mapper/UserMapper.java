package com.atguigu.mybatis.mapper;

/**
 * @author Adidas
 * @title: UserMapper
 * @projectName MyBatis
 * @description:
 * @date 2022/3/20 12:58
 */
public interface UserMapper {


    /**面向接口编程
     * 1、映射文件的namespace要和mapper接口的全类名保持一致
     * 2、映射文件中SQL语句的id要和mapper接口中的方法保持一致
     *
     *
     *
     * @return
     */

    /*
    *添加用户信息
    * */
    int insertUser();
}
