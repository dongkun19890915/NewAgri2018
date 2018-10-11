package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPinsuredArtifKey;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPinsuredArtif;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:00:38.844 
 * 法人信息表Dao数据操作对象
 */
@Repository
public interface PrpCPinsuredArtifDao extends JpaBaseDao<PrpCPinsuredArtif,PrpCPinsuredArtifKey> {
    /**
     * 根据保单号删除PrpCPinsuredArtif表数据
     * @author: 宋振振
     * @date: 2017/12/4 15:28
     * @param policyNo
     * @throws Exception
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PrpCPinsuredArtif p WHERE p.policyNo=?1")
    public void deletePrpCPinsuredArtif(@Param("policyNo") String policyNo) throws Exception;
}