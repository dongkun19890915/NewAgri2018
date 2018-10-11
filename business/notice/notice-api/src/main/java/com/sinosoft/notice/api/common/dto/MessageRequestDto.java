package com.sinosoft.notice.api.common.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

public class MessageRequestDto extends BaseRequest implements Serializable {
    private List<MessageSendDto> messageSendDtoList;

    public List<MessageSendDto> getMessageSendDtoList() {
        return messageSendDtoList;
    }

    public void setMessageSendDtoList(List<MessageSendDto> messageSendDtoList) {
        this.messageSendDtoList = messageSendDtoList;
    }
}
