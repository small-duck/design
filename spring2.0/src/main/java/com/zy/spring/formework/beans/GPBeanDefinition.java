package com.zy.spring.formework.beans;

/**
 * @ClassName GPBeanDefinition
 * @Description 用来存储配置文件 相当于把配置文件存储在内存中
 *
 * @Author Benny
 * @Date 2018/8/25 0025 22:34
 * @Version 1.0
 **/
public class GPBeanDefinition {

    private String beanClassName;
    private boolean lazyInit = false;
    private String factoryBeanName;

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public String getFactoryBeanName() {
        return factoryBeanName;
    }

    public void setFactoryBeanName(String factoryBeanName) {
        this.factoryBeanName = factoryBeanName;
    }
}
