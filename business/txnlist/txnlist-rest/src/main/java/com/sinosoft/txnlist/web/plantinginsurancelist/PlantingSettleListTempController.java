package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.PlantingSettleListTempApi;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.PlantingSettleListTempService;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingSettleListTempDto;
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
 * @time  2017-11-18 08:36:26.740 
 * @description plantingsettlelisttempcontroller层
 */
@RestController
@RequestMapping(value = PlantingSettleListTempController.PATH)
public class PlantingSettleListTempController implements PlantingSettleListTempApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PlantingSettleListTempController.class);

    @Autowired
    private PlantingSettleListTempService plantingSettleListTempService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PlantingSettleListTempDto plantingSettleListTempDto) {
        plantingSettleListTempService.save(plantingSettleListTempDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String registCode,String stringTimeStamp,java.lang.Integer indexOfSettle) {
        plantingSettleListTempService.remove(registCode,stringTimeStamp,indexOfSettle);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PlantingSettleListTempDto plantingSettleListTempDto) {
        plantingSettleListTempService.modify(plantingSettleListTempDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PlantingSettleListTempDto queryByPK(@RequestBody String registCode,String stringTimeStamp,java.lang.Integer indexOfSettle) {
        return plantingSettleListTempService.queryByPK(registCode,stringTimeStamp,indexOfSettle);
    }
}
