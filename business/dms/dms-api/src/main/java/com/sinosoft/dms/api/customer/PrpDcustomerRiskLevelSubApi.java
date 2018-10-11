package com.sinosoft.dms.api.customer;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerRiskLevelSubDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * @description 记录客户风险等级详细表Api接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpDcustomerRiskLevelSubApi.PATH)
public interface PrpDcustomerRiskLevelSubApi {

    public static final String PATH = "prpdcustomerrisklevelsub";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpDcustomerRiskLevelSubDto prpdcustomerrisklevelsubDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String customerRiskLevelId);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpDcustomerRiskLevelSubDto prpdcustomerrisklevelsubDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDcustomerRiskLevelSubDto queryByPK(String customerRiskLevelId);

    /**
     * （查询被保险人和投保人风险等级）
     * @author: 王志文
     * @date: 2018/3/31 17:55
     * @param policyNo 保单号
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryRiskLevel",method = {RequestMethod.POST})
    List<PrpDcustomerRiskLevelSubDto> queryRiskLevel(@RequestParam("policyNo") String policyNo)throws Exception;
}