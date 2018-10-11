package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.PlantingEndorHeadApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingEndorHeadDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.PlantingEndorHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PlantingEndorHeadApi.PATH)
public class PlantingEndorHeadController implements PlantingEndorHeadApi{

    @Autowired
    private PlantingEndorHeadService plantingEndorHeadService;

    public void removePlantingEndorHead(@RequestParam("endorseNo") String endorseNo)throws Exception{
        plantingEndorHeadService.removePlantingEndorHead(endorseNo);
    }

    @Override
    public void savePlantingEndorHead(@RequestBody PlantingEndorHeadDto plantingEndorHeadDto)throws Exception{
        plantingEndorHeadService.savePlantingEndorHead(plantingEndorHeadDto);
    }

    public @ResponseBody PlantingEndorHeadDto queryByPK(@RequestParam("endorseNo") String endorseNo)throws Exception{
        return plantingEndorHeadService.queryByPK(endorseNo);
    }
}
