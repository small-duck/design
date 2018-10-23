package com.zy.spring.formework.code;

/**
 * @ClassName GPBeanFactory
 * @Description
 * @Author Benny
 * @Date 2018/8/25 0025 19:25
 * @Version 1.0
 **/
public interface GPBeanFactory {

    //根据beanname从 容器获取一个实例Bean
     Object getBean(String beanName);
}
