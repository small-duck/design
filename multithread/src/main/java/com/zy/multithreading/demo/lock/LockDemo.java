package com.zy.multithreading.demo.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName LockDemo
 * @Description
 * @Author Benny
 * @Date 2018/10/4 0004 11:23
 * @Version 1.0
 **/
public class LockDemo {
    static Map<String, Object> cacheMap = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock read = rwl.readLock();
    static Lock write = rwl.writeLock();

    public static final Object get(String key) {
        System.out.println("开始读取数据");
        read.lock();
        try {
            return cacheMap.get(key);
        }finally {
            read.unlock();
        }

    }


    public static final Object put(String key, Object value) {
        write.lock();
        System.out.println("开始写数据");
        try {
            return cacheMap.put(key, value);
        }finally {
            write.unlock();
        }
    }

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(1);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                put("1"+(count.getAndIncrement()), count.getAndIncrement());
            }).start();

            new Thread(() -> {
                System.err.println("获取结果"+get("1" + count.getAndIncrement()));
            }).start();
        }
    }


}
