package com.sinosoft.pms.api.productrule;

import com.sinosoft.pms.PMSConstant;
import com.sinosoft.pms.api.productrule.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by gaofeng on 2017/7/28.
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = ProductApi.PATH)
public interface ProductApi {
    public static final String PATH = "product";

    @RequestMapping(value = "/getPremiumFactorList", method = RequestMethod.POST)
    @ResponseBody
    List<UtiFactorDto> getPremiumFactorList(UtiFactorConditionDto input) throws Exception;

    @RequestMapping(value = "/getPremiumDecisionList", method = RequestMethod.POST)
    @ResponseBody
    List<UtiDecisionDto> getPremiumDecisionList(UtiDecisionConditionDto input) throws Exception;

    @RequestMapping(value = "/getPremiumFormula", method = RequestMethod.POST)
    @ResponseBody
    UtiFormulaDto getPremiumFormula(UtiFormulaConditionDto input) throws Exception;
}
