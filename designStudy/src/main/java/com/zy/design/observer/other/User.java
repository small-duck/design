package com.zy.design.observer.other;

/**
 * @ClassName User
 * @Description 观察者
 * @Author Benny
 * @Date 2018/8/3 0003 14:38
 * @Version 1.0
 **/
public class User implements Observer {

    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.err.println(name + "收到消息：" + message);
    }

}
