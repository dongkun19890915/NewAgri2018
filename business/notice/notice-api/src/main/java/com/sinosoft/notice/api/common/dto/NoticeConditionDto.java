package com.sinosoft.notice.api.common.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;


/**
 * @description 短信发送公共方法
 * @author zkr10
 * @date 2016年10月10日上午11:25:37
 */
public class NoticeConditionDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<RepMessageDto> repMessageDtoList;


    private ReqMessageDto reqMessageDto;

    public List<RepMessageDto> getRepMessageDtoList() {
        return repMessageDtoList;
    }

    public void setRepMessageDtoList(List<RepMessageDto> repMessageDtoList) {
        this.repMessageDtoList = repMessageDtoList;
    }

    public ReqMessageDto getReqMessageDto() {
        return reqMessageDto;
    }

    public void setReqMessageDto(ReqMessageDto reqMessageDto) {
        this.reqMessageDto = reqMessageDto;
    }
}
