package com.sinosoft.agriclaim.core.claimmanage.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLCompensateEar;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLCompensateEarKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * 理赔分户清单表Dao数据操作对象
 */
@Repository
public interface PrpLCompensateEarDao extends JpaBaseDao<PrpLCompensateEar, PrpLCompensateEarKey> {
	@Modifying
	@Transactional
	@Query("DELETE FROM PrpLCompensateEar Where registNo = ?1 and nodeType = ?2")
	void deleteByRegistNoAndNodeType(String registNo, String string);

	@Query("SELECT p FROM PrpLCompensateEar p Where registNo = ?1")
	List<PrpLCompensateEar> findByRegistNo(String registNo);

	@Modifying
	@Transactional
	@Query("DELETE FROM PrpLCompensateEar Where claimNo = ?1")
	void deleteByClaimNo(String claimNo);
}