package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.kernel.entity.PrpDkindClauseAgri;
import com.sinosoft.pms.core.kernel.entity.PrpDkindClauseAgriKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * PrpDkindClauseDao数据操作对象
 */
@Repository
public interface PrpDkindClauseAgriDao extends JpaBaseDao<PrpDkindClauseAgri,PrpDkindClauseAgriKey> {
    /**
     * 根据险种代码查询条款代码集合
     * @author: 刘曼曼
     * @date: 2017/12/19 18:46
     * @param riskCode 险种代码
     * @return List<String> 条款代码集合
     */
    @Query(value = "select k.clauseCode from PrpDkindClauseAgri k where k.riskCode=:riskCode ")
    public List<String> findByRiskCode(@Param("riskCode") String riskCode);
}