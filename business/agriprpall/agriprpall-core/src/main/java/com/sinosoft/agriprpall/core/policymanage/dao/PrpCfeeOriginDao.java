package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCfeeOrigin;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCfeeOriginKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
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
 * @time  2017-11-05 01:01:20.710 
 * 原始保单保额保费Dao数据操作对象
 */
@Repository
public interface PrpCfeeOriginDao extends JpaBaseDao<PrpCfeeOrigin,PrpCfeeOriginKey> {
    @Modifying
    @Transactional
    @Query(value = "delete from PrpCfeeOrigin p where p.policyNo=:policyNo")
    public void deleteByPolicyNo(@Param("policyNo")String policyNo);
}