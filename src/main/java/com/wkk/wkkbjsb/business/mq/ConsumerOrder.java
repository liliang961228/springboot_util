package com.wkk.wkkbjsb.business.mq;


import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.controller
 * @Description : TODO
 * @Create on : 2020/9/4 11:27
 * @email : lgy961228@gamil.com
 **/
public class ConsumerOrder {

    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("my-consumer");
        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.subscribe("orderTopic", "*");
        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                for (MessageExt msg : msgs) {
                    System.out.println(new String(msg.getBody()) + " Thread:" + Thread.currentThread().getName() + " queueid:" + msg.getQueueId());
                }

                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        consumer.start();
        consumer.setConsumeThreadMax(1);
        System.out.println("Consumer start...");
    }
}
