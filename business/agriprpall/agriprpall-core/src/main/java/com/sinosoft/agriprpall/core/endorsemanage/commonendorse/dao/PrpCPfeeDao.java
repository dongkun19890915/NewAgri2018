package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPfee;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPfeeKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 03:06:48.016 
 * 保单保额保费表 Dao数据操作对象
 */
@Repository
public interface PrpCPfeeDao extends JpaBaseDao<PrpCPfee,PrpCPfeeKey> {

    @Query(value = "select p from PrpCPfee p where p.policyNo=:policyNo")
    public List<PrpCPfee> findPrpCPfeeByPolicyNo(@Param("policyNo") String policyNo);

    @Modifying
    @Transactional
    @Query(value = "delete from PrpCPfee p where p.policyNo=?1 ")
    public void deleteAllByCondition(String policyNo);
}