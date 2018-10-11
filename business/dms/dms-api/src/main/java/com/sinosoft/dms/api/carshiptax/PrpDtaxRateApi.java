package com.sinosoft.dms.api.carshiptax;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.carshiptax.dto.PrpDtaxRateDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-08-25 08:49:27.222
 * @description 税率表Api接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpDtaxRateApi.PATH)
public interface PrpDtaxRateApi {

    public static final String PATH = "prpDtaxRate";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpDtaxRateDto prpDtaxRateDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam(value="comCode") String comCode,@RequestParam(value="taxPeriod") java.lang.Integer taxPeriod,@RequestParam(value="serialNo") java.lang.Integer serialNo,@RequestParam(value="taxItemCode") String taxItemCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpDtaxRateDto prpDtaxRateDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDtaxRateDto queryByPK(@RequestParam(value="comCode") String comCode,@RequestParam(value="taxPeriod") java.lang.Integer taxPeriod,@RequestParam(value="serialNo") java.lang.Integer serialNo,@RequestParam(value="taxItemCode") String taxItemCode);
    /**
     *@description 获取税率
     *@param
     */
    @RequestMapping(value = "getTaxRate",method = {RequestMethod.POST})
    PrpDtaxRateDto getTaxRate(PrpDtaxRateDto prpDtaxRateDto) throws Exception;
}