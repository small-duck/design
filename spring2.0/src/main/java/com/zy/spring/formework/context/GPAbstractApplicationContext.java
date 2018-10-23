package com.zy.spring.formework.context;

/**
 * @ClassName GPAbstractApplicationContext
 * @Description
 * @Author Benny
 * @Date 2018/8/26 0026 20:18
 * @Version 1.0
 **/
public abstract class GPAbstractApplicationContext {
    //提供给子类重写
    protected void onRefresh(){
        // For subclasses: do nothing by default.
    }

    protected abstract void refreshBeanFactory();

}
