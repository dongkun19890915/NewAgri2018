package com.sinosoft.pms.web.rate;

import com.sinosoft.pms.api.rate.PrpDrateGroupApi;
import com.sinosoft.pms.api.rate.dto.PrpDrateGroupDto;
import com.sinosoft.pms.core.rate.service.PrpDrateGroupService;
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
 * @description 费率分组表controller层
 */
@RestController
@RequestMapping(value = PrpDrateGroupApi.PATH)
public class PrpDrateGroupController implements PrpDrateGroupApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDrateGroupController.class);

    @Resource
    private PrpDrateGroupService prpDrateGroupService;

    @Override
    public List<PrpDrateGroupDto> queryList(@RequestBody PrpDrateGroupDto prpDrateGroupDto) {
        return prpDrateGroupService.queryList(prpDrateGroupDto);
    }
}
