package com.zy.communication.serlir;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.IOException;

/**
 * @ClassName XmlSerializer
 * @Description
 * @Author Benny
 * @Date 2018/9/2 0002 22:58
 * @Version 1.0
 **/
public class XmlSerializer implements ISerializ {

    XStream xStream = new XStream(new DomDriver());

    @Override
    public <T> byte[] serialize(T obj) throws IOException {
        return xStream.toXML(obj).getBytes();
    }

    @Override
    public <T> T deSerialize(byte[] bytes, Class<T> clazz) {
        return (T) xStream.fromXML(new String(bytes));
    }
}
