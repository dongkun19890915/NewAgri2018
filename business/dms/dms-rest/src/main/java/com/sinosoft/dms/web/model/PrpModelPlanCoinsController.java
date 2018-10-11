package com.sinosoft.dms.web.model;

import com.sinosoft.dms.api.model.PrpModelPlanCoinsApi;
import com.sinosoft.dms.api.model.dto.PrpModelPlanCoinsDto;
import com.sinosoft.dms.core.model.service.PrpModelPlanCoinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = PrpModelPlanCoinsApi.PATH)
public class PrpModelPlanCoinsController implements PrpModelPlanCoinsApi{

    @Autowired
    private PrpModelPlanCoinsService prpModelPlanCoinsService;

    @Override
    public void save(@RequestBody PrpModelPlanCoinsDto prpModelPlanCoinsDto) {
        prpModelPlanCoinsService.save(prpModelPlanCoinsDto);
    }

    @Override
    public void remove(@RequestBody Map<String, Object> map) {
        prpModelPlanCoinsService.remove((String)map.get("modelCode"),(Integer)map.get("serialNo"),(String) map.get("coinsCode"),(String) map.get("payReason"));
    }

    @Override
    public void modify(@RequestBody PrpModelPlanCoinsDto prpModelPlanCoinsDto) {
        prpModelPlanCoinsService.modify(prpModelPlanCoinsDto);
    }

    @Override
    public PrpModelPlanCoinsDto queryByPK(@RequestBody Map<String, Object> map)
    {
        return prpModelPlanCoinsService.queryByPK((String)map.get("modelCode"),(Integer)map.get("serialNo"),(String) map.get("coinsCode"),(String) map.get("payReason")) ;
    }
}
