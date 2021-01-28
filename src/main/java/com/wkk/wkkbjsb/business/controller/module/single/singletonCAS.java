package com.wkk.wkkbjsb.business.controller.module.single;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.controller.module.single
 * @Description : TODO
 * @Create on : 2021/1/7 13:21
 * @email : lgy961228@gamil.com
 **/
public class singletonCAS {

    private static final AtomicReference<singletonCAS> INSTANCE =
            new AtomicReference<singletonCAS>();

    private static singletonCAS instance;

    private singletonCAS() {
    }

    public static final singletonCAS getInstance() {
        for (; ; ) {
            singletonCAS instance = INSTANCE.get();
            if (null != instance) {
                return instance;
            }
            INSTANCE.compareAndSet(null, new singletonCAS());
            return INSTANCE.get();
        }
    }

    public static void main(String[] args) {
        singletonCAS instance = singletonCAS.getInstance();
    }

}
