package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.notice.api.common.dto.NoticeReturnDto;
import com.sinosoft.notice.api.common.dto.ReqMessageDto;

/**
 * @author 潘峰
 * @date 2017/12/19 上午10:17
 */
public interface VoucherSmsService {

    NoticeReturnDto getSmsContent(ReqMessageDto reqMessageDto) throws Exception;
    /**
     * 短信关联清单查询
     * @param policyNo
     * @return java.lang.Integer
     * @throws
     * @author 李冬松
     * @date 15:55 2018/4/9
     */
    Integer getSendNumber(String policyNo,String loginComCode, String userCode, String tableName, String userCodeFields, String comCodeFields) throws Exception;
}
