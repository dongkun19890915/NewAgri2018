package com.sinosoft.demo.core.rabbit.receive;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
* @Description: rabbitMQ消息接收样例代码  topic模式
* @Author: 周家伟
* @Date: 2017/10/26 9:13
*/
@Component
public class TopicReceive {
    //  rabbitmq 服务器暂时没有启动，所以暂时屏蔽相关样例代码
//    @RabbitListener(queues="topic.message") //监听器监听指定的Queue
//    public void process1(String str) {
////        System.out.println("Receive:topic.message --- message:"+str);
//    }
//    @RabbitListener(queues="topic.messages") //监听器监听指定的Queue
//    public void process2(String str) {
////        System.out.println("Receive:topic.messages --- messages:"+str);
//    }
}
