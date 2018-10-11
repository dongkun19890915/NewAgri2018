package com.sinosoft.pms.api.rate;

import com.sinosoft.pms.api.PMSConstant;
import com.sinosoft.pms.api.rate.dto.PrpDriskKindTaxAgriDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = PMSConstant.PMS_SERVICE_NAME,path = PrpDriskKindTaxAgriApi.PATH)
public interface PrpDriskKindTaxAgriApi {
    public static final String PATH="prpdriskkindtaxagri";

    @RequestMapping(value = "queryByPk",method = RequestMethod.POST)
    public PrpDriskKindTaxAgriDto queryByPk(@RequestBody Map<String, Integer> map) throws Exception;

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public void save(@RequestBody PrpDriskKindTaxAgriDto prpDriskKindTaxAgriDto)throws Exception;

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public void delete(@RequestBody Map<String, Integer> map)throws Exception;

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void update(@RequestBody PrpDriskKindTaxAgriDto prpDriskKindTaxAgriDto)throws Exception;

    /**
     *  递归方法，根据机构代码向上获取税率信息
     * @author: 田健
     * @date: 2017/12/25 10:16
     * @param prpDriskKindTaxDto Comcode  归属机构;Riskcode  险种; Kindcode  险别; TaxType  税率类型 1、保费税率；2、退保手续费税率；3、共保出单费税率；4、投资金退保手续费；9、手续费税率 如果传""则默认为1、保费税率;validDate 当前日期
     * @return  险种险别增值税基础税率配置表信息
     * @throws Exception
     */
    @RequestMapping(value = "findTaxRateByLowerComcodeToUpper",method = {RequestMethod.POST})
    PrpDriskKindTaxAgriDto findTaxRateByLowerComcodeToUpper(PrpDriskKindTaxAgriDto prpDriskKindTaxAgriDto) throws Exception;
}
