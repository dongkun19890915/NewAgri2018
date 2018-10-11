package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingEndorHeadDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name= TxnListConstant.TXN_LIST_SERVICE_NAME,path = PlantingEndorHeadApi.PATH)
public interface PlantingEndorHeadApi {
    public static final String PATH="plantingEndorHead";

    @RequestMapping(value = "removePlantingEndorHead",method = {RequestMethod.POST})
    public void removePlantingEndorHead(@RequestParam("endorseNo") String endorseNo)throws Exception;

    @RequestMapping(value = "savePlantingEndorHead",method = {RequestMethod.POST})
    public void savePlantingEndorHead(@RequestBody PlantingEndorHeadDto plantingEndorHeadDto)throws Exception;

    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    public @ResponseBody PlantingEndorHeadDto queryByPK(@RequestParam("endorseNo") String endorseNo)throws Exception;
}
