package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemKindOrigin;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemKindOriginKey;
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
 * @time  2017-11-05 01:01:20.710 
 * 原始保单标的子险表Dao数据操作对象
 */
@Repository
public interface PrpCitemKindOriginDao extends JpaBaseDao<PrpCitemKindOrigin,PrpCitemKindOriginKey> {
    @Modifying
    @Transactional
    @Query(value = "delete from PrpCitemKindOrigin p where p.policyNo=:policyNo")
    public void deleteByPolicyNo(@Param("policyNo")String policyNo);
}