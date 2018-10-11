package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPinsuredKey;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPinsured;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrpCPinsuredDao extends JpaBaseDao<PrpCPinsured,PrpCPinsuredKey>{
    @Query(value = "select p from PrpCPinsured p " +
            "where p.policyNo= ?1 " +
            "order by p.serialNo")
    public List<PrpCPinsured> queryAllByCondition(String policyNo);

    @Modifying
    @Transactional
    @Query(value = "delete from PrpCPinsured p where p.policyNo=?1 ")
    public void deleteAllByCondition(String policyNo);
    /**
     * 根据保单号删除PrpCPinsured表数据
     * @author: 宋振振
     * @date: 2017/12/4 15:28
     * @param policyNo
     * @throws Exception
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PrpCPinsured p WHERE p.policyNo=:policyNo")
    public void cancelPrpCPinsured(@Param("policyNo") String policyNo) throws Exception;
}
