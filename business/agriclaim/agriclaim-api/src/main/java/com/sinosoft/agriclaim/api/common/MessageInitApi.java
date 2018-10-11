package com.sinosoft.agriclaim.api.common;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.common.dto.MessageInitDto;
import com.sinosoft.agriclaim.api.common.dto.MessageInitRequestDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME,path = MessageInitApi.PATH )
public interface MessageInitApi {
    public static final String PATH="messageInit";

    @RequestMapping(value = "messageInit",method = RequestMethod.POST)
    public MessageInitDto messageInit(@RequestBody MessageInitRequestDto messageInitRequestDto) throws Exception;

}
