package com.sinosoft.pms.core.productrule.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.productrule.entity.UtiFactor;
import com.sinosoft.pms.core.productrule.entity.UtiFactorKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail handongwei@sinosoft.com.cn
 * @time 2016-09-18 20:27:00.111
 *       UtiFactor 数据操作接口类
 */
@Repository
public interface UtiFactorDao extends JpaBaseDao<UtiFactor,UtiFactorKey> {

    @Query(value = "select" +
            "    distinct f.factorcode," +
            "    f.factortype," +
            "    s.relatedfactorcodes," +
            "    f.fromcolumn," +
            "    f.factorsourcetype" +
            "    from utifactor f" +
            "    left join utifactorrelaship s" +
            "    on f.factorcode = s.factorcode" +
            "    and f.riskcode = s.riskcode" +
            "    and f.clausecode = s.clausecode" +
            "    and f.kindcode = s.kindcode" +
            "    and f.comcode = s.comcode" +
            "    where f.validstatus = '1'" +
            "    and (sysdate > f.validdate or f.validdate is null)" +
            "    and (f.invaliddate > sysdate or f.invaliddate is null)" +
            "    and (s.validstatus = '1' or s.factorcode is null)" +
            "    and (sysdate > s.validdate or s.validdate is null)" +
            "    and (s.invaliddate > sysdate or s.invaliddate is null) and" +
            "    F.RiskCode = ?1 and" +
            "    F.ClauseCode = ?2 and" +
            "    F.KindCode = ?3 and" +
            "    F.ComCode = ?4" +
            "    start with f.factorcode in ?5" +
            "    connect by instr(prior s.relatedfactorcodes, f.factorcode) > 0",nativeQuery = true)
    List<Map<String,Object>> selectPremiumFactorByCondtion(String riskCode, String clauseCode, String kindCode, String comCode, List<String> factorCodeList);
}