package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.kernel.entity.PrpDshortRate;
import com.sinosoft.pms.core.kernel.entity.PrpDshortRateKey;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124
 * 短期费率表Dao数据操作对象
 */
@Repository
public interface PrpDshortRateDao extends JpaBaseDao<PrpDshortRate,PrpDshortRateKey> {
}