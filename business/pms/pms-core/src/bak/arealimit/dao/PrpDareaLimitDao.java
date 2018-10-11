package com.sinosoft.pms.core.arealimit.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.arealimit.entity.PrpDareaLimit;
import com.sinosoft.pms.core.arealimit.entity.PrpDareaLimitKey;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
/**
 * @author codegen@研发中心
 * @mail yinqingzhu@sinosoft.com.cn
 * @time  2016-09-17 09:50:13.946 
 * PrpDareaLimit-地区限额控制配置表  数据操作接口类
 */
@Repository
public interface PrpDareaLimitDao extends JpaBaseDao<PrpDareaLimit,PrpDareaLimitKey> {

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE PRPDAREALIMIT e SET e.invaliddate = ?1,e.updateTime = ?2,e.updateBy = ?3 WHERE " +
            "e.versionno = (SELECT p.versionno FROM PrpDareaLimit p WHERE " +
            "p.riskcode = ?4 and p.invaliddate = to_date('9999-09-09', 'yyyy-mm-dd') AND p.areacode = ?5)",nativeQuery = true)
    int updateInvalidDate(Date invalidDate, Date updateTime, String updateBy, String riskCode, String areacode);
}