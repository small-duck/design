package com.zy.design.single;

import com.zy.design.single.unhunger.LazyThree;
import com.zy.design.single.unhunger.UnHungerDesgin;
import com.zy.design.single.unhunger.UnHungerDesginTwo;


public class SimgleTest {
    public static void main(String[] args) {

        int count = 4000000;
        LazyThree inint = LazyThree.getInint();

        long noSystartTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            UnHungerDesgin unHungerDesgin = UnHungerDesgin.getUnHungerDesgin();
//            System.err.println(unHungerDesgin);
        }
        long noSysEndTime = System.currentTimeMillis();
        System.out.println("未使用同步的时间；" + (noSysEndTime - noSystartTime));






        long sysStartTine = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            UnHungerDesginTwo unHungerDesgin = UnHungerDesginTwo.getUnHungerDesgin();
//            System.err.println(unHungerDesgin);
        }
        long SysEndTime = System.currentTimeMillis();
        System.out.println("使用同步的时间；" + (SysEndTime - sysStartTine));



        long thresStrart = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {

//            System.err.println(unHungerDesgin);
        }
        long threeEnd = System.currentTimeMillis();
        System.out.println("第三种同步的时间；" + (threeEnd - thresStrart));



//        final CountDownLatch latch = new CountDownLatch(count);
////        final Set<HungerDesign> syncSet = Collections.synchronizedSet(new HashSet<HungerDesign>());
//        for (int i = 0; i < count; i++) {
//            new Thread(){
//                @Override
//                public void run() {
//                    try {
//
////                        try {
////                            // 阻塞
////                            // count = 0 就会释放所有的共享锁
////                            // 万箭齐发
////
////                        } catch (Exception e) {
////                            e.printStackTrace();
////                        }
//                        latch.await();
//                        //必然会调用，可能会有很多线程同时去访问getInstance()
//                        Object obj = UnHungerDesgin.getUnHungerDesgin();
//                        System.out.println(System.currentTimeMillis() + ":" + obj);
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }.start();
//            latch.countDown();
//        }

//        try {
//            latch.await();
////            System.err.println();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }





    }
}
