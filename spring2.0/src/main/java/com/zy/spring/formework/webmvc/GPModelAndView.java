package com.zy.spring.formework.webmvc;

import java.util.Map;

/**
 * @ClassName GPModelAndView
 * @Description 视图类
 * @Author Benny
 * @Date 2018/8/26 0026 11:06
 * @Version 1.0
 **/
public class GPModelAndView {
    private String viewName;
    private Map<String,?> model;

    public GPModelAndView(String viewName, Map<String, ?> model) {
        this.viewName = viewName;
        this.model = model;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, ?> getModel() {
        return model;
    }

    public void setModel(Map<String, ?> model) {
        this.model = model;
    }
}
