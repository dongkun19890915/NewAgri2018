package com.sinosoft.agriprpall.web.common;

import com.sinosoft.agriprpall.api.common.GetRuleInUtiPlatConfigRuleApi;
import com.sinosoft.agriprpall.core.common.GetRuleInUtiPlatConfigRuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 12:54:07.447 
 * @description
 */
@RestController
@RequestMapping(value = GetRuleInUtiPlatConfigRuleController.PATH)
public class GetRuleInUtiPlatConfigRuleController implements GetRuleInUtiPlatConfigRuleApi {

    private static Logger LOGGER = LoggerFactory.getLogger(GetRuleInUtiPlatConfigRuleController.class);

    @Autowired
    private GetRuleInUtiPlatConfigRuleService getRuleInUtiPlatConfigRuleService;
    /**
     * @description: 多条件查询tablename
     * @author: 钱浩
     * @date: 2017/10/30 10:02
     * @param systemCode 系统
     * @param paramCode 表代码
     * @param serialNo 标志
     * @return
     */

    public String queryfindOne(String systemCode,String paramCode,String serialNo)throws Exception{
        return getRuleInUtiPlatConfigRuleService.queryfindOne(systemCode,paramCode,serialNo);
    }
    /**
     * @description:平台对接
     * @author: 钱浩
     * @date: 2017/10/25 11:23
     * @param paramCode 表代码
     * @return
     * @throws Exception
     */

    public String getProperty(String paramCode) throws Exception{
        return getRuleInUtiPlatConfigRuleService.getProperty(paramCode);
    }
}
