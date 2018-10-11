package com.sinosoft.agriclaim.web.businessutilmanage;

import com.sinosoft.agriclaim.api.businessutilmanage.PrpLConfigurationApi;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLConfigurationDto;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLConfigurationService;
import com.sinosoft.agriclaim.web.combinemanage.PrpLCombineController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = PrpLConfigurationController.PATH)
public class PrpLConfigurationController implements PrpLConfigurationApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLCombineController.class);

    @Autowired
    private PrpLConfigurationService prpLConfigurationService;

    @Override
    @ResponseBody
    public List<PrpLConfigurationDto> queryPrpLConfigurationDtoListByCondition(@RequestBody PrpLConfigurationDto prpLConfigurationDto) throws Exception {
        return prpLConfigurationService.queryPrpLConfigurationDtoListByCondition(prpLConfigurationDto);
    }
}
