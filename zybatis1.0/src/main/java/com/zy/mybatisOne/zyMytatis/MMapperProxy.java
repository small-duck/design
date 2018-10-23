package com.zy.mybatisOne.zyMytatis;

import com.sun.org.apache.bcel.internal.generic.Instruction;
import com.sun.org.apache.bcel.internal.generic.InstructionHandle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName MMapperProxy
 * @Description dongtai dili
 * @Author Benny
 * @Date 2018/8/11 0011 22:12
 * @Version 1.0
 **/
public class MMapperProxy implements InvocationHandler {

    private MSqlSession sqlSession;

    public MMapperProxy(MSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public MMapperProxy() {
    }

    //获取sql的
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().getName().equals(MConfigtion.TestMapperXml.namePase)) {
            String sql = MConfigtion.TestMapperXml.methorSqlMapping.get(method.getName());
            return sqlSession.selectOne(sql, String.valueOf( args[0]));
            }

        return null;
    }
}
