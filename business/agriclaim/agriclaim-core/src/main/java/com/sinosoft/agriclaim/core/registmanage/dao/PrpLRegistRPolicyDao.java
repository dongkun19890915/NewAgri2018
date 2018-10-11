package com.sinosoft.agriclaim.core.registmanage.dao;

import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistRPolicy;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistRPolicyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.framework.core.utils.StringUtils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * 赔案保单关联表Dao数据操作对象
 */
@Repository
public interface PrpLRegistRPolicyDao extends JpaBaseDao<PrpLRegistRPolicy, PrpLRegistRPolicyKey> {
	@Modifying
	@Transactional
	@Query("DELETE FROM PrpLRegistRPolicy p Where registNo = ?1")
	void deleteByRegistNo(String registNo);

	@Query("SELECT p FROM PrpLRegistRPolicy p Where registNo = ?1 and validStatus = ?2")
	public List<PrpLRegistRPolicy> findByRegistNoAndValidStatus(String registNo, String validStatus);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update PrpLRegistRPolicy set validStatus='0'," + "  cancelReason=?1,"
			+ "  cancelReasonName=?2  Where  registNo = ?3")
	int updateCancelReport(String cancelReason, String cancelReasonName, String registNo);
	@Query("SELECT p FROM PrpLRegistRPolicy p Where registNo = ?1 and claimNo<> ?2  and  validStatus='1' ")
	public List<PrpLRegistRPolicy> findByConditions(String registNo, String claimNo);

}