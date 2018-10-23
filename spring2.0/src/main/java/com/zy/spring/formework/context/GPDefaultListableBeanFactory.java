package com.zy.spring.formework.context;

import com.zy.spring.formework.beans.GPBeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName GPDefaultListableBeanFactory
 * @Description
 * @Author Benny
 * @Date 2018/8/26 0026 20:19
 * @Version 1.0
 **/
public class GPDefaultListableBeanFactory extends GPAbstractApplicationContext {

    protected Map<String, GPBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    @Override
    protected void refreshBeanFactory() {

    }

    @Override
    protected void onRefresh() {
        super.onRefresh();
    }
}
