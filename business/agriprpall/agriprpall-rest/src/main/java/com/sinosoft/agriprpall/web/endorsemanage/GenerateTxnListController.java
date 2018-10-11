package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.GenerateTxnListApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GenerateTxnListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = GenerateTxnListApi.PATH)
public class GenerateTxnListController implements GenerateTxnListApi{
    private static Logger LOGGER = LoggerFactory.getLogger(GenerateTxnListController.class);
    @Autowired
    private GenerateTxnListService generateTxnListService;
    @Override
    /**
    *  处理清单表
    * @param policyEndorseDto 保单批单大对象
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 14:18 2017/12/13
    */
    public void dealTxnList(@RequestBody PolicyEndorseDto policyEndorseDto) throws Exception {
        generateTxnListService.dealTxnList(policyEndorseDto);
    }
}
