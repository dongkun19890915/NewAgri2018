package com.sinosoft.pms.api.salerate;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.pms.PMSConstant;
import com.sinosoft.pms.api.salerate.dto.PrpdSalesRateDto;
import com.sinosoft.pms.api.salerate.dto.SaleRateQueryConditionDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = SaleRateApi.PATH)
public interface SaleRateApi {

    public static final String PATH = "saleRate";

    @RequestMapping(value = "getSaleRate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto getSaleRate(@RequestBody SaleRateQueryConditionDto conditionDto) throws Exception;

    @RequestMapping(value = "quereySalesRateList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto quereyPrpdSalesRateList(@RequestBody SaleRateQueryConditionDto conditionDto) throws Exception;

    @RequestMapping(value = "saveSalesRate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto savePrpdSalesRate(@RequestBody PrpdSalesRateDto saleRatesDto) throws Exception;

}
