package com.sinosoft.dms.web.model;

import com.sinosoft.dms.api.model.PrpModelMainAgriSubApi;
import com.sinosoft.dms.core.model.service.PrpModelMainAgriSubService;
import com.sinosoft.dms.api.model.dto.PrpModelMainAgriSubDto;
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
 * @description 模板农业险保单信息controller层
 */
@RestController
@RequestMapping(value = PrpModelMainAgriSubController.PATH)
public class PrpModelMainAgriSubController implements PrpModelMainAgriSubApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpModelMainAgriSubController.class);

    @Autowired
    private PrpModelMainAgriSubService prpModelMainAgriSubService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpModelMainAgriSubDto prpModelMainAgriSubDto) {
        prpModelMainAgriSubService.save(prpModelMainAgriSubDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestBody String modelCode) {
        prpModelMainAgriSubService.remove(modelCode);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpModelMainAgriSubDto prpModelMainAgriSubDto) {
        prpModelMainAgriSubService.modify(prpModelMainAgriSubDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpModelMainAgriSubDto queryByPK(@RequestBody String modelCode) {
        return prpModelMainAgriSubService.queryByPK(modelCode);
    }
}
