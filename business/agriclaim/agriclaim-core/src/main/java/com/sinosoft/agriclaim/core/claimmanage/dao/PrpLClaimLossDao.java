package com.sinosoft.agriclaim.core.claimmanage.dao;

import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaimLoss;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaimLossKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * 立案险别估损金额表Dao数据操作对象
 */
@Repository
public interface PrpLClaimLossDao extends JpaBaseDao<PrpLClaimLoss,PrpLClaimLossKey> {
	/**（危险单位查询用）
	 * @author: 王志文
	 * @date: 2018/4/11 11:29
	 * @param claimNo 立案号
	 * @return
	 */
	@Query("select p from PrpLClaimLoss p where p.claimNo=:claimNo order by p.serialNo")
	List<PrpLClaimLoss> findByClaimNo(@Param("claimNo") String claimNo);

	@Modifying
	@Transactional
	@Query(value = "delete from PrpLClaimLoss p where p.claimNo =:claimNo ")
	void deleteByClaimNo(@Param("claimNo") String claimNo);
}