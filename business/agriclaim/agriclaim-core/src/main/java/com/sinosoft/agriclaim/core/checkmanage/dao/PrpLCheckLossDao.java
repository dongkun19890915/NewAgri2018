package com.sinosoft.agriclaim.core.checkmanage.dao;

import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLCheckLoss;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLCheckLossKey;
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
 * @time  2017-11-08 05:38:49.324 
 * 查勘事故估损金额表Dao数据操作对象
 */
@Repository
public interface PrpLCheckLossDao extends JpaBaseDao<PrpLCheckLoss,PrpLCheckLossKey> {
	/**
     * （根据报案号删除实体）
     * @author: 李洋
     * @date: 2017/11/14 11:03
     * @param registNo 报案号
     */
	@Modifying
	@Transactional
	@Query(value = "delete from PrpLCheckLoss where registNo = :registNo ")
	public void deleteByRegistNo(@Param(value = "registNo") String registNo);
}