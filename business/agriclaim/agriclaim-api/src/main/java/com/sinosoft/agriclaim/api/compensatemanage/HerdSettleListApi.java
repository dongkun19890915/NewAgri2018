package com.sinosoft.agriclaim.api.compensatemanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.compensatemanage.dto.HerdSettleListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * @description 养殖险理赔明细表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = HerdSettleListApi.PATH)
public interface HerdSettleListApi {

    public static final String PATH = "herdSettleList";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(HerdSettleListDto herdSettleListDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String settlelistCode,String earlabel,String fCode,String kindCode,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(HerdSettleListDto herdSettleListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    HerdSettleListDto queryByPK(String settlelistCode,String earlabel,String fCode,String kindCode,java.lang.Integer serialNo);
}