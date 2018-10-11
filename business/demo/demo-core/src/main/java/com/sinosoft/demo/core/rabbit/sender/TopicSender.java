package com.sinosoft.demo.core.rabbit.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* @Description: rabbitMQ消息发送样例代码  topic模式
* @Author: 周家伟
* @Date: 2017/10/26 9:12
*/
@Component
public class TopicSender {
    //  rabbitmq 服务器暂时没有启动，所以暂时屏蔽相关样例代码
//    /**
//     * @description: 普通字符串发送
//     * @author: 周家伟
//     * @date: 2017/10/26 8:48
//     * @param message
//     */
//    @Autowired
//    private AmqpTemplate template;
//    public void sendString(String message) {
//        template.convertAndSend("exchange","topic.message",message);
//    }
}
