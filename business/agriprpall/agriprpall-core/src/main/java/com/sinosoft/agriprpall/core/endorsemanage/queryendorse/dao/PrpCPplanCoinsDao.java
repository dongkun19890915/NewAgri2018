package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPplanCoins;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPplanCoinsKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PrpCPplanCoinsDao extends JpaBaseDao<PrpCPplanCoins,PrpCPplanCoinsKey> {
    /**
     * 根据保单号删除PrpCPplanCoins表数据
     * @author: 宋振振
     * @date: 2017/12/4 15:28
     * @param policyNo
     * @throws Exception
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PrpCPplanCoins p WHERE p.policyNo=:policyNo")
    public void cancelPrpCPplanCoins(@Param("policyNo") String policyNo) throws Exception;
}
