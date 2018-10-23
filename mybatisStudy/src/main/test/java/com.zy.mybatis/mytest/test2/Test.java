package com.zy.mybatis.mytest.test2;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zy.mybatis.config.DataSourceConfig;
import com.zy.mybatis.config.MybatsiConfig;
import com.zy.mybatis.dao.UserMapper;
import com.zy.mybatis.po.User;
import com.zy.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName Test
 * @Description
 * @Author Benny
 * @Date 2018/8/7 0007 14:20
 * @Version 1.0
 **/
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {DataSourceConfig.class, MybatsiConfig.class})
public class Test   {
//    @Autowired
//    private UserService service;
//
//    @Autowired
//    private  UserMapper userMapper;
//    @org.junit.Test
    public void test1() {
//        UserService userService = new UserService();
//        User user = userService.selectById();
//        System.err.println(user);
//        PageHelper.startPage(1, 10);
//        User userById = userMapper.getUserById(1);
//
//        PageInfo pageInfo = new PageInfo();
//        System.err.println(userById);

    }

    public static void main(String[] args) {
//        User userById = userMapper.getUserById(1);
//        System.out.println(userById.getAge());

        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(MybatsiConfig.class, DataSourceConfig.class);
        UserService mapper = configApplicationContext.getBean(UserService.class);
        User userById1 = mapper.selectById();
        System.err.println(userById1);

    }

}
