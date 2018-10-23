package com.zy.design.observer.code;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName EventLister
 * @Description 事件注册和监听
 * @Author Benny
 * @Date 2018/8/3 0003 11:14
 * @Version 1.0
 **/
public class EventLister {

    protected Map<Enum, Event> events = new HashMap<Enum, Event>();

    public void addLister(Enum en, Object targer, Method callback) {
        events.put(en, new Event(targer, callback));
    }

    private void trigger(Event event) {
        event.setSource(this);
        event.setTarget(System.currentTimeMillis());
        try {
            event.getCallback().invoke(event.getTarget(), event);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public void trigger(Enum type) {
        if (!events.containsKey(type)) {
            return;
        }
        trigger(events.get(type).setTrigger(type.toString()));

    }


}
