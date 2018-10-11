package com.sinosoft.notice.api.common.dto;

/**
 * @author 潘峰
 * @date 2017/12/6 上午9:01
 */
public class MessageConfig {


    /**
     * 1 短信 2邮件
     */
    public static final String NOTICETYPE_MESSAGE = "1";

    /**
     * 1 短信 2邮件
     */
    public static final String NOTICETYPE_EMAIL = "2";


    /**
     * 发送短信优先权 1最低
     */
    public static final String PRIORITY_FIRST = "1";

    /**
     * 发送短信优先权 2 中等
     */
    public static final String PRIORITY_SECOND = "2";

    /**
     * 发送短信优先权 3 最高
     */
    public static final String PRIORITY_THIRD = "3";

    /**
     * 短信模板默认启用状态， 1启用
     */
    public static final String STATUS_ON = "1";

    /**
     * 短信模板默认启用状态， 0 停用
     */
    public static final String STATUS_OF = "0";

    /**
     * 短信模板删除状态， 1未删除
     */
    public static final String DELETE_ON = "1";

    /**
     * 短信模板删除状态， 0删除
     */
    public static final String DELETE_OF = "0";


    /**
     * 短信状态发送失败
     */
    public static final String MESSAGE_FAIL = "0";

    /**
     * 短信状态未发送
     */
    public static final String MESSAGE_UNSENT = "1";


    /**
     * 短信状态正在发送
     */
    public static final String MESSAGE_SENDING = "2";

    /**
     * 短信状态已发送
     */
    public static final String MESSAGE_SENT = "3";








    public static final String SMSTEMPLATE = "smstemplate";
}
