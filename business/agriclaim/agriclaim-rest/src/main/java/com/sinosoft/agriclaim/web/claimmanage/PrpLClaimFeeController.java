package com.sinosoft.agriclaim.web.claimmanage;

import com.sinosoft.agriclaim.api.claimmanage.PrpLClaimFeeApi;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLClaimFeeService;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimFeeDto;
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
 * @time  2017-11-08 05:39:53.061 
 * @description 估损金额表controller层
 */
@RestController
@RequestMapping(value = PrpLClaimFeeController.PATH)
public class PrpLClaimFeeController implements PrpLClaimFeeApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLClaimFeeController.class);

    @Autowired
    private PrpLClaimFeeService prpLClaimFeeService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLClaimFeeDto prpLClaimFeeDto) {
        prpLClaimFeeService.save(prpLClaimFeeDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String claimNo,String currency) {
        prpLClaimFeeService.remove(claimNo,currency);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLClaimFeeDto prpLClaimFeeDto) {
        prpLClaimFeeService.modify(prpLClaimFeeDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLClaimFeeDto queryByPK(@RequestBody String claimNo,String currency) {
        return prpLClaimFeeService.queryByPK(claimNo,currency);
    }
}
