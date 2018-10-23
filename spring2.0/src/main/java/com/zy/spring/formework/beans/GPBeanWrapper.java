package com.zy.spring.formework.beans;

import com.zy.spring.formework.aop.GPAopProxy;
import com.zy.spring.formework.code.GPFactoryBean;

/**
 * @ClassName GPBeanWrapper
 * @Description 包装类
 * @Author Benny
 * @Date 2018/8/26 0026 11:37
 * @Version 1.0
 **/

public class GPBeanWrapper implements GPFactoryBean {

    //还会遇到观察者模式
    //支持事件响应，会有一个监听
    private GPBeanPostProcessor postProcessor;

    GPAopProxy proxy = new GPAopProxy();

    //
    private Object wrapperInstance;

    //原始的通过反射new 出来 要把包装起来 存下来
    private Object originalInstance;

    public GPBeanPostProcessor getPostProcessor() {
        return postProcessor;
    }

    public void setPostProcessor(GPBeanPostProcessor postProcessor) {
        this.postProcessor = postProcessor;
    }

    public GPBeanWrapper(Object instance) {
        this.wrapperInstance = proxy.getProxy(instance);
        this.originalInstance = instance;
    }

    public Object getWrapperInstance() {
        return this.wrapperInstance;
    }



}
