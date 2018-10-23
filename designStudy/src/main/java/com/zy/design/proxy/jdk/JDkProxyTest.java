package com.zy.design.proxy.jdk;

import com.zy.design.proxy.staticProxy.Person;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @ClassName JDkProxyTest
 * @Description 动态代理测试类
 * @Author Benny
 * @Date 2018/8/1 0001 10:00
 * @Version 1.0
 **/
public class JDkProxyTest {
    public static void main(String[] args) throws FileNotFoundException {
        try {


            Matchmaker matchmaker = new Matchmaker();
            Person instance = (Person) matchmaker.getInstance(new MySelf());
            instance.getBreakFaster();
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});

            FileOutputStream outputStream = new FileOutputStream("e://$Proxy0.class");
            outputStream.write(bytes);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
