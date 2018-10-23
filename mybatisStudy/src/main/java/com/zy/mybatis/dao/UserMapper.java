package com.zy.mybatis.dao;

import com.zy.mybatis.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@Mapper
public interface UserMapper {
    int insertUser( User user);

    User getUserById(Integer id);
}
