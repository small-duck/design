package com.zy.spring.formework.aop;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName GPAopConfig
 * @Description
 * @Author Benny
 * @Date 2018/8/26 0026 20:31
 * @Version 1.0
 **/
public class GPAopConfig {

    //以目标对象需要增强的Method作为key，需要增强的代码内容作为value
    private Map<Method,GPAspect> points = new HashMap<Method, GPAspect>();


    public void put(Method target,Object aspect,Method[] points){
        this.points.put(target,new GPAspect(aspect,points));
    }

    public GPAspect get(Method method){
        return this.points.get(method);
    }

    public boolean contains(Method method){
        return this.points.containsKey(method);
    }



    //对增强的代码的封装
    public class GPAspect{
        private Object aspect; //待会将LogAspet这个对象赋值给它
        private Method[] points;//会将LogAspet的before方法和after方法赋值进来

        public GPAspect(Object aspect,Method[] points){
            this.aspect = aspect;
            this.points = points;
        }

        public Object getAspect() {
            return aspect;
        }

        public Method[] getPoints() {
            return points;
        }
    }
}
