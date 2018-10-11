package com.sinosoft.dms.web.model;

import com.sinosoft.dms.api.model.PrpModelCustomerTaxPayInfoSubApi;
import com.sinosoft.dms.core.model.service.PrpModelCustomerTaxPayInfoSubService;
import com.sinosoft.dms.api.model.dto.PrpModelCustomerTaxPayInfoSubDto;
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
 * @time  2017-11-13 11:42:08.278 
 * @description 模板客户纳税人信息表controller层
 */
@RestController
@RequestMapping(value = PrpModelCustomerTaxPayInfoSubController.PATH)
public class PrpModelCustomerTaxPayInfoSubController implements PrpModelCustomerTaxPayInfoSubApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpModelCustomerTaxPayInfoSubController.class);

    @Autowired
    private PrpModelCustomerTaxPayInfoSubService prpModelCustomerTaxPayInfoSubService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpModelCustomerTaxPayInfoSubDto prpModelCustomerTaxPayInfoSubDto) {
        prpModelCustomerTaxPayInfoSubService.save(prpModelCustomerTaxPayInfoSubDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestBody String modelCode) {
        prpModelCustomerTaxPayInfoSubService.remove(modelCode);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpModelCustomerTaxPayInfoSubDto prpModelCustomerTaxPayInfoSubDto) {
        prpModelCustomerTaxPayInfoSubService.modify(prpModelCustomerTaxPayInfoSubDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpModelCustomerTaxPayInfoSubDto queryByPK(@RequestBody String modelCode) {
        return prpModelCustomerTaxPayInfoSubService.queryByPK(modelCode);
    }
}
