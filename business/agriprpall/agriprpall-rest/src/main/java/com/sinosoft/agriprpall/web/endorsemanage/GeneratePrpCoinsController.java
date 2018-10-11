package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.GeneratePrpCoinsApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GeneratePrpCoinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = GeneratePrpCoinsApi.PATH)
public class GeneratePrpCoinsController implements GeneratePrpCoinsApi{
    @Autowired
    private GeneratePrpCoinsService generatePrpCoinsService;
    /**
    *  处理PrpCoins
    * @param policyEndorseDto 保单批单大对象
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 14:27 2017/12/13
    */
    @Override
    public void dealPrpCoins(@RequestBody PolicyEndorseDto policyEndorseDto) throws Exception {
        generatePrpCoinsService.updatePrpCcoinsNew(policyEndorseDto);
    }
}
