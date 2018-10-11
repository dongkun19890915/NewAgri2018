package com.sinosoft.dms.web.model;

import com.sinosoft.dms.api.model.PrpModelEngageSubApi;
import com.sinosoft.dms.api.model.dto.PrpModelEngageSubDto;
import com.sinosoft.dms.core.model.service.PrpModelEngageSubService;
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
 * @description 模板特别约定表controller层
 */
@RestController
@RequestMapping(value = PrpModelEngageSubController.PATH)
public class PrpModelEngageSubController implements PrpModelEngageSubApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpModelEngageSubController.class);

    @Autowired
    private PrpModelEngageSubService prpModelEngageSubService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpModelEngageSubDto prpModelEngageSubDto) {
        prpModelEngageSubService.save(prpModelEngageSubDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestBody Map<String,Object> map) {
        prpModelEngageSubService.remove((String) map.get("modelCode"),(Integer) map.get("serialNo"),(Integer) map.get("lineNo"));
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpModelEngageSubDto prpModelEngageSubDto) {
        prpModelEngageSubService.modify(prpModelEngageSubDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpModelEngageSubDto queryByPK(@RequestBody Map<String,Object> map) {
        return prpModelEngageSubService.queryByPK((String) map.get("modelCode"),(Integer) map.get("serialNo"),(Integer) map.get("lineNo"));
    }
}
