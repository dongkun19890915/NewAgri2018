package com.sinosoft.demo.core.rabbit.receive;

import com.sinosoft.demo.core.rabbit.dto.UserDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
* @Description: rabbitMQ消息接收样例代码 默认模式
* @Author: 周家伟
* @Date: 2017/10/26 8:39
*/
@Component
public class QueueReceive {
    //  rabbitmq 服务器暂时没有启动，所以暂时屏蔽相关样例代码
//    /**
//     * @description: 普通字符接收
//     * @author: 周家伟
//     * @date: 2017/10/26 8:49
//     * @param str
//     */
//    @RabbitListener(queues="queue")    //监听器监听指定的Queue
//    public void processC(String str) {
//        process("1------"+str);
//    }
//    @RabbitListener(queues="queue")    //监听器监听指定的Queue
//    public void processD(String str) {
//        process("2------"+str);
//    }
//
//    private void process(String str) {
//        java.util.Random r=new java.util.Random();
////        System.out.println("Receive:queue --- "+str);
//        try {
//            Thread.sleep(Math.round(r.nextDouble()*3000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * @description: 对象接收
//     * @author: 周家伟
//     * @date: 2017/10/26 8:49
//     * @param user
//     */
//    @RabbitListener(queues="queue2")    //监听器监听指定的Queue
//    public void processUser(UserDto user) {
//        System.out.println("Receive:queue --- "+user);
//    }
//    public static void main(String[] args) {
//        java.util.Random r=new java.util.Random();
//        for(int i=0;i<10;i++){
////            System.out.println(Math.round(r.nextDouble()*3000));
//        }
//    }
}
