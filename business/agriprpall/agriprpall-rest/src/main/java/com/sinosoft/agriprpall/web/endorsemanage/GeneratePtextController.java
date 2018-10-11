package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.GeneratePtextApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GeneratePtextService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 01:44:37.955 
 * @description 批改文controller层
 */
@RestController
@RequestMapping(value = GeneratePtextController.PATH)
public class GeneratePtextController implements GeneratePtextApi {

    private static Logger LOGGER = LoggerFactory.getLogger(GeneratePtextController.class);

    @Autowired
    private GeneratePtextService generatePtextService;
    /**
    * 生成批文
    * @param policyEndorseDto
    * @return com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto
    * @throws
    * @author 李冬松
    * @date 14:27 2017/12/13
    */
    public @ResponseBody
    BLEndorseDto generateUsual(@RequestBody PolicyEndorseDto policyEndorseDto) throws Exception{
        return  generatePtextService.generateUsual(policyEndorseDto);
    }


}
