package com.sinosoft.dms.web.model;

import com.sinosoft.dms.api.model.PrpModelAddressSubApi;
import com.sinosoft.dms.api.model.dto.PrpModelAddressSubDto;
import com.sinosoft.dms.core.model.service.PrpModelAddressSubService;
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
 * @description 模板保险地址表controller层
 */
@RestController
@RequestMapping(value = PrpModelAddressSubController.PATH)
public class PrpModelAddressSubController implements PrpModelAddressSubApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpModelAddressSubController.class);

    @Autowired
    private PrpModelAddressSubService prpModelAddressSubService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpModelAddressSubDto prpModelAddressSubDto) {
        prpModelAddressSubService.save(prpModelAddressSubDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestBody Map<String,Object> map) {
        prpModelAddressSubService.remove((String)map.get("modelCode"),(Integer) map.get("addressNo"));
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpModelAddressSubDto prpModelAddressSubDto) {
        prpModelAddressSubService.modify(prpModelAddressSubDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpModelAddressSubDto queryByPK(@RequestBody Map<String,Object> map) {
        return prpModelAddressSubService.queryByPK((String)map.get("modelCode"),(Integer) map.get("addressNo"));
    }
}
