package com.sinosoft.pms.web.rate;

import com.sinosoft.pms.api.rate.PrpDriskKindTaxAgriApi;
import com.sinosoft.pms.api.rate.dto.PrpDriskKindTaxAgriDto;
import com.sinosoft.pms.core.rate.service.PrpDriskKindTaxAgriService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-29 07:14:25.063 
 * @description 险种险别增值税基础税率配置表controller层
 */
@RestController
@RequestMapping(value = PrpDriskKindTaxAgriController.PATH)
public class PrpDriskKindTaxAgriController implements PrpDriskKindTaxAgriApi {
    @Autowired
    private PrpDriskKindTaxAgriService prpDriskKindTaxAgriService;

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDriskKindTaxAgriController.class);


    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpDriskKindTaxAgriDto queryByPk(@RequestBody Map<String,Integer> map) throws Exception {
        return prpDriskKindTaxAgriService.queryByPK(map.get("uuid"));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(@RequestBody PrpDriskKindTaxAgriDto prpDriskKindTaxAgriDto) throws Exception {
        prpDriskKindTaxAgriService.save(prpDriskKindTaxAgriDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(@RequestBody Map<String, Integer> map) throws Exception {
        prpDriskKindTaxAgriService.remove(map.get("uuid"));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(@RequestBody PrpDriskKindTaxAgriDto prpDriskKindTaxAgriDto) throws Exception {
        prpDriskKindTaxAgriService.modify(prpDriskKindTaxAgriDto);
    }

    /**
     *  递归方法，根据机构代码向上获取税率信息
     * @author: 田健
     * @date: 2017/12/25 10:16
     * @param prpDriskKindTaxDto Comcode  归属机构;Riskcode  险种; Kindcode  险别; TaxType  税率类型 1、保费税率；2、退保手续费税率；3、共保出单费税率；4、投资金退保手续费；9、手续费税率 如果传""则默认为1、保费税率;validDate 当前日期
     * @return  险种险别增值税基础税率配置表信息
     * @throws Exception
     */
    @Override
    public PrpDriskKindTaxAgriDto findTaxRateByLowerComcodeToUpper(@RequestBody PrpDriskKindTaxAgriDto prpDriskKindTaxAgriDto) throws Exception {
        return prpDriskKindTaxAgriService.findTaxRateByLowerComcodeToUpper(prpDriskKindTaxAgriDto);
    }
}
