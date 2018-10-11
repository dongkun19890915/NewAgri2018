package com.sinosoft.agriclaim.api.checkmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLCheckExtDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:38:49.324 
 * @description 查勘/代查勘扩展表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLCheckExtApi.PATH)
public interface PrpLCheckExtApi {

    public static final String PATH = "prpLCheckExt";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpLCheckExtDto prpLCheckExtDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String registNo,java.lang.Integer serialNo,String columnName,java.lang.Integer referSerialNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpLCheckExtDto prpLCheckExtDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLCheckExtDto queryByPK(String registNo,java.lang.Integer serialNo,String columnName,java.lang.Integer referSerialNo);
}