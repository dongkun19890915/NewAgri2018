package com.sinosoft.demo.web;

import com.sinosoft.demo.core.rabbit.dto.UserDto;
import com.sinosoft.demo.core.rabbit.sender.QueueSender;
import com.sinosoft.demo.core.rabbit.sender.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
* @Description: 消息队列测试类
* @Author: 周家伟
* @Date: 2017/10/26 10:35
*/
@SpringBootTest(classes=DemoWebApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RabbitMQTest {
//    @Autowired
//    private QueueSender queueSender;
//    @Autowired
//    private TopicSender topicSender;
//
//    /**
//     * @description: rabbitMQ测试-默认模式 字符串
//     * @author: 周家伟
//     * @date: 2017/10/26 8:51
//     */
//    @Test
//    public void testRabbitQueueString() {
//        for(int i=0;i<10000;i++){
//            queueSender.sendString("hello，queue "+i);
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    /**
//     * @description: rabbitMQ测试-默认模式 对象
//     * @author: 周家伟
//     * @date: 2017/10/26 8:51
//     */
//    @Test
//    public void testRabbitQueueDto() {
//        for(int i=0;i<10000;i++){
//            UserDto userDto = new UserDto();
//            userDto.setUserCode("0000000000");
//            userDto.setUserName("系统管理员");
//            queueSender.sendUser(userDto);
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    /**
//     * @description: rabbitMQ测试-topic模式 字符串
//     * @author: 周家伟
//     * @date: 2017/10/26 8:51
//     */
//    @Test
//    public void testRabbitTopicString() {
//        for(int i=0;i<100;i++){
//            topicSender.sendString("hello，queue");
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
