package com.zy.zookeeper.zookeeper源码分析;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @ClassName CuratorWatcherDemo
 * @Description
 * @Author Benny
 * @Date 2018/9/9 0009 17:09
 * @Version 1.0
 **/
public class CuratorWatcherDemo {
    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().
                connectString("192.168.13.128,192.168.13.129,192.168.13.130").sessionTimeoutMs(4000).retryPolicy(new
                ExponentialBackoffRetry(100, 3)).
        build();

        curatorFramework.start();

//        addListenerWithNodeCache(curatorFramework, "/zy");

        addListenerWithPathChildCache(curatorFramework, "/zy");

        System.in.read();


    }

    private static void addListenerWithPathChildCache(CuratorFramework curatorFramework, String s) throws Exception {
        final PathChildrenCache childrenCache = new PathChildrenCache(curatorFramework, s, true);

        PathChildrenCacheListener listener = new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                System.err.println("Receive event:" + pathChildrenCacheEvent.getType());
            }

        };
        childrenCache.getListenable().addListener(listener);
        childrenCache.start(PathChildrenCache.StartMode.NORMAL);
    }

    private static void addListenerWithNodeCache(CuratorFramework curatorFramework, String path) throws Exception {
        final NodeCache cache = new NodeCache(curatorFramework, path, false);

        NodeCacheListener listener = new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.err.println("recvie:" + cache.getCurrentData().getPath());
            }
        };
        cache.getListenable().addListener(listener);
        cache.start();



    }
}
