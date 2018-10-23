package com.zy.design.proxy.staticProxy;

/**
 * @ClassName StaticProxyTest
 * @Description 静态代理实现类
 * @Author Benny
 * @Date 2018/8/1 0001 9:46
 * @Version 1.0
 **/
public class StaticProxyTest {
    public static void main(String[] args) {
        ProxyPerson proxyPerson = new ProxyPerson(new RealNeed());
        proxyPerson.getBreakFirst();
    }
}
