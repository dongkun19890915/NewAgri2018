package com.sinosoft.dms.web.model;

import com.sinosoft.dms.api.model.PrpModelPlanSubApi;
import com.sinosoft.dms.api.model.dto.PrpModelPlanSubDto;
import com.sinosoft.dms.core.model.service.PrpModelPlanSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = PrpModelPlanSubApi.PATH)
public class PrpModelPlanSubController implements PrpModelPlanSubApi{

    @Autowired
    private PrpModelPlanSubService prpModelPlanSubService;

    @Override
    public void save(@RequestBody PrpModelPlanSubDto prpModelPlanSubDto) {
        prpModelPlanSubService.save(prpModelPlanSubDto);
    }

    @Override
    public void remove(@RequestBody Map<String, Object> map) {
        prpModelPlanSubService.remove((String) map.get("modelCode"),(Integer)map.get("serialNo"));
    }

    @Override
    public void modify(@RequestBody PrpModelPlanSubDto prpModelPlanSubDto) {
        prpModelPlanSubService.modify(prpModelPlanSubDto);
    }

    @Override
    public PrpModelPlanSubDto queryByPK(@RequestBody Map<String, Object> map) {
        return prpModelPlanSubService.queryByPK((String) map.get("modelCode"),(Integer)map.get("serialNo"));
    }
}
