package com.sinosoft.agriclaim.core.businessutilmanage.dao;


import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLGrowth;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLGrowthKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * 生长期表表Dao数据操作对象
 */
@Repository
public interface PrpLGrowthDao extends JpaBaseDao<PrpLGrowth,PrpLGrowthKey> {

    @Query(value = "select p from PrpLGrowth p where p.clauseCode=:clauseCode and p.riskCode = :riskCode and p.flag='1'")
    public List<PrpLGrowth> queryByCondition(@Param("clauseCode")String clauseCode,@Param("riskCode")String riskCode ) ;

	
}