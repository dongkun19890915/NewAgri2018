package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPdangerItem;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPdangerItemKey;
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
 * 投保单危险单位划分表Dao数据操作对象
 */
@Repository
public interface PrpPdangerItemDao extends JpaBaseDao<PrpPdangerItem,PrpPdangerItemKey> {
    /**
     * 根据保单号删除PrpPdangerItem表数据
     * @author: 宋振振
     * @date: 2017/12/4 15:28
     * @param endorseNo
     * @throws Exception
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PrpPdangerItem p WHERE p.endorseNo=:endorseNo")
    public void cancelPrpPdangerItem(@Param("endorseNo") String endorseNo) throws Exception;
}