package com.sinosoft.ims.api.kernel;

import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.kernel.dto.PrpDagreementDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description 代理协议表Api接口
 */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = PrpDagreementApi.PATH)
public interface PrpDagreementApi {

    public static final String PATH = "prpDagreement";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpDagreementDto prpDagreementDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String agreementNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpDagreementDto prpDagreementDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDagreementDto queryByPK(String agreementNo);
}