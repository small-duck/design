package com.zy.spring.formework.webmvc;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @ClassName GPHandlerMapping
 * @Description
 * @Author Benny
 * @Date 2018/8/26 0026 15:35
 * @Version 1.0
 **/
public class GPHandlerMapping {

    private Object controller;
    private Method method;
    private Pattern pattern;//url的封装

    public GPHandlerMapping(Object controller, Method method, Pattern pattern) {
        this.controller = controller;
        this.method = method;
        this.pattern = pattern;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
}
