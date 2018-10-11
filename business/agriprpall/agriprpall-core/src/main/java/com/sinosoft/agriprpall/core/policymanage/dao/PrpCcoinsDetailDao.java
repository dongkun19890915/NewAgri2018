package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCcoinsDetail;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCcoinsDetailKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * 共保信息明细表Dao数据操作对象
 */
@Repository
public interface PrpCcoinsDetailDao extends JpaBaseDao<PrpCcoinsDetail,PrpCcoinsDetailKey> {
    @Query(value = "select p from PrpCcoinsDetail p " +
            "where p.policyNo=?1 " +
            "and p.serialNo=?2 " +
            "and p.operateFee<>0")
    public PrpCcoinsDetail queryAllByConditions(String policyNo, int serialNo);

    @Modifying
    @Transactional
    @Query(value = "delete from PrpCcoinsDetail p where p.policyNo=:policyNo")
    public void deleteByPolicyNo(@Param("policyNo")String policyNo);
}