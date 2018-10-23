package com.zy.design.prototype.deep;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.util.Date;

public class Suwukong extends Monkey implements Cloneable ,Serializable {

    public Jgubang jgubang;

    public Suwukong() {
        this.birthday = new Date();
        this.jgubang = new Jgubang();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return deepClone();
    }

    public Object deepClone() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(this);

            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Suwukong object = (Suwukong) objectInputStream.readObject();
            return object;
        } catch (Exception e) {
            return null;
        }
    }
}
