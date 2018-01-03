package com.abin.lee.spring.rocketmq.skeleton.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.MixAll;
import org.apache.rocketmq.common.message.MessageExt;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by abin on 2018/1/3 19:02.
 * spring-rocketmq1
 * com.abin.lee.spring.rocketmq.skeleton
 */
public class RocketmqConsumer {

    public static void main(String[] args) throws InterruptedException, MQClientException, IOException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("SPEED.QUEUE");
        consumer.setNamesrvAddr("172.16.2.133:9876");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();


        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.start();

        System.out.printf("Consumer Started.%n");
    }



}
