package com.sinosoft.agriclaim.web.prepaymanage;

import com.sinosoft.agriclaim.api.prepaymanage.PrpLPrepayApi;
import com.sinosoft.agriclaim.core.prepaymanage.service.PrpLPrepayService;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto;
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
 * @time  2017-11-08 05:44:02.119 
 * @description 预支付理赔表controller层
 */
@RestController
@RequestMapping(value = PrpLPrepayController.PATH)
public class PrpLPrepayController implements PrpLPrepayApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLPrepayController.class);

    @Autowired
    private PrpLPrepayService prpLPrepayService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLPrepayDto prpLPrepayDto) {
        prpLPrepayService.save(prpLPrepayDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String preCompensateNo) {
        prpLPrepayService.remove(preCompensateNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLPrepayDto prpLPrepayDto) {
        prpLPrepayService.modify(prpLPrepayDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLPrepayDto queryByPK(@RequestBody String preCompensateNo) {
        return prpLPrepayService.queryByPK(preCompensateNo);
    }
}
