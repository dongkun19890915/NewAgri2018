package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.pms.core.kernel.entity.PrpDautoClauseRule;
import com.sinosoft.pms.core.kernel.entity.PrpDautoClauseRuleKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-09-12 12:28:37.662 
 * 自动生成特约校验规则表Dao数据操作对象
 */
@Repository
public interface PrpDautoClauseRuleDao extends JpaBaseDao<PrpDautoClauseRule,PrpDautoClauseRuleKey> {
    @Modifying
    @Query(value = "delete from PrpDautoClauseRule where clauseCode = :clauseCode and comCode = :comCode and riskCode = :riskCode")
    void deleteByCondition(@Param(value = "clauseCode") String clauseCode,
                           @Param(value = "comCode") String comCode, @Param(value = "riskCode") String riskCode);
}