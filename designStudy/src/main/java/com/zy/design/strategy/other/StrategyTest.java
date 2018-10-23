package com.zy.design.strategy.other;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.zy.design.strategy.payport.PayState;
import com.zy.design.strategy.payport.PayType;

/**
 * @ClassName StrategyTest
 * @Description
 * @Author Benny
 * @Date 2018/8/1 0001 21:46
 * @Version 1.0
 **/
public class StrategyTest {
    public static void main(String[] args) {
        Order order = new Order("1", "20180311001000009", 324.45);
        PayState pay = order.pay(PayType.ALI_PAY);
        System.err.println(pay.toString());

    }
}
