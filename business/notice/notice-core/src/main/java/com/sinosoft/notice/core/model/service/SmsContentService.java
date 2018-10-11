package com.sinosoft.notice.core.model.service;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.notice.api.common.dto.SmsConditionDto;
import com.sinosoft.notice.api.common.dto.SmsContentDto;

/**
 * @author 潘峰
 * @date 2017/12/11 上午11:14
 */
public interface SmsContentService {


    /**
     * 短信发送列表信息查询
     *
     * @param smsConditionDto 包含查询条件的dto
     * @return 分页查询得到的数据
     * @author: 何伟东
     * @date: 2017/12/12 11:39
     */
    PageInfo<SmsContentDto> querySmsListByCondition(SmsConditionDto smsConditionDto);
}
