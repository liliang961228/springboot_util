package com.wkk.wkkbjsb.business.controller.thread;

import cn.hutool.core.date.DateUtil;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.controller
 * @Description : TODO
 * @Create on : 2020/12/9 15:12
 * @email : lgy961228@gamil.com
 **/


public class timerTreadDemo02 {

    public static void main(String[] args) {
        System.out.println(DateUtil.now());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(DateUtil.now());
                aaa();
            }
        }, 5000);
    }

    private static void aaa() {
        System.out.println(DateUtil.now());
        String name = Thread.currentThread().getName();
        System.out.println(name);
    }
}
