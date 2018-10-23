package com.zy.communication.serlir;

import java.io.IOException;

public interface ISerializ {

    <T> byte[] serialize(T obj) throws IOException;

    <T> T deSerialize(byte[] bytes, Class<T> clazz);
}
