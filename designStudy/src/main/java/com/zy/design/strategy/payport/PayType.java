package com.zy.design.strategy.payport;

public enum PayType {
    ALI_PAY(new AliPay()),
    WECHAT_PAY(new WechatPay()),
    UNION_PAY(new UnionPay()),
    JD_PAY(new JDPay());
    private PayMent payMent;

    PayType(PayMent payMent) {
        this.payMent = payMent;
    }

    public PayMent getPayMent() {
        return payMent;
    }
}
