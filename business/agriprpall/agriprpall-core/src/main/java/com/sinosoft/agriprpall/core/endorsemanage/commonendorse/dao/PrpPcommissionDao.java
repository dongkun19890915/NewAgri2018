package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPcommissionKey;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPcommission;
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
 * 手续费表Dao数据操作对象
 */
@Repository
public interface PrpPcommissionDao extends JpaBaseDao<PrpPcommission,PrpPcommissionKey> {
    /**
     * 根据批单号删除
     * @author: 王保良
     * @date: 2017/12/13 17:43
     * @param endorseNo 批单号
     * @return void
     */
    @Modifying
    @Transactional
    @Query(value = "delete from PrpPcommission p where p.endorseNo=:endorseNo")
    public void deleteByEndorseNo(@Param("endorseNo")String endorseNo);
}