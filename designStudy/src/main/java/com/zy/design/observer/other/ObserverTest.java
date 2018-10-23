package com.zy.design.observer.other;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

/**
 * @ClassName ObserverTest
 * @Description 测试列
 * @Author Benny
 * @Date 2018/8/3 0003 14:40
 * @Version 1.0
 **/
public class ObserverTest {
    public static void main(String[] args) {
        WechatServer server = new WechatServer();
        Observer userZhange = new User("zhangsan");
        Observer userLi = new User("Li");
        Observer userWang = new User("wangWu");
        server.registerOberver(userLi);
        server.registerOberver(userZhange);
        server.registerOberver(userWang);

        server.removerObserver(userZhange);
        server.setInfomation("java is best languer");
    }
}
