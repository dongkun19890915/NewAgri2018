package com.sinosoft.pms.api.kernel;

import com.sinosoft.pms.api.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.PrpDshortRateDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * @description 月短期费率表Api接口
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = PrpDshortRateApi.PATH)
public interface PrpDshortRateApi {

    String PATH = "prpDshortRate";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpDshortRateDto prpDshortRateDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestBody Map<String,Object> map);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpDshortRateDto prpDshortRateDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDshortRateDto queryByPK(@RequestBody Map<String,Object> map);

    @RequestMapping(value = "queryPrpDshortRateDto",method = {RequestMethod.POST})
    @ResponseBody
    PrpDshortRateDto queryPrpDshortRateDto(@RequestParam("strRiskCode") String strRiskCode, @RequestParam("intMonth") Integer intMonth)throws Exception;

    /**
     * 根据险种和标的代码查询短期费率
     * @author: 刘曼曼
     * @date: 11:28 11:28
     * @param map riskCode itemCode 险种  标的
     * @return List<PrpDshortRateDto> 短期费率集合
     * @throws Exception
     */
    @RequestMapping(value = "queryByRiskCodeAndItemCode",method = {RequestMethod.POST})
    @ResponseBody List<PrpDshortRateDto> queryByRiskCodeAndItemCode(@RequestBody Map<String,String> map)throws Exception;
}