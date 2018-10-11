package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.PlantingSettleListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.ValidityAndPKDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.PlantingSettleListService;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingSettleListDto;
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
 * @description plantingsettlelistcontroller层
 */
@RestController
@RequestMapping(value = PlantingSettleListController.PATH)
public class PlantingSettleListController implements PlantingSettleListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PlantingSettleListController.class);

    @Autowired
    private PlantingSettleListService plantingSettleListService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PlantingSettleListDto plantingSettleListDto) {
        plantingSettleListService.save(plantingSettleListDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String settleListCode,String fCode,String kindCode,String classCode) {
        plantingSettleListService.remove(settleListCode,fCode,kindCode,classCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PlantingSettleListDto plantingSettleListDto) {
        plantingSettleListService.modify(plantingSettleListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PlantingSettleListDto queryByPK(@RequestBody String settleListCode,String fCode,String kindCode,String classCode) {
        return plantingSettleListService.queryByPK(settleListCode,fCode,kindCode,classCode);
    }
    /**
     * @author 马俊玲
     *@description 查询实体
     *@param
     */
    @Override
    public List<PlantingSettleListDto> queryBySettlelistCodeAndValidity(@RequestBody ValidityAndPKDto validityAndPKDto) {
        return plantingSettleListService.findBySettlelistCodeAndValidity(validityAndPKDto);

    }
}
