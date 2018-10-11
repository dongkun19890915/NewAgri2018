package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPplanKey;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPplan;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 03:06:48.016 
 * 收费计划表Dao数据操作对象
 */
@Repository
public interface PrpCPplanDao extends JpaBaseDao<PrpCPplan,PrpCPplanKey> {
    @Query(value = "select p from PrpCPplan p where p.policyNo=:policyNo order by p.serialNo")
    public List<PrpCPplan> findPrpCPPlanByPolicyNo(@Param("policyNo") String policyNo);

    @Modifying
    @Transactional
    @Query(value = "delete from PrpCPplan p where p.policyNo=?1 ")
    public void deleteAllByCondition(String policyNo);
}