package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingCpEndorChgDetailDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = PlantingCpEndorChgDetailApi.PATH)
public interface PlantingCpEndorChgDetailApi {
    public static final String PATH = "plantingCpEndorChgDetail";

    @RequestMapping(value = "removePlantingCpEndorChgDetail",method = {RequestMethod.POST})
    public void removePlantingCpEndorChgDetail(@RequestParam("inusreListCode") String inusreListCode)throws  Exception;

    @RequestMapping(value = "savePlantingCpEndorChgDetail",method = {RequestMethod.POST})
    public void savePlantingCpEndorChgDetail(@RequestBody List<PlantingCpEndorChgDetailDto> plantingCpEndorChgDetailDtoList)throws  Exception;
    @RequestMapping(value = "query",method = {RequestMethod.POST})
    public @ResponseBody List<PlantingCpEndorChgDetailDto> query(@RequestParam(value = "inusreListCode") String inusreListCode)throws Exception;
    @RequestMapping(value = "queryByInsureListCode",method = {RequestMethod.POST})
    public @ResponseBody List<PlantingCpEndorChgDetailDto> queryByInsureListCode(@RequestBody Map<String,String> map)throws Exception;

}
