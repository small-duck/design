package com.zy.design.strategy.payport;

/**
 * @ClassName PayMent
 * @Description 支付渠道
 * @Author Benny
 * @Date 2018/8/1 0001 21:35
 * @Version 1.0
 **/
public interface PayMent {
   public PayState pay(String uid,double acount);
}
