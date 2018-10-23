package com.zy.mybatisOne.zyMytatis;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MConfigtion
 * @Description 配置类
 * @Author Benny
 * @Date 2018/8/11 0011 20:48
 * @Version 1.0
 **/
public class MConfigtion {

    public <T> T getMapper(Class<T> clazz,MSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader()
                , new Class[]{clazz}, new MMapperProxy(sqlSession)
        );
    }

    static class TestMapperXml {
        public static final String namePase = "com.zy.mybatisOne.zyMytatis.TestMapper";

        public static final Map<String, String> methorSqlMapping = new HashMap<>();

        static {
            methorSqlMapping.put("getUserById", "select * from user where id = %d");
        }
    }


}
