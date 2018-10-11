package com.sinosoft.notice.api.common;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.notice.NoticeConstant;
import com.sinosoft.notice.api.common.dto.SmsConditionDto;
import com.sinosoft.notice.api.common.dto.SmsContentDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 潘峰
 * @date 2017/12/11 上午11:01
 */
@FeignClient(name = NoticeConstant.NOTICE_SERVICE_NAME, path = SmsContentApi.PATH)
public interface SmsContentApi {

    String PATH = "smsContent";

    /**
     * 短信发送列表信息查询
     *
     * @param smsConditionDto 包含查询条件的dto
     * @return 分页查询得到的数据
     * @author: 何伟东
     * @date: 2017/12/12 11:39
     */
    @RequestMapping(value = "/querySmsListByCondition", method = RequestMethod.POST)
    PageInfo<SmsContentDto> querySmsListByCondition(@RequestBody SmsConditionDto smsConditionDto);


}
