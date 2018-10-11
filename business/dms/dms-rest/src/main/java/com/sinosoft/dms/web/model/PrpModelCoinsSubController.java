package com.sinosoft.dms.web.model;

import com.sinosoft.dms.api.model.PrpModelCoinsSubApi;
import com.sinosoft.dms.core.model.service.PrpModelCoinsSubService;
import com.sinosoft.dms.api.model.dto.PrpModelCoinsSubDto;
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
 * @description 模板共保信息表controller层
 */
@RestController
@RequestMapping(value = PrpModelCoinsSubController.PATH)
public class PrpModelCoinsSubController implements PrpModelCoinsSubApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpModelCoinsSubController.class);

    @Autowired
    private PrpModelCoinsSubService prpModelCoinsSubService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpModelCoinsSubDto prpModelCoinsSubDto) {
        prpModelCoinsSubService.save(prpModelCoinsSubDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestBody String modelCode) {
        prpModelCoinsSubService.remove(modelCode);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpModelCoinsSubDto prpModelCoinsSubDto) {
        prpModelCoinsSubService.modify(prpModelCoinsSubDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpModelCoinsSubDto queryByPK(@RequestBody String modelCode) {
        return prpModelCoinsSubService.queryByPK(modelCode);
    }
}
