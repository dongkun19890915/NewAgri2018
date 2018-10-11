package com.sinosoft.agriclaim.api.businessutilmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLFormulaConfigDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLFormulaConfigApi.PATH)
public interface PrpLFormulaConfigApi  {
    public static final String PATH = "prpLFormulaConfig";
    /**
     * @description 按条件查询条款公式配置
     * @param prpLFormulaConfigDto 条款公式配置入参封装对象
     * @return List<prpLFormulaConfigDto> 条款公式配置信息列表
     * @throws Exception
     * @author 李磊
     * @date 2017-12-26 8:42
     */
    @RequestMapping(value = "queryPrpLFormulaConfigDtoListByCondition",method = {RequestMethod.POST})
    @ResponseBody
    public List<PrpLFormulaConfigDto> queryPrpLFormulaConfigDtoListByCondition(@RequestBody PrpLFormulaConfigDto  prpLFormulaConfigDto) throws Exception ;
}
