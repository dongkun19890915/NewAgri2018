package com.sinosoft.agriclaim.core.paymentmanage.dao;

import com.sinosoft.agriclaim.core.paymentmanage.entity.PrpLClaimBillManager;
import com.sinosoft.agriclaim.core.paymentmanage.entity.PrpLClaimBillManagerKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-11 08:55:21.509 
 * 理赔清单数据管理表Dao数据操作对象
 */
@Repository
public interface PrpLClaimBillManagerDao extends JpaBaseDao<PrpLClaimBillManager,PrpLClaimBillManagerKey> {
    @Modifying
    @Transactional
    @Query("update PrpLClaimBillManager p set p.payFlag=:payFlag where p.registNo=:registNo and p.compensateNo=:compensateNo and p.serialNo=:serialNo and p.payFlag<>:payFlag")
    public void updatePrpLClaimBillManagerByConditions(@Param("registNo") String registNo,@Param("compensateNo") String compensateNo,@Param("serialNo") Integer serialNo,@Param("payFlag") String payFlag);
}