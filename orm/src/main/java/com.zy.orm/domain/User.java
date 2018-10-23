package com.zy.orm.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @ClassName User
 * @Description
 * @Author Benny
 * @Date 2018/8/28 0028 10:55
 * @Version 1.0
 **/
@Entity
@Table(name = "user")
public class User {
    private Integer id;

    private String name;
    private int age;
    private String sex;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
