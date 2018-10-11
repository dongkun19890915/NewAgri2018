package com.sinosoft.agriclaim.web.businessutilmanage;

import com.sinosoft.agriclaim.api.businessutilmanage.PrpLGrowthApi;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLGrowthDto;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLGrowthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 生长期表controller
 * @Author: 孙朋飞
 * @Date: 2018/3/21 14:27
 */
@RestController
@RequestMapping(value = PrpLGrowthController.PATH)
public class PrpLGrowthController implements PrpLGrowthApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLGrowthController.class);

    @Autowired
    private PrpLGrowthService prpLGrowthService;
    /**
     * 查询生长期
     * @author: 孙朋飞
     * @date: 2018/3/21 14:47
     * @param prpLGrowthDto 险种-riskCode,条款-clauseCode,标的-itemCode,险别-kindCode
     * @return 生长期集合
     * @throws Exception
     */
    @Override
    @ResponseBody public List<PrpLGrowthDto> queryPrpLGrowthByConditions(@RequestBody PrpLGrowthDto prpLGrowthDto) throws Exception {
        return prpLGrowthService.queryPrpLGrowthByConditions(prpLGrowthDto);
    }
    /**
     * 查询条款和标的
     * @author: 孙朋飞
     * @date: 2018/3/23 17:06
     * @param map policyNo-保单号和registNo-报案号
     * @return 条款和标的
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String, String> queryPrpLRegistAndPrpCmainByConditions(@RequestBody Map<String, String> map) throws Exception {
        return prpLGrowthService.queryPrpLRegistAndPrpCmainByConditions(map.get("policyNo"),map.get("registNo"));
    }
}
