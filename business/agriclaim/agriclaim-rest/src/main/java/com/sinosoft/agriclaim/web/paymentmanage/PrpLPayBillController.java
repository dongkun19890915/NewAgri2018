package com.sinosoft.agriclaim.web.paymentmanage;

import com.sinosoft.agriclaim.api.paymentmanage.PrpLPayBillApi;
import com.sinosoft.agriclaim.core.paymentmanage.service.PrpLPayBillService;
import com.sinosoft.agriclaim.api.paymentmanage.dto.PrpLPayBillDto;
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
 * @time  2017-12-14 09:04:11.816 
 * @description 支付信息对应清单主键表controller层
 */
@RestController
@RequestMapping(value = PrpLPayBillController.PATH)
public class PrpLPayBillController implements PrpLPayBillApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLPayBillController.class);

    @Autowired
    private PrpLPayBillService prpLPayBillService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLPayBillDto prpLPayBillDto) {
        prpLPayBillService.save(prpLPayBillDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String paymentNo,String registNo,String compensateNo,Integer serialNo) {
        prpLPayBillService.remove(paymentNo,registNo,compensateNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLPayBillDto prpLPayBillDto) {
        prpLPayBillService.modify(prpLPayBillDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLPayBillDto queryByPK(@RequestBody String paymentNo,String registNo,String compensateNo,Integer serialNo) {
        return prpLPayBillService.queryByPK(paymentNo,registNo,compensateNo,serialNo);
    }
}
