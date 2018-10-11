package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPheadCopy;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPheadCopyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface PrpPheadCopyDao extends JpaBaseDao<PrpPheadCopy,PrpPheadCopyKey>{
    @Modifying
    @Transactional
    @Query(value = "delete from PrpPheadCopy p where p.endorseNo=:endorseNo")
    public void deleteByEndorseNo(@Param("endorseNo") String endorseNo);

}
