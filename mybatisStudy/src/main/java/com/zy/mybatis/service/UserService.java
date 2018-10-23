package com.zy.mybatis.service;

import com.zy.mybatis.dao.UserMapper;
import com.zy.mybatis.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * @ClassName UserService
 * @Description 用户service
 * @Author Benny
 * @Date 2018/8/7 0007 14:07
 * @Version 1.0
 **/
@Service
public class UserService {


    @Resource
    private UserMapper userMapper;



    public void saveUser() {
        User user = new User();
        user.setAge(23);
        user.setName("zy");
        user.setSex("man");
        userMapper.insertUser(user);
    }

    public User selectById() {
        User user = userMapper.getUserById(1);
        return user;
    }

}
