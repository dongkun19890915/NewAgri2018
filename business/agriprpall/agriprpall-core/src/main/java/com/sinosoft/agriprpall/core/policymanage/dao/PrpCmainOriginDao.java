package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainOrigin;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainOriginKey;
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
 * 原始保单主表Dao数据操作对象
 */
@Repository
public interface PrpCmainOriginDao extends JpaBaseDao<PrpCmainOrigin,PrpCmainOriginKey> {
    @Modifying
    @Transactional
    @Query(value = "delete from PrpCmainOrigin p where p.policyNo=:policyNo")
    public void deleteByPolicyNo(@Param("policyNo")String policyNo);
}