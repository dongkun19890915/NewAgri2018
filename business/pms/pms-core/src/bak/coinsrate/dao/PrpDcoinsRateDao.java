package com.sinosoft.pms.core.coinsrate.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.coinsrate.entity.PrpDcoinsRate;
import com.sinosoft.pms.core.coinsrate.entity.PrpDcoinsRateKey;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
/**
 * @author codegen@研发中心
 * @mail yinqingzhu@sinosoft.com.cn
 * @time  2016-09-17 09:51:06.937 
 * PrpDcoinsRate-共同体成员比例配置表  数据操作接口类
 */
@Repository
public interface PrpDcoinsRateDao  extends JpaBaseDao<PrpDcoinsRate,PrpDcoinsRateKey>{

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE PrpDcoinsRate e SET E.INVALIDDATE = ?1, UPDATETIME = ?2, UPDATEBY = ?3 WHERE E.VERSIONNO = " +
            "(SELECT P.VERSIONNO FROM PrpDcoinsRate P WHERE P.riskCode = ?4 AND P.invalidDate = to_date('9999-09-09', 'yyyy-mm-dd') " +
            "AND P.COMCODE = ?5)",nativeQuery = true)
    int updateInvalidDate(Date invalidDate, Date updateTime, String updateBy, String riskCode, String comCode);
}