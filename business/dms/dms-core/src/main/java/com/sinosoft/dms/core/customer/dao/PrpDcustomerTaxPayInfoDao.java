package com.sinosoft.dms.core.customer.dao;

import com.sinosoft.dms.core.customer.entity.PrpDcustomerTaxPayInfo;
import com.sinosoft.dms.core.customer.entity.PrpDcustomerTaxPayInfoKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-17 13:04:37.553 
 * 客户纳税人信息表Dao数据操作对象
 */
@Repository
public interface PrpDcustomerTaxPayInfoDao extends JpaBaseDao<PrpDcustomerTaxPayInfo,PrpDcustomerTaxPayInfoKey> {
   public PrpDcustomerTaxPayInfo findPrpDCustomerTaxPayInfoByCustomerCode(String customerCode);
}