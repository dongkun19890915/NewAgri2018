package com.sinosoft.agriclaim.web.paymentmanage;

import com.sinosoft.agriclaim.api.paymentmanage.PrpLPayMainApi;
import com.sinosoft.agriclaim.core.paymentmanage.service.PrpLPayMainService;
import com.sinosoft.agriclaim.api.paymentmanage.dto.PrpLPayMainDto;
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
 * @description 支付信息主表controller层
 */
@RestController
@RequestMapping(value = PrpLPayMainController.PATH)
public class PrpLPayMainController implements PrpLPayMainApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLPayMainController.class);

    @Autowired
    private PrpLPayMainService prpLPayMainService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLPayMainDto prpLPayMainDto) {
        prpLPayMainService.save(prpLPayMainDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String paymentNo) {
        prpLPayMainService.remove(paymentNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLPayMainDto prpLPayMainDto) {
        prpLPayMainService.modify(prpLPayMainDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLPayMainDto queryByPK(@RequestBody String paymentNo) {
        return prpLPayMainService.queryByPK(paymentNo);
    }
}
