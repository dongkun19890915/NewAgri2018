package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPfeild;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPfeildKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PrpCPfeildDao extends JpaBaseDao<PrpCPfeild,PrpCPfeildKey> {
    /**
     * 根据保单号删除PrpCPfeild表数据
     * @author: 宋振振
     * @date: 2017/12/4 15:28
     * @param policyNo
     * @throws Exception
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PrpCPfeild p WHERE p.policyNo=:policyNo")
    public void cancelPrpCPfeild(@Param("policyNo") String policyNo) throws Exception;
}
