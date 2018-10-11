package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.GeneratePrpMainApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GeneratePrpMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = GeneratePrpMainController.PATH)
public class GeneratePrpMainController implements GeneratePrpMainApi {
    @Autowired
    private GeneratePrpMainService generatePrpMainService;
    /**
    * 处理prpmain
    * @param policyEndorseDto 保单批单大对象
    * @return void
    * @throws
    * @author 李冬松
    * @date 14:19 2017/12/13
    */
    @Override
    public void dealPrpMain(PolicyEndorseDto policyEndorseDto) throws Exception {
        generatePrpMainService.updatePrpCmainNew(policyEndorseDto);
    }
    /**
    * 更新prppmain
    * @param policyEndorseDto 保单批单大对象
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 14:24 2017/12/13
    */
    @Override
    public void updatePrpPmainDto(PolicyEndorseDto policyEndorseDto) throws Exception {
        generatePrpMainService.updatePrpPmainDto(policyEndorseDto);
    }
}
