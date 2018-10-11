package com.sinosoft.agriclaim.core.cetainmanage.dao;

import com.sinosoft.agriclaim.core.cetainmanage.entity.PrpLProp;
import com.sinosoft.agriclaim.core.cetainmanage.entity.PrpLPropKey;
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
 * @time  2017-11-08 05:36:28.690 
 * 财产核定损明细清单表Dao数据操作对象
 */
@Repository
public interface PrpLPropDao extends JpaBaseDao<PrpLProp,PrpLPropKey> {
	@Modifying
	@Query("DELETE FROM PrpLProp Where registNo = ?1")
	void deleteByRegistNo(String registNo);
	@Query
	List<PrpLProp> findByRegistNo(String registNo);
	/**
     * （根据报案号更新立案号）
     * @author: 李洋
     * @date: 2017/11/14 11:03
     * @param registNo 报案号
     * @param claimNo 立案号
     */
	@Modifying
	@Transactional
	@Query(value = "update PrpLProp set claimNo= :claimNo where registNo =:registNo")
	public void updateClaimNoByregistNo(@Param(value = "claimNo") String claimNo,@Param(value = "registNo") String registNo);

}