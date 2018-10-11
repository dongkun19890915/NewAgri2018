package com.sinosoft.dms.core.carshiptax.dao;

import com.sinosoft.dms.core.carshiptax.entity.PrpDtaxRate;
import com.sinosoft.dms.core.carshiptax.entity.PrpDtaxRateKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.framework.core.dao.support.Specifications;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-08-25 08:49:27.222
 * 税率表Dao数据操作对象
 */
@Repository
public interface PrpDtaxRateDao extends JpaBaseDao<PrpDtaxRate,PrpDtaxRateKey> {

    public default PrpDtaxRate getTaxRate(String comCode, int taxPeriod, String taxItemCode, String taxDetailItemCode,
                                             String validDate) throws Exception {
        int ilevel = 8;
        StringBuffer sbCalComCode = null;
        List<PrpDtaxRate> sumPrpDtaxRate = new ArrayList<PrpDtaxRate>();
        try {
            for (int i = ilevel; i > 0; i--) {
                if (ilevel < 0) {
                    break;
                }
                sbCalComCode = new StringBuffer("00000000");
                sbCalComCode.replace(0, ilevel, comCode.substring(0, ilevel));
                String strCalComCode = new String(sbCalComCode);
                List<PrpDtaxRate> PrpDtaxRateList = null;
                if (taxDetailItemCode != null && !"".equals(taxDetailItemCode)) {
                    PrpDtaxRateList = this.findAll(Specifications.<PrpDtaxRate>and()
                            .eq(StringUtils.isNotEmpty(comCode), "comCode", comCode)
                            .eq("taxPeriod", taxPeriod)
                            .eq(StringUtils.isNotEmpty(taxItemCode), "taxItemCode", taxItemCode)
                            .eq(StringUtils.isNotEmpty(taxDetailItemCode), "taxDetailItemCode",taxDetailItemCode)
                            .le(StringUtils.isNotEmpty(validDate),"validDate", new SimpleDateFormat("yyyy-MM-dd").parse(validDate))
                            .eq("validStatus", "1")
                            .build());
                } else {
                    PrpDtaxRateList = this.findAll(Specifications.<PrpDtaxRate>and()
                            .eq(StringUtils.isNotEmpty(comCode), "comCode", comCode)
                            .eq("taxPeriod", taxPeriod)
                            .eq(StringUtils.isNotEmpty(taxItemCode), "taxItemCode", taxItemCode)
                            .le(StringUtils.isNotEmpty(validDate),"validDate", new SimpleDateFormat("yyyy-MM-dd").parse(validDate))
                            .eq("validStatus", "1")
                            .build());
                }
                sumPrpDtaxRate.addAll(PrpDtaxRateList);
                if (PrpDtaxRateList.size() == 0) {
                    ilevel = ilevel - 2;
                } else
                    break;
            }
            if (ilevel < 0) {
                List<PrpDtaxRate> PrpDtaxRateList2 = null;
                if (taxDetailItemCode != null && !"".equals(taxDetailItemCode)) {
                    PrpDtaxRateList2 = this.findAll(Specifications.<PrpDtaxRate>and()
                            .eq(StringUtils.isNotEmpty(comCode), "comCode", comCode)
                            .eq("taxPeriod", taxPeriod)
                            .eq(StringUtils.isNotEmpty(taxItemCode), "taxItemCode", taxItemCode)
                            .eq(StringUtils.isNotEmpty(taxDetailItemCode), "taxDetailItemCode",taxDetailItemCode)
                            .le(StringUtils.isNotEmpty(validDate),"validDate", new SimpleDateFormat("yyyy-MM-dd").parse(validDate))
                            .eq("validStatus", "1")
                            .build());
                } else {
                    PrpDtaxRateList2 = this.findAll(Specifications.<PrpDtaxRate>and()
                            .eq(StringUtils.isNotEmpty(comCode), "comCode", comCode)
                            .eq("taxPeriod", taxPeriod)
                            .eq(StringUtils.isNotEmpty(taxItemCode), "taxItemCode", taxItemCode)
                            .le(StringUtils.isNotEmpty(validDate),"validDate", new SimpleDateFormat("yyyy-MM-dd").parse(validDate))
                            .eq("validStatus", "1")
                            .build());
                }
                sumPrpDtaxRate.addAll(PrpDtaxRateList2);
                if (sumPrpDtaxRate.size() == 0) {
                    throw new Exception("没有找到车船税税额信息,请系统管理员维护");
                }
            }
        } catch (Exception e) {
            throw (e);
        }
        if (sumPrpDtaxRate.size() > 0 && sumPrpDtaxRate.size() == 1) {
            return sumPrpDtaxRate.get(0);
        }
        return null;
    }
}