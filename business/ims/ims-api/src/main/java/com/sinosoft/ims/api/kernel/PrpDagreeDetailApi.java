package com.sinosoft.ims.api.kernel;

import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.kernel.dto.PrpDagreeDetailDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description PrpDagreeDetailApi接口
 */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = PrpDagreeDetailApi.PATH)
public interface PrpDagreeDetailApi {

    public static final String PATH = "prpDagreeDetail";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpDagreeDetailDto prpDagreeDetailDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String agreementNo, String riskCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpDagreeDetailDto prpDagreeDetailDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDagreeDetailDto queryByPK(String agreementNo, String riskCode);
}