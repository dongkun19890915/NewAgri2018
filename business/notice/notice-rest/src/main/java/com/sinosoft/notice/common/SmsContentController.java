package com.sinosoft.notice.common;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.notice.api.common.SmsContentApi;
import com.sinosoft.notice.api.common.dto.SmsConditionDto;
import com.sinosoft.notice.api.common.dto.SmsContentDto;
import com.sinosoft.notice.core.model.service.SmsContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 潘峰
 * @date 2017/12/11 上午11:13
 */
@RestController
@RequestMapping(value = SmsContentController.PATH)
public class SmsContentController implements SmsContentApi {

    @Autowired
    private SmsContentService smsContentService;


    /**
     * 短信发送列表信息查询
     *
     * @param smsConditionDto 包含查询条件的dto
     * @return 分页查询得到的数据
     * @author: 何伟东
     * @date: 2017/12/12 11:39
     */
    @Override
    public PageInfo<SmsContentDto> querySmsListByCondition(@RequestBody SmsConditionDto smsConditionDto) {
        return smsContentService.querySmsListByCondition(smsConditionDto);
    }
}
