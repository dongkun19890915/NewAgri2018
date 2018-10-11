package com.sinosoft.notice.api.common;

import com.sinosoft.notice.NoticeConstant;
import com.sinosoft.notice.api.common.dto.MessageRequestDto;
import com.sinosoft.notice.api.common.dto.NoticeConditionDto;
import com.sinosoft.notice.api.common.dto.NoticeReturnDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by gaofeng on 2017/7/28.
 */
@FeignClient(name = NoticeConstant.NOTICE_SERVICE_NAME, path = SendNoticeApi.PATH)
public interface SendNoticeApi {
    String PATH = "sendNotice";


    /**
     * 短信邮件发送
     *
     * @param noticeConditionDto
     * @return
     * @throws Exception
     * @author: 潘峰
     * @date: 31/01/2018 9:57 AM
     */
    @RequestMapping(value = "/sendNotice", method = RequestMethod.POST)
    NoticeReturnDto sendNotice(@RequestBody NoticeConditionDto noticeConditionDto) throws Exception;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String test() throws Exception;

    /**
     * 短信重新发送
     *
     * @param map
     * @return
     * @throws Exception
     * @author: 潘峰
     * @date: 31/01/2018 9:57 AM
     */
    @RequestMapping(value = "/resendNotice", method = RequestMethod.POST)
    NoticeReturnDto resendNotice(@RequestBody Map<String, String> map) throws Exception;

    /**
     * 校验是否已经预约发送
     *
     * @param policyNo
     * @return
     * @throws Exception
     * @author: 潘峰
     * @date: 31/01/2018 9:57 AM
     */
    @RequestMapping(value = "/checkAppointment", method = RequestMethod.GET)
    Integer checkAppointment(@RequestParam("policyNo") String policyNo) throws Exception;

    /**
     * 发送理赔短信
     *
     * @param policyNo
     * @return
     * @throws Exception
     * @author: 王保良
     * @date: 11/04/2018 9:57 AM
     */
    @RequestMapping(value = "sendSms", method = RequestMethod.POST)
    public String sendSMS(@RequestBody MessageRequestDto messageRequestDto) throws Exception;

    /**
     * 发送理赔短信
     *
     * @param policyNo
     * @return
     * @throws Exception
     * @author: 祝凯
     * @date: 2018/5/18 AM
     */
    @RequestMapping(value = "sendMail", method = RequestMethod.POST)
    public boolean sendMail(@RequestBody Map map) throws Exception;
}


