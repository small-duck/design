package com.zy.mybatisOne.zyMytatis;

/**
 * @ClassName Mexcutor
 * @Description 执行器
 * @Author Benny
 * @Date 2018/8/11 0011 21:57
 * @Version 1.0
 **/
public interface Mexcutor {
    public <T> T query(String statement, String parameter);
}
