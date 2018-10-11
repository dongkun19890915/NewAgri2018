package com.sinosoft.dms.core.dict.dao;

import com.sinosoft.dms.core.dict.entity.PrpDcodeRisk;
import com.sinosoft.dms.core.dict.entity.PrpDcodeRiskKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:20.710
 * PrpDcodeRisk数据操作对象
 */
@Repository
public interface PrpDcodeRiskDao extends JpaBaseDao<PrpDcodeRisk,PrpDcodeRiskKey>{

    @Query("select u.codeCode from PrpDcodeRisk u where u.codeType = 'ClauseCode' and (u.riskCode=:riskCode or u.riskCode='0000')")
    public List findCodeCodeByRiskCode(@Param("riskCode") String riskCode);
}
