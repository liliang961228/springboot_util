package com.wkk.wkkbjsb.business.thread;

import cn.hutool.core.thread.NamedThreadFactory;

import java.util.concurrent.*;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.controller
 * @Description : TODO
 * @Create on : 2020/12/16 17:24
 * @email : lgy961228@gamil.com
 **/
public class ThreadPoolDemo1 {

    /** 获取当前系统的CPU 数目*/
    static int cpuNums = Runtime.getRuntime().availableProcessors();
    /** 线程池核心池的大小*/
    private static int corePoolSize = 10;
    /** 线程池的最大线程数*/
    private static int maximumPoolSize = cpuNums * 5;

    public static ExecutorService httpApiThreadPool = null;


    /**
     * 静态方法
     */
    static{
        System.out.println("-------"+cpuNums);
        System.out.println("创建线程数:"+corePoolSize+",最大线程数:"+maximumPoolSize);
        //建立10个核心线程，线程请求个数超过20，则进入队列等待
        httpApiThreadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(30),new NamedThreadFactory("test_",true),new ThreadPoolExecutor.DiscardPolicy());
    }

    public static void main(String[] args) {
        for (int i=0;i<50;i++) {
            ThreadPoolDemo1.httpApiThreadPool.execute(new Runnable() {
                @Override
                public void run() {

                    try {

                        System.out.println(Thread.currentThread().getName()+":-------测试");
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
        }
    }

}
