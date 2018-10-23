package com.zy.design.observer.mouse;

import com.zy.design.observer.code.Event;

/**
 * @ClassName MouceEventCallback
 * @Description 观察者
 * @Author Benny
 * @Date 2018/8/3 0003 11:28
 * @Version 1.0
 **/
public class MouceEventCallback {
    public void onClick(Event e){
        System.out.println("这是鼠标单击以后要执行的逻辑");
        System.out.println("=======触发鼠标单击事件========\n" + e);
    }

    public void onDoubleClick(Event e){
        System.out.println("=======触发鼠标双击事件========\n" + e);
    }

    public void onUp(Event e){
        System.out.println("=======触发鼠标弹起事件========\n" + e);
    }
    public void onDown(Event e){
        System.out.println("=======触发鼠标按下事件========\n" + e);
    }
    public void onMove(Event e){
        System.out.println("=======触发鼠标移动事件========\n" + e);
    }
    public void onWheel(Event e){
        System.out.println("=======触发鼠标滚动事件========\n" + e);
    }

    public void onOver(Event e){
        System.out.println("=======触发鼠标悬停事件========\n" + e);
    }

}
