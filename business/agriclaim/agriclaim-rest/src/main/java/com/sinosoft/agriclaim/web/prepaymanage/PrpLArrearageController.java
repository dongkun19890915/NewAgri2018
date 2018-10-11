package com.sinosoft.agriclaim.web.prepaymanage;

import com.sinosoft.agriclaim.api.prepaymanage.PrpLArrearageApi;
import com.sinosoft.agriclaim.core.prepaymanage.service.PrpLArrearageService;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLArrearageDto;
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
 * @description 逾款欠款清单表controller层
 */
@RestController
@RequestMapping(value = PrpLArrearageController.PATH)
public class PrpLArrearageController implements PrpLArrearageApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLArrearageController.class);

    @Autowired
    private PrpLArrearageService prpLArrearageService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLArrearageDto prpLArrearageDto) {
        prpLArrearageService.save(prpLArrearageDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String policyNo,java.util.Date arrearageEndDate) {
        prpLArrearageService.remove(policyNo,arrearageEndDate);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLArrearageDto prpLArrearageDto) {
        prpLArrearageService.modify(prpLArrearageDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLArrearageDto queryByPK(@RequestBody String policyNo,java.util.Date arrearageEndDate) {
        return prpLArrearageService.queryByPK(policyNo,arrearageEndDate);
    }
}
