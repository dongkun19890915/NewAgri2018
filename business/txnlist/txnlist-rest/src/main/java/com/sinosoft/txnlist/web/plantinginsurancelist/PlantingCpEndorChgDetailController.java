package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.PlantingCpEndorChgDetailApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingCpEndorChgDetailDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.PlantingCpEndorChgDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(PlantingCpEndorChgDetailApi.PATH)
public class PlantingCpEndorChgDetailController implements PlantingCpEndorChgDetailApi{
    @Autowired
    private PlantingCpEndorChgDetailService plantingCpEndorChgDetailService;

    @Override
    public void removePlantingCpEndorChgDetail(@RequestParam("inusreListCode") String inusreListCode)throws  Exception{
        plantingCpEndorChgDetailService.removePlantingCpEndorChgDetail(inusreListCode);
    }

    @Override
    public void savePlantingCpEndorChgDetail(@RequestBody List<PlantingCpEndorChgDetailDto> plantingCpEndorChgDetailDtoList)throws  Exception{
        plantingCpEndorChgDetailService.savePlantingCpEndorChgDetail(plantingCpEndorChgDetailDtoList);
    }

    @Override
    public List<PlantingCpEndorChgDetailDto> query(String inusreListCode) throws Exception {
        return plantingCpEndorChgDetailService.query(inusreListCode);
    }

    @Override
    public @ResponseBody List<PlantingCpEndorChgDetailDto> queryByInsureListCode(@RequestBody Map<String, String> map) throws Exception {
        return plantingCpEndorChgDetailService.queryByInsureListCode(map.get("insureListCode"));
    }
}
