package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPexpense;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPexpenseKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PrpPexpenseDao extends JpaBaseDao<PrpPexpense,PrpPexpenseKey> {

    @Modifying
    @Transactional
    @Query(value = "delete from PrpPexpense p where p.endorseNo=:endorseNo")
    public void deleteByEndorseNo(@Param("endorseNo") String endorseNo);
}
