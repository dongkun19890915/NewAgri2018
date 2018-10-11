package com.sinosoft.dms.web.model;

import com.sinosoft.dms.api.model.PrpModelMainSubApi;
import com.sinosoft.dms.api.model.dto.PrpModelMainSubDto;
import com.sinosoft.dms.core.model.service.PrpModelMainSubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * @description 保单基本信息表controller层
 */
@RestController
@RequestMapping(value = PrpModelMainSubController.PATH)
public class PrpModelMainSubController implements PrpModelMainSubApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpModelMainSubController.class);

    @Autowired
    private PrpModelMainSubService prpModelMainSubService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpModelMainSubDto prpModelMainSubDto) {
        prpModelMainSubService.save(prpModelMainSubDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestBody Map<String,String> map) {
        prpModelMainSubService.remove(map.get("modelCode"));
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpModelMainSubDto prpModelMainSubDto) {
        prpModelMainSubService.modify(prpModelMainSubDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpModelMainSubDto queryByPK(@RequestBody Map<String,String> map) {
        return prpModelMainSubService.queryByPK(map.get("modelCode"));
    }
}
