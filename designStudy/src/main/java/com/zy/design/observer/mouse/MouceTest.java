package com.zy.design.observer.mouse;

import com.zy.design.observer.code.Event;
import com.zy.design.observer.code.EventLister;

import java.lang.reflect.Method;

/**
 * @ClassName MouceTest
 * @Description
 * @Author Benny
 * @Date 2018/8/3 0003 11:32
 * @Version 1.0
 **/
public class MouceTest {
    public static void main(String[] args) {
        MouceEventCallback callback = new MouceEventCallback();
        try {
            Method onClick = MouceEventCallback.class.getMethod("onClick", Event.class);

            Mouce mouce = new Mouce();
            mouce.addLister(MouseEventType.ON_CLICK,callback,onClick);
            mouce.click();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


//        lister.addLister(MouseEventType.ON_CLICK,mouce,);
    }
}
