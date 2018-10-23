package com.zy.spring.formework.webmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

/**
 * @ClassName GPHandlerAdapter
 * @Description
 * @Author Benny
 * @Date 2018/8/26 0026 15:35
 * @Version 1.0
 **/
public class GPHandlerAdapter {
    private Map<String, Integer> paramMapping;

    public GPHandlerAdapter(Map<String, Integer> paramMapping) {
        this.paramMapping = paramMapping;
    }

    public GPModelAndView handle(HttpServletRequest req, HttpServletResponse resp, GPHandlerMapping handler) throws InvocationTargetException, IllegalAccessException {
        //根据用户请求的参数信息 跟method中的参数信息进行动态匹配
        //resq传经来目的只有一个  只是为了赋值给方法参数
        //只偶
        //1 要准备好这个方法的形参列表
        Class<?>[] paramTypes = handler.getMethod().getExceptionTypes();

        //2 拿到自定义命名参数所在的位置
        Map<String,String[]> reqParameterMap = req.getParameterMap();


        //3 构造实参列表
        Object[] paramValues = new Object[paramTypes.length];

        for (Map.Entry<String, String[]> param : reqParameterMap.entrySet()) {
            String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]", "").replaceAll("\\s", "");
            if (!this.paramMapping.containsKey(param.getKey())) {
                continue;
            }

            Integer index = paramMapping.get(param.getKey());
            paramValues[index]  = caseStringValue(value, paramTypes[index]);
        }

        if (this.paramMapping.containsKey(HttpServletRequest.class)) {
            Integer reqIndex = paramMapping.get(HttpServletRequest.class);
            paramValues[reqIndex] = req;
        }

        if (paramMapping.containsKey(HttpServletResponse.class)) {
            Integer integer = paramMapping.get(HttpServletResponse.class);
            paramValues[integer] = resp;
        }
        //4 从handler中取出controller  method

        Object result = handler.getMethod().invoke(handler.getController(), paramValues);
        if (result == null) {
            return null;
        }

        boolean isModelAndView = handler.getMethod().getReturnType() == GPModelAndView.class;
        if (isModelAndView) {
            return (GPModelAndView) result;
        }else {
            return null;
        }
    }

    private Object caseStringValue(String value, Class<?> clazz) {
        if (clazz == String.class) {
            return value;
        } else if (clazz == Integer.class) {
            return Integer.valueOf(value);
        } else if (clazz == int.class) {
            return Integer.valueOf(value).intValue();
        }else {
            return null;
        }

    }
}
