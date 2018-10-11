package com.sinosoft.agriclaim.core.claimmanage.dao;

import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaimFee;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaimFeeKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * 估损金额表Dao数据操作对象
 */
@Repository
public interface PrpLClaimFeeDao extends JpaBaseDao<PrpLClaimFee,PrpLClaimFeeKey> {
	/**
     * （根据立案号删除实体）
     * @author: 李洋
     * @date: 2017/11/14 11:03
     * @param claimNo 立案号
     */
	@Modifying
	@Transactional
	@Query(value = "delete from PrpLClaimFee p where p.claimNo = :claimNo ")
	public void deleteByClaimNo(@Param(value = "claimNo") String claimNo);
}