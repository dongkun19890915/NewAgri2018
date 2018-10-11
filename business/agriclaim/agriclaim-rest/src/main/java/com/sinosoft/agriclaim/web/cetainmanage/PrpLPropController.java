package com.sinosoft.agriclaim.web.cetainmanage;

import com.sinosoft.agriclaim.api.cetainmanage.PrpLPropApi;
import com.sinosoft.agriclaim.core.cetainmanage.service.PrpLPropService;
import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLPropDto;
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
 * @time  2017-11-08 05:36:28.690 
 * @description 财产核定损明细清单表controller层
 */
@RestController
@RequestMapping(value = PrpLPropController.PATH)
public class PrpLPropController implements PrpLPropApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLPropController.class);

    @Autowired
    private PrpLPropService prpLPropService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLPropDto prpLPropDto) {
        prpLPropService.save(prpLPropDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody java.lang.Integer serialNo,String registNo,String lossItemCode) {
        prpLPropService.remove(serialNo,registNo,lossItemCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLPropDto prpLPropDto) {
        prpLPropService.modify(prpLPropDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLPropDto queryByPK(@RequestBody java.lang.Integer serialNo,String registNo,String lossItemCode) {
        return prpLPropService.queryByPK(serialNo,registNo,lossItemCode);
    }
}
