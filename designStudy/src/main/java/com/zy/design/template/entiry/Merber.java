package com.zy.design.template.entiry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName Merber
 * @Description 用户类
 * @Author Benny
 * @Date 2018/8/2 0002 9:44
 * @Version 1.0
 **/
public class Merber {
    private String name;
    private String password;

    @Override
    public String toString() {
        return "Merber{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        Map map = new ConcurrentHashMap(3);
        System.err.println(map);
    }
}
