package com.sinosoft.agriclaim.web.paymentmanage;

import com.sinosoft.agriclaim.api.paymentmanage.PrpLClaimBillManagerApi;
import com.sinosoft.agriclaim.core.paymentmanage.service.PrpLClaimBillManagerService;
import com.sinosoft.agriclaim.api.paymentmanage.dto.PrpLClaimBillManagerDto;
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
 * @time  2018-01-11 08:55:21.509 
 * @description 理赔清单数据管理表controller层
 */
@RestController
@RequestMapping(value = PrpLClaimBillManagerController.PATH)
public class PrpLClaimBillManagerController implements PrpLClaimBillManagerApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLClaimBillManagerController.class);

    @Autowired
    private PrpLClaimBillManagerService prpLClaimBillManagerService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLClaimBillManagerDto prpLClaimBillManagerDto) {
        prpLClaimBillManagerService.save(prpLClaimBillManagerDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String registNo,String compensateNo,Integer serialNo) {
        prpLClaimBillManagerService.remove(registNo,compensateNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLClaimBillManagerDto prpLClaimBillManagerDto) {
        prpLClaimBillManagerService.modify(prpLClaimBillManagerDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLClaimBillManagerDto queryByPK(@RequestBody String registNo,String compensateNo,Integer serialNo) {
        return prpLClaimBillManagerService.queryByPK(registNo,compensateNo,serialNo);
    }
}
