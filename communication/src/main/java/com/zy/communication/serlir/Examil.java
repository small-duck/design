package com.zy.communication.serlir;

import java.io.Serializable;

/**
 * @ClassName Examil
 * @Description
 * @Author Benny
 * @Date 2018/9/2 0002 18:43
 * @Version 1.0
 **/
public class Examil implements Serializable {
    private String context;

    public Examil(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
