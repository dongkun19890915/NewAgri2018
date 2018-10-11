package com.sinosoft.dms.api.customer;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.customer.dto.PrpDcustomLevelTraceDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 02:23:45.341 
 * @description 客户风险等级轨迹表Api接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpDcustomLevelTraceApi.PATH)
public interface PrpDcustomLevelTraceApi {

    public static final String PATH = "prpDcustomLevelTrace";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpDcustomLevelTraceDto prpDcustomLevelTraceDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam(value = "customerCode") String customerCode,@RequestParam(value = "lineNo") Integer lineNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpDcustomLevelTraceDto prpDcustomLevelTraceDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDcustomLevelTraceDto queryByPK(@RequestParam(value = "customerCode") String customerCode,@RequestParam(value = "lineNo") Integer lineNo);

    /**
     * @description 按照insuredCode查询最后一条客户风险等级
     * @param customerCode
     * @return
     * @author 王心洋
     * @date 2017年10月30日 12:00
     */
    @RequestMapping(value = "findRiskLevelByCode",method = {RequestMethod.POST})
    @ResponseBody String findRiskLevelByCode(@RequestParam(value = "customerCode") String customerCode);
    /**
     *  根据客户代码查询最新的客户风险等级信息
     * @author: 田健
     * @date: 2018/4/4 16:57
     * @param customerCode 客户代码
     * @return 客户风险等级信息
     */
    @RequestMapping(value = "findRiskLevelByCustomerCode",method = {RequestMethod.POST})
    @ResponseBody PrpDcustomLevelTraceDto findRiskLevelByCustomerCode(@RequestParam(value = "customerCode") String customerCode);
}