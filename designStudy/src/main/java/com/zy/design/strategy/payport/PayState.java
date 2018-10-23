package com.zy.design.strategy.payport;

/**
 * @ClassName PayState
 * @Description 支付状态
 * @Author Benny
 * @Date 2018/8/1 0001 21:35
 * @Version 1.0
 **/
public class PayState {
    private int code;
    private Object data;
    private String msg;

    public PayState(int code, String msg,Object data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public String toString(){
        return ("支付状态：[" + code + "]," + msg + ",交易详情：" + data);
    }
}
