package com.sinosoft.pms.web.rate;

import com.sinosoft.pms.api.rate.PrpDrateUsualApi;
import com.sinosoft.pms.api.rate.dto.PrpDrateUsualDto;
import com.sinosoft.pms.core.rate.service.PrpDrateUsualService;
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
 * @description 费率代码表controller层
 */
@RestController
@RequestMapping(value = PrpDrateUsualApi.PATH)
public class PrpDrateUsualController implements PrpDrateUsualApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDrateUsualController.class);

    @Resource
    private PrpDrateUsualService prpDrateUsualService;

    @Override
    public List<PrpDrateUsualDto> queryList(@RequestBody PrpDrateUsualDto prpDrateUsualDto) {
        return prpDrateUsualService.queryList(prpDrateUsualDto);
    }
}
