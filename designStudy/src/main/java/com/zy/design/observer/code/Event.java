package com.zy.design.observer.code;

import java.lang.reflect.Method;
import java.util.Observer;

/**
 * @ClassName Event
 * @Description 事件
 * @Author Benny
 * @Date 2018/8/3 0003 11:09
 * @Version 1.0
 **/
public class Event {
    //事件源
    private Object source;
    //通知目标
    private Object target;

    //回调
    private Method callback;

    //触发
    private String trigger;

    private long time;

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }


    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    @Override
    public String toString() {
        return "Event{" +
                "\n\tsource=" + source + ",\n" +
                "\ttarget=" + target + ",\n" +
                "\tcallback=" + callback + ",\n" +
                "\ttrigger='" + trigger + '\'' + "\n" +
                '}';
    }

    public long getTime() {
        return time;
    }

    Event setTime(long time) {
        this.time = time;
        return this;
    }

    Event setSource(Object source) {
        this.source = source;
        return this;
    }

    Event setTrigger(String trigger){
        this.trigger = trigger;
        return this;
    }
}
