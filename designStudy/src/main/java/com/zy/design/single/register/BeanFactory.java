package com.zy.design.single.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {

    private BeanFactory(){}

    private static Map<String, Object> beanMap = new ConcurrentHashMap<String, Object>();

    public static Object getInitialize(String name) {
        if (!beanMap.containsKey(name)) {
            Object object= null;
            try {
                 object = Class.forName(name).newInstance();
                beanMap.put(name, object);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return object;
        }
        return beanMap.get(name);
    }
}
