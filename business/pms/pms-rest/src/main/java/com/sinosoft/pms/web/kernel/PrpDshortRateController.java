package com.sinosoft.pms.web.kernel;

import com.sinosoft.pms.api.kernel.PrpDshortRateApi;
import com.sinosoft.pms.api.kernel.dto.PrpDshortRateDto;
import com.sinosoft.pms.core.kernel.service.PrpDshortRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(PrpDshortRateApi.PATH)
public class PrpDshortRateController implements PrpDshortRateApi {

    @Autowired
    private PrpDshortRateService prpDshortRateService;

    @Override
    public void save(@RequestBody PrpDshortRateDto prpDshortRateDto) {
        prpDshortRateService.save(prpDshortRateDto);
    }

    @Override
    public void remove(@RequestBody Map<String,Object> map) {
        prpDshortRateService.remove((String) map.get("riskCode"),(Integer) map.get("months"));
    }

    @Override
    public void modify(@RequestBody PrpDshortRateDto prpDshortRateDto) {
        prpDshortRateService.modify(prpDshortRateDto);
    }

    @Override
    public PrpDshortRateDto queryByPK(@RequestBody Map<String,Object> map) {
        return prpDshortRateService.queryByPK((String) map.get("riskCode"),(Integer) map.get("months"));
    }

    @Override
    public @ResponseBody
    PrpDshortRateDto queryPrpDshortRateDto(@RequestParam("strRiskCode") String strRiskCode, @RequestParam("intMonth") Integer intMonth)throws Exception{
        return prpDshortRateService.queryPrpDshortRateDto(strRiskCode,intMonth);
    }

    /**
     * 根据险种和标的代码查询短期费率
     * @author: 刘曼曼
     * @date: 11:28 11:28
     * @param map riskCode itemCode 险种  标的
     * @return List<PrpDshortRateDto> 短期费率集合
     * @throws Exception
     */
    @ResponseBody
    public List<PrpDshortRateDto> queryByRiskCodeAndItemCode(@RequestBody Map<String,String> map)throws Exception{
        return prpDshortRateService.queryByRiskCodeAndItemCode(map.get("riskCode"),map.get("itemCode"));
    }
}
