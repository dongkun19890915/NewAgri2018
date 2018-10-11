package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPcoinsDetail;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPcoinsDetailKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PrpCPcoinsDetailDao extends JpaBaseDao<PrpCPcoinsDetail,PrpCPcoinsDetailKey>{
    @Modifying
    @Transactional
    @Query(value = "delete from PrpCPcoinsDetail p where p.policyNo=?1 ")
    public void deleteAllByCondition(String policyNo);
}
