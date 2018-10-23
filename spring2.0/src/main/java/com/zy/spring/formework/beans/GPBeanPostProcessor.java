package com.zy.spring.formework.beans;

/**
 * @ClassName GPBeanPost
 * @Description
 * @Author Benny
 * @Date 2018/8/26 0026 11:25
 * @Version 1.0
 **/
//做事件监听
public class GPBeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }
    public Object postProcessAfterInitialization(Object bean, String beanName){
        return bean;
    }

}
