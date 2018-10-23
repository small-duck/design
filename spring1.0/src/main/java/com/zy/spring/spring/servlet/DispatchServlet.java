package com.zy.spring.spring.servlet;

import com.zy.spring.spring.annotation.Autower;
import com.zy.spring.spring.annotation.Controller;
import com.zy.spring.spring.annotation.Service;

import javax.naming.ldap.Control;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;

/**
 * @ClassName DispatchServlet
 * @Description dispatchServlet
 * @Author Benny
 * @Date 2018/8/16 0016 17:21
 * @Version 1.0
 **/
public class DispatchServlet extends HttpServlet {

    private  Properties contextConfig = new Properties();

    private Map<String, Object> beanDefinitionMap = new HashMap<>(256);

    private List<String> classNames = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.err.println("this is dopost");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        //定位
        doLoadConfig(config.getInitParameter("contextConfigLocation"));

        //加载
        doScanner(contextConfig.getProperty("scanPackage"));

        //注册
        doRegistry();

        //注入
        doAutowired();





    }

    private void doAutowired() {

        if (beanDefinitionMap.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Object> entry : beanDefinitionMap.entrySet()) {
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(Autower.class)) {
                    continue;
                }

                Autower annotation = field.getAnnotation(Autower.class);

                String beanName = annotation.value().trim();
                if ("".equals(beanName)) {
                    beanName = field.getType().getName();
                }
                field.setAccessible(true);

                try {
                    field.set(entry.getValue(), beanDefinitionMap.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    private void doRegistry() {
        if (classNames.isEmpty()) {
            return;
        }

            try {
                for (String className : classNames) {
                    Class<?> aClass = Class.forName(className);
                    if (aClass.isAnnotationPresent(Controller.class)) {
                        String beanName = lowerFirstCase(aClass.getSimpleName());
                        beanDefinitionMap.put(beanName, aClass.newInstance());
                    } else if (aClass.isAnnotationPresent(Service.class)) {
                        Service annotation = aClass.getAnnotation(Service.class);
                        String beanName = annotation.value();
                        if ("".equals(beanName.trim())) {
                            beanName = lowerFirstCase(aClass.getSimpleName());
                        }

                        Object instance = aClass.newInstance();
                        beanDefinitionMap.put(beanName, instance);

                        Class<?>[] interfaces = aClass.getInterfaces();

                        for (Class<?> anInterface : interfaces) {
                            beanDefinitionMap.put(anInterface.getCanonicalName(), anInterface.newInstance());
                        }

                    } else {
                        continue;
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

    }

    private void doScanner(String packageName) {
        URL url = this.getClass().getClassLoader().getResource("/" + packageName.replace("\\.", ""));
        File classDir = new File(url.getFile());
        for (File file : classDir.listFiles()) {
            if (file.isAbsolute()) {
                doScanner(packageName + "." + file.getName());
            }else {
                String name = file.getName();
                System.err.println(name);
                classNames.add(packageName + "." + file.getName().replace(".class", ""));
            }
        }


    }

    private void doLoadConfig(String config) {
        InputStream inputStream =
                this.getClass().getClassLoader().getResourceAsStream(config.replace("classpath:", ""));
        try {
            contextConfig.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private String lowerFirstCase(String string) {
        char[] chars = string.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);

    }
}
