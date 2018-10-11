package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCfee;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCfeeKey;
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
 * @time  2017-10-24 07:46:04.010 
 * 保单保额保费表Dao数据操作对象
 */
@Repository
public interface PrpCfeeDao extends JpaBaseDao<PrpCfee,PrpCfeeKey> {
    @Modifying
    @Transactional
    public void deleteAllByPolicyNo(String policyNo);

    @Modifying
    @Transactional
    @Query(value = "delete from PrpCfee p where p.policyNo=:policyNo")
    public void deleteByPolicyNo(@Param("policyNo") String policyNo);

}