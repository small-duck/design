package com.zy.zookeeper.zookeeper源码分析;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName WatcherDemo
 * @Description wathc事件分析
 * @Author Benny
 * @Date 2018/9/9 0009 12:43
 * @Version 1.0
 **/
public class WatcherDemo {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        final ZooKeeper zooKeeper = new ZooKeeper("192.168.13.128,192.168.13.129,192.168.13.130", 4000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.err.println("默认事件："+watchedEvent.getState());

                if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                    //如果收到了服务端的响应事件，连接成功
                    countDownLatch.countDown();

                }

            }


        });

        countDownLatch.await();

        zooKeeper.create("/exist-zy1", "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        Stat stat = new Stat();

    //        byte[] data = zooKeeper.getData("/zk-zy-3", null, stat);
    //        System.err.println(new String(data));
    //
    //        stat= zooKeeper.setData("/zk-zy-3", "new".getBytes(), stat.getVersion());
    //
    //        byte[] data2 = zooKeeper.getData("/zk-zy-3", null, stat);
    //        System.err.println(new String(data2));
    //
    //        zooKeeper.delete("/zk-zy-3", stat.getVersion());


            //绑定exist事件
        Stat exists = zooKeeper.exists("/exist-zy1", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.err.println(watchedEvent.getType() + "->" + watchedEvent.getState());

                try {
                    zooKeeper.exists(watchedEvent.getPath(), true);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        exists = zooKeeper.setData("/exist-zy1", "exist".getBytes(), exists.getVersion());

        Thread.sleep(1000);

        zooKeeper.delete("/exist-zy1", exists.getVersion());


//        zooKeeper.close();

        System.in.read();

    }
}
