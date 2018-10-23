package com.zy.spring.formework.context.support;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.zy.spring.formework.beans.GPBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @ClassName GPBeanDefinitionReader
 * @Description 读取配置类 加载 解析
 * @Author Benny
 * @Date 2018/8/25 0025 18:58
 * @Version 1.0
 **/
public class GPBeanDefinitionReader {

    Properties config = new Properties();

    List<String> registerBeanClasses = new ArrayList<>();

    //在配置文件中，用来获取自动扫描的包名的key
    private final String SCAN_PACKAGE = "scanPackage";

    public GPBeanDefinitionReader(String ... locations) {
        //在Spring中是通过Reader去查找和定位对不对
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(locations[0].replace("classpath:",""));

        try {
            config.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(null != is){is.close();}
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        doScan(config.getProperty(SCAN_PACKAGE));
    }

    //递归扫描所有相关类 并保存listzhon
    private void doScan(String property) {
        URL url = this.getClass().getClassLoader().getResource("/" + property.replaceAll("\\.", "/"));
        File className = new File(url.getFile());
        for (File file : className.listFiles()) {

            if (file.isDirectory()) {
                doScan(property + "." +file.getName());
            }
            else {
                registerBeanClasses.add(property + "." + file.getName().replace(".class", ""));
            }
        }
    }

    public List<String> loadBeanDefinitions() {
        return this.registerBeanClasses;
    }

    public GPBeanDefinition registerBean(String className) {
        if (this.registerBeanClasses.contains(className)) {
            GPBeanDefinition beanDefinition = new GPBeanDefinition();
            beanDefinition.setBeanClassName(className);
            beanDefinition.setFactoryBeanName(lowerFirstCase(className.substring(className.lastIndexOf(".") + 1)));
            return beanDefinition;

        }
        return null;

    }

    private String lowerFirstCase(String str){
        char [] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    public Properties getConfig() {
        return this.config;
    }
}
