package com.wkk.wkkbjsb.business.mq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.controller
 * @Description : TODO
 * @Create on : 2020/9/2 17:52
 * @email : lgy961228@gamil.com
 **/
public class ProducerOneWay {

    public static void main(String[] args) throws Exception {
        // 指定生产组名为my-producer
        DefaultMQProducer producer = new DefaultMQProducer("my-producer");
        // 配置namesrv地址
        producer.setNamesrvAddr("127.0.0.1:9876");
        // 启动Producer
        producer.start();

        // 创建消息对象，topic为：myTopic001，消息内容为：hello world oneway
        Message msg = new Message("myTopic003", "mytags","hello world oneway".getBytes());
        // 效率最高，因为oneway不关心是否发送成功，我就投递一下我就不管了。所以返回是void
        producer.sendOneway(msg);
        System.out.println("投递消息成功！，注意这里是投递成功，而不是发送消息成功哦！因为我sendOneway也不知道到底成没成功，我没返回值的。");
        producer.shutdown();
        System.out.println("生产者 shutdown！");
    }
}
