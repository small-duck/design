package com.zy.zookeeper.zookeeper源码分析;

import com.google.common.math.Stats;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * @ClassName CuratorDemo
 * @Description
 * @Author Benny
 * @Date 2018/9/9 0009 17:09
 * @Version 1.0
 **/
public class CuratorDemo
{
    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().
                connectString("192.168.13.128,192.168.13.129,192.168.13.130").sessionTimeoutMs(4000).retryPolicy(new
                ExponentialBackoffRetry(100, 3)).
                namespace("1234").build();

        curatorFramework.start();

//        curatorFramework.create().creatingParentContainersIfNeeded().withMode(CreateMode.PERSISTENT)
//                .forPath("/v1/zy", "1".getBytes());

        Stat stat = new Stat();
        byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath("/v1/zy");
        System.err.println(new String(bytes));

        stat = curatorFramework.setData().withVersion(stat.getVersion()).forPath("/v1/zy", "xx".getBytes());

        byte[] byte2 = curatorFramework.getData().storingStatIn(stat).forPath("/v1/zy");
        System.err.println(new String(byte2));
        curatorFramework.close();

    }
}
