package com.zy.spring.formework.context;

import com.zy.spring.formework.beans.GPBeanDefinition;
import com.zy.spring.formework.beans.GPBeanPostProcessor;
import com.zy.spring.formework.beans.GPBeanWrapper;
import com.zy.spring.formework.code.GPBeanFactory;
import com.zy.spring.formework.context.support.GPBeanDefinitionReader;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class GPApplicationContext extends GPDefaultListableBeanFactory implements GPBeanFactory  {

    private String[] configLocations;


    //用来保证注册时单例
    private Map<String, Object> beanCacheMap = new ConcurrentHashMap<>();

    private Map<String, GPBeanWrapper> beanWrapperMap = new ConcurrentHashMap<>();
    private GPBeanDefinitionReader reader;
    public GPApplicationContext(String ... configLocation) {
        this.configLocations = configLocation;
        refresh();
    }

    private void refresh() {
        //定位
        this.reader = new GPBeanDefinitionReader(configLocations);
        //加载
        List<String> beanDefinitions = reader.loadBeanDefinitions();

        //注册
        doRegisty(beanDefinitions);

        //在这里依赖注入
        doAutowrited();

        System.err.println(getBean("myAction"));

    }

    /**
     * 开始执行自动化依赖注入
     */
    private void doAutowrited() {
        for (Map.Entry<String, GPBeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();
            if (!entry.getValue().isLazyInit()) {
                Object bean = getBean(beanName);

            }

        }

    }

    private void doRegisty(List<String> beanDefinitions) {
        //beanName有三个情况
        //1 默认首字母小写  2 自定义名字 3接口注入
        for (String definition : beanDefinitions) {
            try {
                Class<?> clazz = Class.forName(definition);

                //如果shi一个接口，是不能实例化的
                //需要通过实现类来实例化
                if (clazz.isInterface()) {
                    continue;
                }

                GPBeanDefinition beanDefinition = reader.registerBean(definition);
                if (beanDefinition != null) {
                    this.beanDefinitionMap.put(beanDefinition.getFactoryBeanName(), beanDefinition);

                }

                Class<?>[] interfaces = clazz.getInterfaces();
                for (Class<?> anInterface : interfaces) {
                    this.beanDefinitionMap.put(anInterface.getName(), beanDefinition);
                }


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 会使用装饰器模式
     * 优点：保存了oop关系 可以对他进行扩展
     * @param beanName
     * @return
     */
    @Override
    public Object getBean(String beanName) {
        GPBeanDefinition beanDefinition = this.beanDefinitionMap.get(beanName);
        String className = beanDefinition.getBeanClassName();

        //生成事件通知
        GPBeanPostProcessor postProcessor = new GPBeanPostProcessor();

        Object instantionBean = instantionBean(beanDefinition);

        if (null == instantionBean) {
            return null;
        }

        //在实例化之前调用一次
        postProcessor.postProcessAfterInitialization(instantionBean, beanName);

        GPBeanWrapper beanWrapper = new GPBeanWrapper(instantionBean);

        beanWrapper.setPostProcessor(postProcessor);
        this.beanWrapperMap.put(beanName, beanWrapper);

        postProcessor.postProcessAfterInitialization(instantionBean, beanName);


        return this.beanWrapperMap.get(beanName).getWrapperInstance();
    }

    private Object instantionBean(GPBeanDefinition beanDefinition) {
        Object instance = null;
        String className = beanDefinition.getBeanClassName();
        try {

            if (this.beanCacheMap.containsKey(className)) {
                instance = this.beanCacheMap.get(className);
            }else {
                Class<?> aClass = Class.forName(className);
                 instance = aClass.newInstance();

                this.beanCacheMap.put(className, instance);
            }
            return instance;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String[] getBeanDefinitionNames() {
        return this.beanDefinitionMap.keySet().toArray(new String[this.beanDefinitionMap.size()]);

    }

    public Properties getConfig() {
        return this.reader.getConfig();
    }
}
