package com.sinosoft.notice.core.common.service.impl;


import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.notice.api.common.dto.*;
import com.sinosoft.notice.core.common.enums.NoticeErrorEnum;
import com.sinosoft.notice.core.common.service.SendNoticeService;
import com.sinosoft.notice.core.common.utils.FreemarkerUtil;
import com.sinosoft.notice.core.model.dao.SmsContentDao;
import com.sinosoft.notice.core.model.entity.SmsContent;
import com.sinosoft.notice.core.model.entity.SmsContentKey;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;


/**
 * @author 潘峰
 * @description 短信发送公共方法
 * @date 2016年10月10日上午11:25:37
 */
@Service
public class SendNoticeServiceImpl extends BaseServiceImpl implements SendNoticeService {

    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SendNoticeServiceImpl.class);

    @Autowired
    private SmsContentDao smsContentDao;

    //短信平台地址
    @Value("${smsService.url}")
    private String SMS_SERVER_URL;
    //短信平台模版号
    @Value("${smsService.moduleCode}")
    private String SMS_SERVER_MODULECODE;
    //短信平台生产标识 dev为生产，其它都是测试
    @Value("${smsService.profile}")
    private String SMS_SERVER_PROFILE;
    //测试环境 手机号码，短信全部发送到该手机上
    @Value("${smsService.devUserPhone}")
    private String SMS_SERVER_DEVUSERPHONE;


    /**
     * 短信,邮件交互公共方法
     *
     * @param noticeConditionDto
     * @return
     * @throws Exception
     * @author 潘峰
     * @date 2017年12月20日下午6:46:54
     */
    @Override
    public NoticeReturnDto sendNotice(NoticeConditionDto noticeConditionDto) throws Exception {

        ReqMessageDto reqMessageDto = noticeConditionDto.getReqMessageDto();
        NoticeReturnDto noticeReturnDto = new NoticeReturnDto();

        // 短信发送模块
        if (MessageConfig.NOTICETYPE_MESSAGE.equals(reqMessageDto.getNoticeType())) {

            String returnStr = sendSmsUtil(noticeConditionDto.getRepMessageDtoList(), reqMessageDto);

            if ("success".equals(returnStr)) {
                noticeReturnDto.setResultCode(NoticeErrorEnum.NOTICE_SUCCESS.getCode());
                noticeReturnDto.setResultMsg(NoticeErrorEnum.NOTICE_SUCCESS.getName());
            } else {
                noticeReturnDto.setResultCode(NoticeErrorEnum.NOTICE_ERROE.getCode());
                noticeReturnDto.setResultMsg(NoticeErrorEnum.NOTICE_ERROE.getName());
            }
        } else {
            //TODO 邮件模块
        }

        return noticeReturnDto;
    }


    /**
     * 重新发送短信
     *
     * @param id
     * @return
     * @author: 潘峰
     * @date: 2018/1/9 下午5:38
     */
    @Override
    public NoticeReturnDto resendNotice(String id) {
        SmsContent smsContent = smsContentDao.findOne(new SmsContentKey(id));
        smsContent.setSendTime(new Date());
        NoticeReturnDto noticeReturnDto = new NoticeReturnDto();
        if (sendMessage(smsContent)) {
            noticeReturnDto.setResultCode(NoticeErrorEnum.NOTICE_SUCCESS.getCode());
            noticeReturnDto.setResultMsg(NoticeErrorEnum.NOTICE_SUCCESS.getName());
            return noticeReturnDto;
        } else {
            noticeReturnDto.setResultCode(NoticeErrorEnum.NOTICE_ERROE.getCode());
            noticeReturnDto.setResultMsg(NoticeErrorEnum.NOTICE_ERROE.getName());
            return noticeReturnDto;
        }
    }

    @Override
    public Integer checkAppointment(String policyNo) {
        List<SmsContent> smsContents = smsContentDao.findByPolicyNo(policyNo);
        for (SmsContent smsContent : smsContents) {
            Date nowDate = new Date();
            Date sendTime = smsContent.getSendTime();
            int i = sendTime.compareTo(nowDate);
            if (i < 0) {
                throw new BusinessException("此保单已发送短信，不可重复发送！");
            } else {
                throw new BusinessException("此保单已预约发送短信，不可重复发送！");
            }
        }
        return smsContents.size();
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
    public String sendMessage(MessageRequestDto messageRequestDto) throws Exception {
//        for (int i = 0;i<messageRequestDto.getMessageSendDtoList().size();i++){
//            sendSMS(messageRequestDto.getMessageSendDtoList().get(i).getMobilePhones(),
//                    messageRequestDto.getMessageSendDtoList().get(i).getContent(),
//                    messageRequestDto.getMessageSendDtoList().get(i).getPriority(),
//                    messageRequestDto.getMessageSendDtoList().get(i).getModuleCode(),
//                    messageRequestDto.getMessageSendDtoList().get(i).getReceiveCode(),
//                    messageRequestDto.getMessageSendDtoList().get(i).getBusinessNo1());
//        }
        return "短信发送成功";
    }


    /**
     * 将短信模板与 发送短信的内容进行替换
     *
     * @param repMessageDtoList
     * @param reqMessageDto
     * @return
     * @throws Exception
     * @author: 潘峰
     * @date: 2017/12/22 上午9:13
     */
    private String sendSmsUtil(List<RepMessageDto> repMessageDtoList, ReqMessageDto reqMessageDto) throws Exception {

        if (reqMessageDto.getImmediatelySend()) {
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            reqMessageDto.setSendTime(dateformat.parse(dateformat.format(new Date())));
        }

        for (RepMessageDto repMessageDto : repMessageDtoList) {

            Map<String, String> map = setParameterListToMap(repMessageDto);
            //对内容进行替换
            String modelContent = FreemarkerUtil.freemarkerProcess(map, reqMessageDto.getNoticeContent());

            SmsContent smsContent = saveMessage(modelContent, repMessageDto, reqMessageDto.getSendTime());

            //如果用户是立即发送则直接发
            if (reqMessageDto.getImmediatelySend()) {
                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                smsContent.setSendTime(dateformat.parse(dateformat.format(new Date())));
                sendMessage(smsContent);
            }
            LOGGER.error("替换后的值为:modelContent={}", modelContent);
        }

        //TODO 短信发送实现逻辑待处理


        return "success";


    }


    /**
     * 精确到分钟，所以以59秒扫描一次
     * 先更新一条无关数据保证只执行一次
     */
    @Transactional
    @Scheduled(fixedRate = 59000)
    public void scanning() throws Exception {
        List<SmsContent> smsContentList = smsContentDao.findByTimeAndStatus();

        LOGGER.error("开始发送");
        for (SmsContent content : smsContentList) {
            SmsContent s = content.clone();
            smsContentDao.delete(new SmsContentKey(content.getId()));
            s.setDistributed(MessageConfig.MESSAGE_SENDING);
            smsContentDao.save(s);
            LOGGER.error("发送内容" + s.toString());
            sendMessage(content);
        }
    }


    @Override
    public String test() throws Exception {
        String mobilePhones = "mobilePhones";
        String content = "content-123-中国-，。";
        String priority = "3";
        String receive = "0";
        String businessNo1 = "businessNo1";
//        return sendSMS( mobilePhones,  content,  priority,  receive,  businessNo1);
        return "";
    }


    public Boolean sendMessage(SmsContent content) {
        String returnMessage;
        try {
            //returnMessage = "0000";
            returnMessage = sendSMS(content.getPhoneNo(), content.getContent(), MessageConfig.PRIORITY_SECOND, "0", content.getBusinessNo());
        } catch (Exception e) {
            e.printStackTrace();
            content.setDistributed(MessageConfig.MESSAGE_FAIL);
            smsContentDao.save(content);
            return false;
        }
        if ("0000".equals(returnMessage)) {
            content.setDistributed(MessageConfig.MESSAGE_SENT);
            smsContentDao.save(content);
            return true;
        } else if ("error".equals(returnMessage)) {
            content.setDistributed(MessageConfig.MESSAGE_FAIL);
            smsContentDao.save(content);
            return false;
        }
        return false;
    }

    /**
     * 保存短信信息
     *
     * @param modelContent
     * @param repMessageDto
     * @author: 潘峰
     * @date: 2017/12/25 上午9:42
     */
    private SmsContent saveMessage(String modelContent, RepMessageDto repMessageDto, Date sendTime) {
        SmsContent smsContent = this.convert(repMessageDto, SmsContent.class);
        smsContent.setContent(modelContent);
        smsContent.setId(UUID.randomUUID().toString());
        smsContent.setSendTime(sendTime);
        smsContent.setDistributed(MessageConfig.MESSAGE_UNSENT);
        SmsContent sms = smsContentDao.save(smsContent);
        return sms;
    }

    /**
     * @param mobilePhones 手机号 必要
     * @param content      短信内容  必要
     * @param priority     优先权 1，2，3
     * @param receive      是否需要回复 1 需要，0 不需要
     * @param businessNo1  业务号 非必须
     *                     返回数据类型为字符串型。需要回复的发送成功返回 回执编码（见短信回执编码），
     *                     不需要回复的发送成功返回统一返回0000，发送失败的统一返回error或其他异常值。
     */
    public String sendSMS(String mobilePhones, String content, String priority, String receive, String businessNo1) throws Exception {

        //如果不是dev生产环境
        if (SMS_SERVER_PROFILE.equals("prd")) {
            //如果是生产环境，不修改手机号码
        } else {

            //如果是非生产环境，则修改手机号码为开发人员手机号
            if (StringUtils.isEmpty(SMS_SERVER_DEVUSERPHONE)) {
                LOGGER.error("发送失败：smsService.devUserPhone未配置");
                return "error";
            }
            mobilePhones = SMS_SERVER_DEVUSERPHONE;
        }

        String strURL = SMS_SERVER_URL;
        String response = "";
        boolean success = false;
        strURL += "?MobilePhones=" + mobilePhones
                + "&Content=" + java.net.URLEncoder.encode(content, "GBK")
                + "&Priority=" + priority
                + "&ModuleCode=" + SMS_SERVER_MODULECODE
                + "&Receive=" + receive
                + "&BusinessNo1=" + businessNo1;
        URL objURL = new URL(strURL);
        String line = "error";
        BufferedReader br = null;
        try {
            URLConnection objConn = objURL.openConnection();
            objConn.setDoInput(true);
            //超时10秒
            objConn.setConnectTimeout(1000 * 10);
            br = new BufferedReader(new InputStreamReader(objConn.getInputStream()));
            line = br.readLine();
            while (line != null) {
                response += line;
                line = br.readLine();
            }
            LOGGER.info("发送短信成功：" + strURL + " " + line);
        } catch (Exception e) {
            LOGGER.error("发送短信失败：" + strURL + " " + line, e);
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return response;
    }


    /**
     * 使用反射，将List中的Dto属性添加到map中，并且key顺序递增
     *
     * @param <T> Dto的类型
     * @throws IllegalAccessException
     * @author: 潘峰
     * @date: 2017/12/5 10:19
     */
    private <T> Map<String, String> setParameterListToMap(T t) throws IllegalAccessException {
        Class<?> className = t.getClass();
        Field[] fields = className.getDeclaredFields();
        Field.setAccessible(fields, true);
        Map<String, String> map = new HashMap<>();
        for (Field field : fields) {
            map.put(field.getName(), String.valueOf(field.get(t)));
        }
        return map;
    }


}