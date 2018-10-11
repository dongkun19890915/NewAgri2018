package com.sinosoft.agriclaim.web.compensatemanage;

import com.sinosoft.agriclaim.api.compensatemanage.PrpLCFeeApi;
import com.sinosoft.agriclaim.core.compensatemanage.service.PrpLCFeeService;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCFeeDto;
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
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * @description 赔款计算金额表controller层
 */
@RestController
@RequestMapping(value = PrpLCFeeController.PATH)
public class PrpLCFeeController implements PrpLCFeeApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLCFeeController.class);

    @Autowired
    private PrpLCFeeService prpLCFeeService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLCFeeDto prpLCFeeDto) {
        prpLCFeeService.save(prpLCFeeDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String compensateNo,String policyNo,String currency) {
        prpLCFeeService.remove(compensateNo,policyNo,currency);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLCFeeDto prpLCFeeDto) {
        prpLCFeeService.modify(prpLCFeeDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCFeeDto queryByPK(@RequestBody String compensateNo,String policyNo,String currency) {
        return prpLCFeeService.queryByPK(compensateNo,policyNo,currency);
    }
}
