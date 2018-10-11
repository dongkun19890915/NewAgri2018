package com.sinosoft.demo.core.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* @Description: 消息队列配置信息
* @Author: 周家伟
* @Date: 2017/10/25 17:44
*/
@Configuration
public class SenderConf {
//  rabbitmq 服务器暂时没有启动，所以暂时屏蔽相关样例代码
//    //默认模式 satrt
//
//    /**
//     * @description: 默认模式 发送普通String
//     * @author: 周家伟
//     * @date: 2017/10/26 8:43
//     * @return
//     */
//    @Bean
//    public Queue queue() {
//        return new Queue("queue");
//    }
//    /**
//     * @description: 默认模式 发送对象
//     * @author: 周家伟
//     * @date: 2017/10/26 8:43
//     * @return
//     */
//    @Bean
//    public Queue queue2() {
//        return new Queue("queue2");
//    }
//    //默认模式 end
//
//
//    // 转发模式topic  start
//    @Bean(name="message")
//    public Queue queueMessage() {
//        return new Queue("topic.message");
//    }
//
//    @Bean(name="messages")
//    public Queue queueMessages() {
//        return new Queue("topic.messages");
//    }
//
//    @Bean
//    public TopicExchange exchange() {
//        return new TopicExchange("exchange");
//    }
//
//    @Bean
//    Binding bindingExchangeMessage(@Qualifier("message") Queue queueMessage, TopicExchange exchange) {
//        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
//    }
//
//    @Bean
//    Binding bindingExchangeMessages(@Qualifier("messages") Queue queueMessages, TopicExchange exchange) {
//        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");//*表示一个词,#表示零个或多个词
//    }
//    // 转发模式  end
}
