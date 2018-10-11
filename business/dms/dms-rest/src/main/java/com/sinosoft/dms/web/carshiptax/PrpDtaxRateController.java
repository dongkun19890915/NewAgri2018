package com.sinosoft.dms.web.carshiptax;

import com.sinosoft.dms.api.carshiptax.PrpDtaxRateApi;
import com.sinosoft.dms.api.carshiptax.dto.PrpDtaxRateDto;
import com.sinosoft.dms.core.carshiptax.service.PrpDtaxRateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;


/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-08-25 08:49:27.222
 * @description 税率表controller层
 */
@RestController
@RequestMapping(value = PrpDtaxRateController.PATH)
public class PrpDtaxRateController implements PrpDtaxRateApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDtaxRateController.class);

    @Resource
    private PrpDtaxRateService prpDtaxRateService;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(@RequestBody PrpDtaxRateDto prpDtaxRateDto) {
        prpDtaxRateService.save(prpDtaxRateDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestBody String comCode, java.lang.Integer taxPeriod, java.lang.Integer serialNo, String taxItemCode) {
        prpDtaxRateService.remove(comCode,taxPeriod,serialNo,taxItemCode);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpDtaxRateDto prpDtaxRateDto) {
        prpDtaxRateService.modify(prpDtaxRateDto);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    @Override
    public PrpDtaxRateDto queryByPK(@RequestBody String comCode, java.lang.Integer taxPeriod, java.lang.Integer serialNo, String taxItemCode) {
        return prpDtaxRateService.queryByPK(comCode,taxPeriod,serialNo,taxItemCode);
    }
    /**
     *@description 获取税率
     *@param
     */
    @Override
    public PrpDtaxRateDto getTaxRate(@RequestBody PrpDtaxRateDto prpDtaxRateDto) throws Exception {
        PrpDtaxRateDto dto = null;
        try {
            String comCode = prpDtaxRateDto.getComCode();
            int taxPeriod = 0;
            if (prpDtaxRateDto.getTaxPeriod() != null) {
                taxPeriod = prpDtaxRateDto.getTaxPeriod();
            }
            String taxItemCode = prpDtaxRateDto.getTaxItemCode();
            String taxDetailItemCode = prpDtaxRateDto.getTaxDetailItemCode();
            String validDate = "";
            if (prpDtaxRateDto.getValidDate() != null) {
                validDate = new SimpleDateFormat("yyyy-MM-dd").format(prpDtaxRateDto.getValidDate());
            }
            dto = prpDtaxRateService.getTaxRate(comCode, taxPeriod, taxItemCode, taxDetailItemCode, validDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
            return dto;

    }
}
