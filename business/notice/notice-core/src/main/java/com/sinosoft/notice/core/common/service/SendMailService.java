package com.sinosoft.notice.core.common.service;

import java.util.Map;

/**
 * @description 邮件发送(短信和邮件)
 * @author zhukai
 * @date 2018年05月17日下午7:30:55
 */
public interface SendMailService {
    boolean sendMail(Map map);
}
