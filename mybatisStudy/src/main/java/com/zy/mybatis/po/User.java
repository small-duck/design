package com.zy.mybatis.po;

import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @ClassName User
 * @Description
 * @Author Benny
 * @Date 2018/8/7 0007 11:28
 * @Version 1.0
 **/
public class User implements Serializable {
    private String name;
    private Integer age;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public static void main(String[] args) {
    }
}
