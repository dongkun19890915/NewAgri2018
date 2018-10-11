package com.sinosoft.agriclaim.api.businessutilmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLGrowthDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 生长期表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLGrowthApi.PATH)
public interface PrpLGrowthApi {

    public static final String PATH = "prpLGrowth";

    /**
     * 查询生长期
     * @author: 孙朋飞
     * @date: 2018/3/21 14:47
     * @param prpLGrowthDto 险种-riskCode,条款-clauseCode,标的-itemCode,险别-kindCode
     * @return 生长期集合
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpLGrowthByConditions",method = {RequestMethod.POST})
    @ResponseBody public List<PrpLGrowthDto> queryPrpLGrowthByConditions(@RequestBody PrpLGrowthDto prpLGrowthDto) throws Exception;

    /**
     * 查询条款和标的
     * @author: 孙朋飞
     * @date: 2018/3/23 17:06
     * @param map policyNo-保单号和registNo-报案号
     * @return 条款和标的
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpLRegistAndPrpCmainByConditions",method = {RequestMethod.POST})
    @ResponseBody public Map<String,String> queryPrpLRegistAndPrpCmainByConditions(@RequestBody Map<String,String> map) throws Exception;

}