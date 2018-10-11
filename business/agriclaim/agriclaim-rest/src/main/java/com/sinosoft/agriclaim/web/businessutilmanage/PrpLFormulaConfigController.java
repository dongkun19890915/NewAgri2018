package com.sinosoft.agriclaim.web.businessutilmanage;

import com.sinosoft.agriclaim.api.businessutilmanage.PrpLFormulaConfigApi;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLFormulaConfigDto;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLFormulaConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = PrpLFormulaConfigController.PATH)
public class PrpLFormulaConfigController implements PrpLFormulaConfigApi {
    private static Logger LOGGER = LoggerFactory.getLogger(PrpLextController.class);
    @Autowired
    private PrpLFormulaConfigService prpLFormulaConfigService;
    /**
     * @description 按条件查询条款公式配置
     * @param prpLFormulaConfigDto 条款公式配置入参封装对象
     * @return List<prpLFormulaConfigDto> 条款公式配置信息列表
     * @throws Exception
     * @author 李磊
     * @date 2017-12-26 8:42
     */
    @Override
    public @ResponseBody List<PrpLFormulaConfigDto> queryPrpLFormulaConfigDtoListByCondition(@RequestBody PrpLFormulaConfigDto prpLFormulaConfigDto) throws Exception {
        return prpLFormulaConfigService.queryPrpLFormulaConfigDtoListByCondition(prpLFormulaConfigDto);
    }
}
