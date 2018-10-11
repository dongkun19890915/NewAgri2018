package com.sinosoft.dms.web.model;

import com.sinosoft.dms.api.model.PrpModelInsuredSubApi;
import com.sinosoft.dms.api.model.dto.PrpModelInsuredSubDto;
import com.sinosoft.dms.core.model.service.PrpModelInsuredSubService;
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
 * @description 模板保险关系人表controller层
 */
@RestController
@RequestMapping(value = PrpModelInsuredSubController.PATH)
public class PrpModelInsuredSubController implements PrpModelInsuredSubApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpModelInsuredSubController.class);

    @Autowired
    private PrpModelInsuredSubService prpModelInsuredSubService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpModelInsuredSubDto prpModelInsuredSubDto) {
        prpModelInsuredSubService.save(prpModelInsuredSubDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestBody Map<String,Object> map) {
        prpModelInsuredSubService.remove((String) map.get("modelCode"),(Integer) map.get("serialNo"));
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpModelInsuredSubDto prpModelInsuredSubDto) {
        prpModelInsuredSubService.modify(prpModelInsuredSubDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpModelInsuredSubDto queryByPK(@RequestBody Map<String,Object> map) {
        return prpModelInsuredSubService.queryByPK((String)map.get("modelCode"),(Integer)map.get("serialNo"));
    }
}
