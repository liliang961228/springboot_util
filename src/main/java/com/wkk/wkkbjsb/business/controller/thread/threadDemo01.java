package com.wkk.wkkbjsb.business.controller.thread;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.controller
 * @Description : TODO
 * @Create on : 2020/12/9 15:02
 * @email : lgy961228@gamil.com
 **/
public class threadDemo01 {

    public static void main(String[] args) {
        // 基于子类的方式
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true) {
                    printThreadInfo();
                }
            }
        };
        thread.start();
        thread.setName("11111");

        System.out.println("22222222");

        // 基于接口的实现
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    printThreadInfo();
                }
            }
        }).start();
    }

    private static void printThreadInfo() {

        System.out.println("当前运行的线程名为： " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
