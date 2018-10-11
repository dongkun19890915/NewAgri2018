package com.sinosoft.notice.core.common.service;

import com.sinosoft.notice.api.common.dto.MessageRequestDto;
import com.sinosoft.notice.api.common.dto.NoticeConditionDto;
import com.sinosoft.notice.api.common.dto.NoticeReturnDto;


/**
 * @description 信息发送(短信和邮件)
 * @author zkr10
 * @date 2016年10月12日下午7:30:55
 */
public interface SendNoticeService {


    /**
     * @param noticeConditionDto
     * @return
     * @throws Exception
     * @description 短信和邮件发送
     * @author 潘峰
     * @date 2016年10月12日下午7:31:12
     */
    NoticeReturnDto sendNotice(NoticeConditionDto noticeConditionDto) throws Exception;

    String test() throws Exception;

    /**
     * @param content
     * @return
     * @throws Exception
     * @description 短信重新发送
     * @author 潘峰
     * @date 2016年10月12日下午7:31:12
     */
    NoticeReturnDto resendNotice(String content);

    /**
     * 校验是否已经预约发送
     *
     * @param policyNo
     * @return
     * @throws Exception
     * @author: 潘峰
     * @date: 31/01/2018 9:57 AM
     */
    Integer checkAppointment(String policyNo);


    /**
     * 发送理赔短信
     *
     * @param policyNo
     * @return
     * @throws Exception
     * @author: 王保良
     * @date: 11/04/2018 9:57 AM
     */
    String sendMessage(MessageRequestDto messageRequestDto) throws Exception;
}


