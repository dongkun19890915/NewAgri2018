package com.sinosoft.pms.core.productrule.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.productrule.entity.UtiFormula;
import com.sinosoft.pms.core.productrule.entity.UtiFormulaKey;
import org.springframework.data.jpa.repository.Query;

/**
 * @author codegen@研发中心
 * @mail handongwei@sinosoft.com.cn
 * @time 2016-09-18 20:27:00.111
 *       UtiFormula 数据操作接口类
 */
public interface UtiFormulaDao extends JpaBaseDao<UtiFormula,UtiFormulaKey> {

    @Query(value = "select * from utiformula where validstatus = '1' and (sysdate > validdate or validdate is null) and " +
            "(invaliddate > sysdate or invaliddate is null) and RiskCode = ?1 and ClauseCode = ?2 and KindCode = ?3 and ComCode = ?4 and FormulaType = ?5"
    ,nativeQuery = true)
    UtiFormula selectPremiumFormulaByCondition(String riskCode, String clauseCode, String kindCode, String comCode, String formulaType);

}