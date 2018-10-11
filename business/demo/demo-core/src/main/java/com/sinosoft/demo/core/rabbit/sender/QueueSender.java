package com.sinosoft.demo.core.rabbit.sender;

import com.sinosoft.demo.core.rabbit.dto.UserDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* @Description: rabbitMQ消息发送样例代码  默认模式
* @Author: 周家伟
* @Date: 2017/10/26 8:39
*/
@Component
public class QueueSender {
    //  rabbitmq 服务器暂时没有启动，所以暂时屏蔽相关样例代码
//    @Autowired
//    private AmqpTemplate template;
//
//    /**
//     * @description: 普通字符串发送
//     * @author: 周家伟
//     * @date: 2017/10/26 8:48
//     * @param message
//     */
//    public void sendString(String message) {
//        template.convertAndSend("queue",message);
//    }
//
//    /**
//     * @description: 普通对象
//     * @author: 周家伟
//     * @date: 2017/10/26 8:48
//     * @param userDto
//     */
//    public void sendUser(UserDto userDto) {
//        template.convertAndSend("queue2",userDto);
//    }
}
