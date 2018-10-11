package com.sinosoft.pms.web.rate;

import com.sinosoft.pms.api.rate.PrpDriskKindTaxApi;
import com.sinosoft.pms.core.rate.service.PrpDriskKindTaxService;
import com.sinosoft.pms.api.rate.dto.PrpDriskKindTaxDto;
import com.sinosoft.framework.dto.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-29 07:14:25.063 
 * @description 险种险别增值税基础税率配置表controller层
 */
@RestController
@RequestMapping(value = PrpDriskKindTaxController.PATH)
public class PrpDriskKindTaxController implements PrpDriskKindTaxApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDriskKindTaxController.class);

    @Resource
    private PrpDriskKindTaxService prpDriskKindTaxService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDriskKindTaxDto prpDriskKindTaxDto) {
        prpDriskKindTaxService.save(prpDriskKindTaxDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody java.lang.Integer uuid) {
        prpDriskKindTaxService.remove(uuid);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDriskKindTaxDto prpDriskKindTaxDto) {
        prpDriskKindTaxService.modify(prpDriskKindTaxDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDriskKindTaxDto queryByPK(@RequestBody java.lang.Integer uuid) {
        return prpDriskKindTaxService.queryByPK(uuid);
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
    public PrpDriskKindTaxDto findTaxRateByLowerComcodeToUpper(@RequestBody PrpDriskKindTaxDto prpDriskKindTaxDto) throws Exception {
        return prpDriskKindTaxService.findTaxRateByLowerComcodeToUpper(prpDriskKindTaxDto);
    }
}
