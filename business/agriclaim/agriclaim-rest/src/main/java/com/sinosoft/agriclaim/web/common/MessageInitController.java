package com.sinosoft.agriclaim.web.common;

import com.sinosoft.agriclaim.api.common.MessageInitApi;
import com.sinosoft.agriclaim.api.common.dto.MessageInitDto;
import com.sinosoft.agriclaim.api.common.dto.MessageInitRequestDto;
import com.sinosoft.agriclaim.core.common.MessageInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = MessageInitApi.PATH)
public class MessageInitController implements MessageInitApi{
    @Autowired
    private MessageInitService messageInitService;

    @Override
    public MessageInitDto messageInit(@RequestBody MessageInitRequestDto messageInitRequestDto) throws Exception {
        return messageInitService.messageInit(messageInitRequestDto);
    }
}
