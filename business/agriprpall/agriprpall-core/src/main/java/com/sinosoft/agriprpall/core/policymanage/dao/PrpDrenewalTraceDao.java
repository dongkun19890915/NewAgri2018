package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpDrenewalTrace;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpDrenewalTraceKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PrpDrenewalTraceDao extends JpaBaseDao<PrpDrenewalTrace,PrpDrenewalTraceKey>{

    @Modifying
    @Transactional
    @Query(value = "delete from PrpDrenewalTrace p where p.policyNo=:policyNo")
    public void deleteByPolicyNo(@Param("policyNo") String policyNo);
}
