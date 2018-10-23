package com.zy.communication.test;

import com.zy.communication.serlir.*;

import java.io.IOException;

/**
 * @ClassName JavaSerialTest
 * @Description
 * @Author Benny
 * @Date 2018/9/2 0002 18:28
 * @Version 1.0
 **/
public class JavaSerialTest {
    public static void main(String[] args) throws IOException, CloneNotSupportedException, ClassNotFoundException {
        User user = new User();
        user.setAge(12);
        user.setName("benny");
        user.setSchool("tp");
//        Examil examil = new Examil("123");

//        ISerializ serializ = new JavaSerilaizer();
//        byte[] serialize = serializ.serialize(user);
//        System.err.println(serializ);
//
//        User user1 = serializ.deSerialize(serialize, User.class);
//        System.err.println("user:"+user1);

//        user.setExamil(examil);

        //浅克隆
//        User clone = user.clone();
//        examil.setContext("1243");
//        clone.setExamil(examil);
//        System.err.println(clone+"----"+clone.getExamil().getContext());
//        System.err.println(user+"----"+user.getExamil().getContext());
//
//
//        //深度kelong
//
//        User user1 = user.deClone();
//        user1.setExamil(new Examil("深克隆"));
//        System.err.println(user1+"===="+user1.getExamil().getContext());


        ISerializ serializ = new XmlSerializer();
        byte[] serialize = serializ.serialize(user);
        System.err.println(serializ.toString());
    }
}
