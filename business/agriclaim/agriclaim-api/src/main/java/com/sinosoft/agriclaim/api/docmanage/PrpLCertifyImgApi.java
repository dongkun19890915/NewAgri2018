package com.sinosoft.agriclaim.api.docmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.docmanage.dto.PrpLCertifyImgDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:41:23.407 
 * @description 单证及影像表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLCertifyImgApi.PATH)
public interface PrpLCertifyImgApi {

    public static final String PATH = "prpLCertifyImg";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpLCertifyImgDto prpLCertifyImgDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String businessNo,java.lang.Double serialNo,String lossItemCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpLCertifyImgDto prpLCertifyImgDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLCertifyImgDto queryByPK(String businessNo,java.lang.Double serialNo,String lossItemCode);
}