package com.sinosoft.notice.common;

import com.sinosoft.notice.api.common.SendNoticeApi;
import com.sinosoft.notice.api.common.dto.MessageRequestDto;
import com.sinosoft.notice.api.common.dto.NoticeConditionDto;
import com.sinosoft.notice.api.common.dto.NoticeReturnDto;
import com.sinosoft.notice.core.common.service.SendMailService;
import com.sinosoft.notice.core.common.service.SendNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by gaofeng on 2017/7/28.
 */
@RestController
@RequestMapping(SendNoticeController.PATH)
public class SendNoticeController implements SendNoticeApi {

    @Autowired
    private SendNoticeService sendNoticeService;

    @Autowired
    private SendMailService  sendMailService;

    //短信平台模版号
    @Value("${smsService.moduleCode}")
    private String SMS_SERVER_MODULECODE;

    /**
     * @param noticeConditionDto
     * @return
     * @throws Exception
     * @description 短信和邮件发送
     * @author zkr10
     * @date 2016年10月12日下午7:31:12
     */
    @Override
    public NoticeReturnDto sendNotice(@RequestBody NoticeConditionDto noticeConditionDto) throws Exception {
        return sendNoticeService.sendNotice(noticeConditionDto);
    }


    @Override
    public String test() throws Exception{
//        System.out.println("SMS_SERVER_MODULECODE"+SMS_SERVER_MODULECODE);
//        return sendNoticeService.test();
        return null;
    }

    @Override
    public NoticeReturnDto resendNotice(@RequestBody Map<String, String> map) throws Exception {
        String id = map.get("id");
        return sendNoticeService.resendNotice(id);

    }

    /**
     * 校验是否已经预约发送
     *
     * @param policyNo
     * @return
     * @throws Exception
     * @author: 潘峰
     * @date: 31/01/2018 9:57 AM
     */
    @Override
    public Integer checkAppointment(@RequestParam("policyNo") String policyNo) throws Exception {
        return sendNoticeService.checkAppointment(policyNo);
    }

    /**
     * 发送理赔短信
     *
     * @param messageRequestDto
     * @return
     * @throws Exception
     * @author: 王保良
     * @date: 11/04/2018 9:57 AM
     */
    @Override
    public String sendSMS(@RequestBody MessageRequestDto messageRequestDto) throws Exception {
        return sendNoticeService.sendMessage(messageRequestDto);
    }

    /**
     * 发送电子保单邮件
     *
     * @param map
     * @return
     * @throws Exception
     * @author: 祝凯
     * @date: 2018/5/18
     */
    @Override
    public boolean sendMail(@RequestBody Map map) throws Exception {
        sendMailService.sendMail(map);
        return sendMailService.sendMail(map);
    }

}

