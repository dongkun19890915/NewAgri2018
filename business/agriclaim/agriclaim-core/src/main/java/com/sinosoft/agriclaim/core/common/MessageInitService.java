package com.sinosoft.agriclaim.core.common;

import com.sinosoft.agriclaim.api.common.dto.MessageInitDto;
import com.sinosoft.agriclaim.api.common.dto.MessageInitRequestDto;

public interface MessageInitService {

    public MessageInitDto messageInit(MessageInitRequestDto messageInitRequestDto)throws Exception;
}
