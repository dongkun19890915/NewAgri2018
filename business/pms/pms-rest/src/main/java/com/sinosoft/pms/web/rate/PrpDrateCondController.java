package com.sinosoft.pms.web.rate;

import com.sinosoft.pms.api.rate.PrpDrateCondApi;
import com.sinosoft.pms.api.rate.dto.PrpDrateCondDto;
import com.sinosoft.pms.core.rate.service.PrpDrateCondService;
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
 * @description 费率条件表controller层
 */
@RestController
@RequestMapping(value = PrpDrateCondApi.PATH)
public class PrpDrateCondController implements PrpDrateCondApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDrateCondController.class);

    @Resource
    private PrpDrateCondService prpDrateCondService;

    @Override
    public List<PrpDrateCondDto> queryList(@RequestBody PrpDrateCondDto rateCondCondition) {
        return prpDrateCondService.queryList(rateCondCondition);
    }
}
