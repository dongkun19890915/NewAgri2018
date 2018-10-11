package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.GeneratePrpItemKindApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GeneratePrpItemKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = GeneratePrpItemKindApi.PATH)
public class GeneratePrpItemKindController implements GeneratePrpItemKindApi{
    @Autowired
    private GeneratePrpItemKindService generatePrpItemKindService;
    /**
    *  处理prpitemkind
    * @param policyEndorseDto 保单批单大对象
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 14:28 2017/12/13
    */
    @Override
    public void dealPrpItemKind(@RequestBody PolicyEndorseDto policyEndorseDto) throws Exception {
        generatePrpItemKindService.updatePrpCitemKindNew(policyEndorseDto);
    }
}
