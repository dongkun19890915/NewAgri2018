package com.sinosoft.dms.core.carshiptax.service.impl;

import com.sinosoft.dms.api.carshiptax.dto.PrpDtaxRateDto;
import com.sinosoft.dms.core.carshiptax.dao.PrpDtaxRateDao;
import com.sinosoft.dms.core.carshiptax.entity.PrpDtaxRate;
import com.sinosoft.dms.core.carshiptax.entity.PrpDtaxRateKey;
import com.sinosoft.dms.core.carshiptax.service.PrpDtaxRateService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-08-25 08:49:27.222
 * @description 税率表Core接口实现
 */
@Service
public class PrpDtaxRateServiceImpl extends BaseServiceImpl  implements PrpDtaxRateService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDtaxRateServiceImpl.class);

    @Autowired
    private PrpDtaxRateDao prpDtaxRateDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDtaxRateDto prpDtaxRateDto) {
        PrpDtaxRate prpDtaxRate = this.convert(prpDtaxRateDto, PrpDtaxRate.class);
        prpDtaxRateDao.save(prpDtaxRate);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String comCode,java.lang.Integer taxPeriod,java.lang.Integer serialNo,String taxItemCode) {
        PrpDtaxRateKey prpDtaxRateKey = new PrpDtaxRateKey(comCode,taxPeriod,serialNo,taxItemCode);
        prpDtaxRateDao.delete(prpDtaxRateKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDtaxRateDto prpDtaxRateDto) {
        PrpDtaxRate prpDtaxRate = this.convert(prpDtaxRateDto, PrpDtaxRate.class);
        prpDtaxRateDao.save(prpDtaxRate);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrpDtaxRateDto queryByPK(String comCode,java.lang.Integer taxPeriod,java.lang.Integer serialNo,String taxItemCode) {
        PrpDtaxRateKey prpDtaxRateKey = new PrpDtaxRateKey(comCode,taxPeriod,serialNo,taxItemCode);
        PrpDtaxRate prpDtaxRate = prpDtaxRateDao.findOne(prpDtaxRateKey);
        return this.convert(prpDtaxRate,PrpDtaxRateDto.class);
    }

    public PrpDtaxRateDto  getTaxRate(String comCode, int taxPeriod, String taxItemCode, String taxItemDetailCode,
                           String validDate) throws Exception{
        PrpDtaxRate prpDtaxRate = prpDtaxRateDao.getTaxRate(comCode,taxPeriod,taxItemCode,taxItemDetailCode,validDate);
        return this.convert(prpDtaxRate, PrpDtaxRateDto.class);

    }
}