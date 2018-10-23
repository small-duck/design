package com.zy.design.prototype.deep;

import java.util.Date;

public class DeepTest {
    public static void main(String[] args) {
        Suwukong suwukong = new Suwukong();
        Jgubang jgubang = suwukong.jgubang;
        Date birthday = suwukong.birthday;
        System.out.println("jgubang:"+jgubang+"birthday:"+birthday);

        System.err.println(suwukong);

        Suwukong clone = null;
        try {
            clone = (Suwukong) suwukong.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("jgubang:"+clone.jgubang+"birthday:"+clone.birthday);
        System.err.println(clone);

    }
}
