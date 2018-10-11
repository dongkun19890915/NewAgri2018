package com.sinosoft.agriclaim.web.paymentmanage;

import com.sinosoft.agriclaim.api.paymentmanage.PrpLPayExtApi;
import com.sinosoft.agriclaim.core.paymentmanage.service.PrpLPayExtService;
import com.sinosoft.agriclaim.api.paymentmanage.dto.PrpLPayExtDto;
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
 * @description 支付处理意见表controller层
 */
@RestController
@RequestMapping(value = PrpLPayExtController.PATH)
public class PrpLPayExtController implements PrpLPayExtApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLPayExtController.class);

    @Autowired
    private PrpLPayExtService prpLPayExtService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLPayExtDto prpLPayExtDto) {
        prpLPayExtService.save(prpLPayExtDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String paymentNo,Integer serialNo) {
        prpLPayExtService.remove(paymentNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLPayExtDto prpLPayExtDto) {
        prpLPayExtService.modify(prpLPayExtDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLPayExtDto queryByPK(@RequestBody String paymentNo,Integer serialNo) {
        return prpLPayExtService.queryByPK(paymentNo,serialNo);
    }
}
