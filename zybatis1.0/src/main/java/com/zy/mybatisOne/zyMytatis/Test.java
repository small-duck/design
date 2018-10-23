package com.zy.mybatisOne.zyMytatis;

/**
 * @ClassName Test
 * @Description
 * @Author Benny
 * @Date 2018/8/11 0011 23:13
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        MSqlSession sqlSession = new MSqlSession(new MConfigtion(), new MSimpleExcutor());
        TestMapper mappser = sqlSession.getMappser(TestMapper.class);
        User userById = mappser.getUserById(1);
        System.out.println(userById.getAge());

    }
}
