package com.sinosoft.pms.core.salerate.dao;

import java.util.Date;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.salerate.entity.PrpDsalesRate;
import com.sinosoft.pms.core.salerate.entity.PrpDsalesRateKey;
import org.springframework.data.jpa.repository.Query;

/**
 * @author codegen@研发中心
 * @mail yinqingzhu@sinosoft.com.cn
 * @time  2016-09-16 14:49:48.451 
 * PrpDsalesRate-销售费用率配置表  数据操作接口类
 */
public interface PrpDsalesRateDao extends JpaBaseDao<PrpDsalesRate,PrpDsalesRateKey> {

    @Query(value = "update PrpDsalesRate set Invaliddate = ?1, updateTime = ?2, updateBy = ?3 where " +
            "businessNature = ?4 and versionNo = (" +
            "    select e.versionNo from PrpDsalesRate e" +
            "    where e.riskCode = ?5 " +
            "    and e.invaliddate = to_date('9999-09-09', 'yyyy-mm-dd')" +
            "    and e.businessNature = ?4" +
            "    )",nativeQuery = true)
    int updateInvalidDate(Date invalidDate, Date updateTime, String updateBy, String businessNature, String riskCode);
}
