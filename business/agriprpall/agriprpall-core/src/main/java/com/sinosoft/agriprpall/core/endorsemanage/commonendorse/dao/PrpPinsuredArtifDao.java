package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPinsuredArtif;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPinsuredArtifKey;
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
 * 法人信息表Dao数据操作对象
 */
@Repository
public interface PrpPinsuredArtifDao extends JpaBaseDao<PrpPinsuredArtif,PrpPinsuredArtifKey> {
    /**
     * 根据保单号删除PrpPinsuredArtif表数据
     * @author: 宋振振
     * @date: 2017/12/4 15:28
     * @param policyNo
     * @throws Exception
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PrpPinsuredArtif p WHERE p.policyNo=:policyNo")
    public void cancelPrpPinsuredArtif(@Param("policyNo") String policyNo) throws Exception;
}