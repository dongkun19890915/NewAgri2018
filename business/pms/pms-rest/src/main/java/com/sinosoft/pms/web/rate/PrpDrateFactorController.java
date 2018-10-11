package com.sinosoft.pms.web.rate;


import com.sinosoft.pms.api.rate.PrpDrateFactorApi;
import com.sinosoft.pms.api.rate.dto.PrpDrateFactorDto;
import com.sinosoft.pms.core.rate.service.PrpDrateFactorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-08-17 01:44:36.465
 * @description 费率因子表controller层
 */
@RestController
@RequestMapping(value = PrpDrateFactorApi.PATH)
public class PrpDrateFactorController implements PrpDrateFactorApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDrateFactorController.class);

    @Resource
    private PrpDrateFactorService prpDrateFactorService;


    @Override
    public List<PrpDrateFactorDto> queryList(@RequestBody PrpDrateFactorDto rateFactorCondition) {
        return prpDrateFactorService.queryList(rateFactorCondition);
    }
}
