package com.sinosoft.agriclaim.api.claimmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.claimmanage.dto.ClaimDto1;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimLossDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * @description 立案险别估损金额表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLClaimLossApi.PATH)
public interface PrpLClaimLossApi {

    public static final String PATH = "prpLClaimLoss";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpLClaimLossDto prpLClaimLossDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("claimNo") String claimNo,@RequestParam("serialNo") java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpLClaimLossDto prpLClaimLossDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLClaimLossDto queryByPK(@RequestParam("claimNo") String claimNo,@RequestParam("serialNo") java.lang.Integer serialNo);

    /**
     *  根据立案号查询PrpLClaimLoss表信息
     * @author: 汪钊
     * @date: 2017/11/20 15:50
     * @param map 包括claimNo立案号
     * @return prpLClaimLossDtoList 返回PrpLClaimLossDto的集合
     */
    @RequestMapping(value = "queryByClaimNo",method = {RequestMethod.POST})
    public List<PrpLClaimLossDto> queryByClaimNo(@RequestBody Map<String,String> map);

    @RequestMapping(value = "saveCLaimLoss",method = {RequestMethod.POST})
    String saveCLaimLoss(@RequestBody ClaimDto1 claimDto)throws Exception;

}