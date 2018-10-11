package com.sinosoft.pms.web.kernel;

import com.sinosoft.pms.api.kernel.PrpDvoucherConfigApi;
import com.sinosoft.pms.api.kernel.dto.PrpDvoucherConfigDto;
import com.sinosoft.pms.core.kernel.service.PrpDvoucherConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = PrpDvoucherConfigApi.PATH)
public class PrpDvoucherConfigController implements PrpDvoucherConfigApi {
    @Autowired
    private PrpDvoucherConfigService prpDvoucherConfigService;

    @Override
    public PrpDvoucherConfigDto queryByPk(Map<String, String> map) throws Exception {
        return prpDvoucherConfigService.queryByPk(map.get("comCode"),map.get("riskCode"));
    }

    @Override
    public void save(PrpDvoucherConfigDto prpDvoucherConfigDto) throws Exception {
        prpDvoucherConfigService.save(prpDvoucherConfigDto);
    }

    @Override
    public void update(PrpDvoucherConfigDto prpDvoucherConfigDto) throws Exception {
        prpDvoucherConfigService.update(prpDvoucherConfigDto);
    }

    @Override
    public void delete(Map<String, String> map) throws Exception {
        prpDvoucherConfigService.delete(map.get("comCode"),map.get("riskCode"));
    }
}
