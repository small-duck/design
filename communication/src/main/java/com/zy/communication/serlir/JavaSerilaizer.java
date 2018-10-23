package com.zy.communication.serlir;

import java.io.*;

/**
 * @ClassName JavaSerilaizer
 * @Description
 * @Author Benny
 * @Date 2018/9/2 0002 18:17
 * @Version 1.0
 **/
public class JavaSerilaizer implements  ISerializ {
    @Override
    public <T> byte[] serialize(T obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(byteArrayOutputStream);
//            outputStream.defaultWriteObject();
            outputStream.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            byteArrayOutputStream.close();
        }
        return new byte[0];
    }

    @Override
    public <T> T deSerialize(byte[] bytes, Class<T> clazz) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
//            objectInputStream.defaultReadObject();
            return (T) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
