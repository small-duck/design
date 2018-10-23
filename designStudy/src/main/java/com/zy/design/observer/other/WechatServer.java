package com.zy.design.observer.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName WechatServer
 * @Description 被观察者模式
 * @Author Benny
 * @Date 2018/8/3 0003 14:30
 * @Version 1.0
 **/
public class WechatServer implements Observerable {
    private List<Observer> list;
    private String message;

    public WechatServer() {
        list = new ArrayList<Observer>();
    }

    @Override
    public void registerOberver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObserver() {
        if (list != null && list.size() != 0) {
            for (Observer observer : list) {
                observer.update(message);
            }

        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.err.println("微信更新消息：" + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }
}
