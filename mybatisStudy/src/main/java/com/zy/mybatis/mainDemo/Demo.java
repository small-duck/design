package com.zy.mybatis.mainDemo;

import com.zy.mybatis.dao.UserMapper;
import com.zy.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName Demo
 * @Description
 * @Author Benny
 * @Date 2018/8/7 0007 15:25
 * @Version 1.0
 **/
public class Demo {
    public static SqlSession getSqlSession() {
        String resource = "com/zy/mybatis/mainDemo/mybatis-config.xml";
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            return factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws FileNotFoundException {
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        //接口如何调用方法1.8之前是不能，通过动态代理可以实现，1.8之后
        //有固定的方法，（去学习一下）
        User user = new User();
        user.setSex("man");
        user.setName("zy");
        user.setAge(12);
//        int i = mapper.insertUser(user);
        User userById = mapper.getUserById(1);
        //h找到sql
        //参数设置
        //执行
        //结果映射
        System.err.println(userById);

    }
}
