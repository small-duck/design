package com.zy.design.observer.other;

/**
 * 抽象被观察者接口
 * 声明了添加、删除、通知观察方法
 */
public interface Observerable {
    public void registerOberver(Observer observer);

    public void removerObserver(Observer observer);

    void notifyObserver();
}
