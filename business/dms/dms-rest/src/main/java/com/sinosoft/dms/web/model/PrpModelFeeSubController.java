package com.sinosoft.dms.web.model;

import com.sinosoft.dms.api.model.PrpModelFeeSubApi;
import com.sinosoft.dms.api.model.dto.PrpModelFeeSubDto;
import com.sinosoft.dms.core.model.service.PrpModelFeeSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = PrpModelFeeSubApi.PATH)
public class PrpModelFeeSubController implements PrpModelFeeSubApi{
    @Autowired
    private PrpModelFeeSubService prpModelFeeSubService;

    @Override
    public void save(@RequestBody PrpModelFeeSubDto prpModelFeeSubDto) throws Exception {
        prpModelFeeSubService.save(prpModelFeeSubDto);
    }

    @Override
    public void remove(@RequestBody Map<String, String> map) throws Exception {
        prpModelFeeSubService.remove(map.get("modelCode"),map.get("currency"));
    }

    @Override
    public void modify(@RequestBody PrpModelFeeSubDto prpModelFeeSubDto) throws Exception {
        prpModelFeeSubService.modify(prpModelFeeSubDto);
    }

    @Override
    public PrpModelFeeSubDto queryByPK(@RequestBody Map<String, String> map) throws Exception {
        return prpModelFeeSubService.queryByPK(map.get("modelCode"),map.get("currency"));
    }
}
