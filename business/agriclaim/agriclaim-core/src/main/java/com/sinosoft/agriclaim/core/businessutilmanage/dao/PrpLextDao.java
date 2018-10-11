package com.sinosoft.agriclaim.core.businessutilmanage.dao;

import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLext;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLextKey;
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
 * @time  2017-11-08 05:35:28.283 
 * 理赔扩展系统表Dao数据操作对象
 */
@Repository
public interface PrpLextDao extends JpaBaseDao<PrpLext,PrpLextKey> {
	/**
     * （根据业务号型删除实体）
     * @author: 李洋
     * @date: 2017/11/14 11:03
     * @param businessNo 业务号
     */
	@Modifying
	@Transactional
	@Query(value = "delete from PrpLext where certiNo = :certiNo ")
	public void deleteByCertiNo(@Param(value = "certiNo") String certiNo);

}