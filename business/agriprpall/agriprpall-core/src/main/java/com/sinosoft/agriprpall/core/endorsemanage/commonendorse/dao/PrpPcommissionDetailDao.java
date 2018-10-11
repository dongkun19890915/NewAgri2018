package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPcommissionDetail;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPcommissionDetailKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:07:09.217 
 * 手续费细节表Dao数据操作对象
 */
@Repository
public interface PrpPcommissionDetailDao extends JpaBaseDao<PrpPcommissionDetail,PrpPcommissionDetailKey> {

    @Query("delete from PrpPcommissionDetail p where p.endorseNo=:endorseNo")
    @Modifying
    @Transactional
    public void deleteByEndorseNo(@Param("endorseNo") String endorseNo);
}