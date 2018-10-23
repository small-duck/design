package com.zy.communication.serlir;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

/**
 * @ClassName User
 * @Description
 * @Author Benny
 * @Date 2018/9/2 0002 18:12
 * @Version 1.0
 **/
public class User implements Cloneable ,Serializable {
    private String name;
    private Integer age;
    private String school;

    private Examil examil;

    public Examil getExamil() {
        return examil;
    }

    public void setExamil(Examil examil) {
        this.examil = examil;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * 浅克隆
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    /**
     * 深度复制
     * @param outputStream
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public User deClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream obj = new ObjectOutputStream(byteArrayOutputStream);
        obj.writeObject(this);


        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream inputStream = new ObjectInputStream(arrayInputStream);
        return (User) inputStream.readObject();


    }
}
