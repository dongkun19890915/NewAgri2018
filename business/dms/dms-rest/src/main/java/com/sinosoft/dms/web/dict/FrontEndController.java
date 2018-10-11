package com.sinosoft.dms.web.dict;


import com.sinosoft.dms.api.dict.FrontEndApi;
import com.sinosoft.dms.api.dict.dto.FrontEndDto;
import com.sinosoft.dms.core.dict.service.FrontEndService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*
* @author: 钱浩
* @date: 2018/5/16 下午 15:16
* */
@RestController
@RequestMapping(value = FrontEndApi.PATH)
public class FrontEndController implements FrontEndApi {

    private static Logger LOGGER = LoggerFactory.getLogger(FrontEndController.class);

    @Resource
    private FrontEndService frontEndService;

    public @ResponseBody
    FrontEndDto queryFrontEnd() throws Exception {
        return frontEndService.queryFrontEnd();
    }
}
