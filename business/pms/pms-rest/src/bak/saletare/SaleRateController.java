package com.sinosoft.pms.web.saletare;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.pms.api.salerate.SaleRateApi;
import com.sinosoft.pms.api.salerate.dto.PrpdSalesRateDto;
import com.sinosoft.pms.api.salerate.dto.SaleRateQueryConditionDto;
import com.sinosoft.pms.api.salerate.dto.SaleRateReturnDto;
import com.sinosoft.pms.core.salerate.service.SaleRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




/**
 * @description 销售费率控制器
 * @author yinqinzhu
 * @date 2016年10月22日下午5:28:05
 */
@RestController
@RequestMapping("/saleRate")
public class SaleRateController implements  SaleRateApi{
    @Autowired
    private SaleRateService saleRateService;

    /**
     * @description 查询销售费率
     * @param conditionDto
     * @return
     * @throws Exception
     * @author yinqinzhu
     * @date 2016年10月22日下午5:28:31
     */
    public ResponseDto getSaleRate(@RequestBody SaleRateQueryConditionDto conditionDto)
            throws Exception
    {
        PrpdSalesRateDto prpdSalesRateDto = saleRateService.getSaleRate(conditionDto);
        return ResponseDto.instance(prpdSalesRateDto);
    }


    /**
     * @description  查询销售费率列表
     * @param conditionDto
     * @return
     * @throws Exception
     * @author yinqinzhu
     * @date 2016年10月22日下午5:28:44
     */
    public ResponseDto quereyPrpdSalesRateList(@RequestBody SaleRateQueryConditionDto conditionDto)
            throws Exception
    {
        PageInfo<PrpdSalesRateDto> page = saleRateService.quereyPrpdSalesRateList(conditionDto);
        return ResponseDto.instance(page);
    }


    /**
     * @description 保存销售费率
     * @param saleRatesDto
     * @return
     * @throws Exception
     * @author yinqinzhu
     * @date 2016年10月22日下午5:28:57
     */
    @RequestMapping(value = "saveSalesRate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto savePrpdSalesRate(@RequestBody PrpdSalesRateDto saleRatesDto)
            throws Exception
    {
        SaleRateReturnDto saleRateReturnDto = saleRateService.savePrpdSalesRate(saleRatesDto);
        return ResponseDto.instance(saleRateReturnDto);
    }
}

