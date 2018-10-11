package com.sinosoft.dms.web.customer;

import com.sinosoft.dms.api.customer.PrpDcustomLevelTraceApi;
import com.sinosoft.dms.core.customer.service.PrpDcustomLevelTraceService;
import com.sinosoft.dms.api.customer.dto.PrpDcustomLevelTraceDto;
import com.sinosoft.framework.dto.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 02:23:45.341 
 * @description 客户风险等级轨迹表controller层
 */
@RestController
@RequestMapping(value = PrpDcustomLevelTraceController.PATH)
public class PrpDcustomLevelTraceController implements PrpDcustomLevelTraceApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDcustomLevelTraceController.class);

    @Autowired
    private PrpDcustomLevelTraceService prpDcustomLevelTraceService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDcustomLevelTraceDto prpDcustomLevelTraceDto) {
        prpDcustomLevelTraceService.save(prpDcustomLevelTraceDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam(value = "customerCode") String customerCode,@RequestParam(value = "lineNo")Integer lineNo) {
        prpDcustomLevelTraceService.remove(customerCode,lineNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDcustomLevelTraceDto prpDcustomLevelTraceDto) {
        prpDcustomLevelTraceService.modify(prpDcustomLevelTraceDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDcustomLevelTraceDto queryByPK(@RequestParam(value = "customerCode") String customerCode,
                                             @RequestParam(value = "lineNo")Integer lineNo) {
        return prpDcustomLevelTraceService.queryByPK(customerCode,lineNo);
    }

    @Override
    public @ResponseBody String findRiskLevelByCode(@RequestParam(value = "customerCode")String customerCode) {
        return prpDcustomLevelTraceService.findRiskLevelByCode(customerCode);
    }
    /**
     *  根据客户代码查询最新的客户风险等级信息
     * @author: 田健
     * @date: 2018/4/4 16:57
     * @param customerCode 客户代码
     * @return 客户风险等级信息
     */
    @Override
    public @ResponseBody PrpDcustomLevelTraceDto findRiskLevelByCustomerCode(@RequestParam(value = "customerCode")String customerCode) {
        return prpDcustomLevelTraceService.findRiskLevelByCustomerCode(customerCode);
    }

}
