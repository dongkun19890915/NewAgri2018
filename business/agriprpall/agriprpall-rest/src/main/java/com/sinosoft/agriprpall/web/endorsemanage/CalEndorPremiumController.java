package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.CalEndorPremiumApi;
import com.sinosoft.agriprpall.api.endorsemanage.CheckEndoreseNextApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.CalEndorPremiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = CalEndorPremiumApi.PATH)
public class CalEndorPremiumController implements CalEndorPremiumApi{
    @Autowired
    private CalEndorPremiumService calEndorPremiumService;

    @Override
    public @ResponseBody PolicyEndorseDto calFee(@RequestBody PolicyEndorseDto policyEndorseDto) throws Exception {
        return calEndorPremiumService.calPrpCfee(policyEndorseDto);
    }
}
