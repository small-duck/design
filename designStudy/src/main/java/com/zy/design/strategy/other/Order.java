package com.zy.design.strategy.other;

import com.zy.design.strategy.payport.PayState;
import com.zy.design.strategy.payport.PayType;

/**
 * @ClassName Order
 * @Description
 * @Author Benny
 * @Date 2018/8/1 0001 21:38
 * @Version 1.0
 **/
public class Order {
    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid,String orderId,double amount){
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    PayState pay(PayType type) {
        return type.getPayMent().pay(uid, amount);
    }
}
