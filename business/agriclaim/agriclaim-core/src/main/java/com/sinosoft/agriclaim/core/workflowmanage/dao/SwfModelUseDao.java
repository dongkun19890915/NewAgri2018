package com.sinosoft.agriclaim.core.workflowmanage.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfModelUse;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfModelUseKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 模板使用设置Dao数据操作对象
 */
@Repository
public interface SwfModelUseDao extends JpaBaseDao<SwfModelUse,SwfModelUseKey> {
	@Modifying
	@Transactional
	@Query(value = "delete from SwfModelUse where modelNo = :modelNo And modelStatus = :modelStatus")
	public void deleteByModelNoAndModelStatus(@Param(value = "modelNo") Integer modelNo,
			@Param(value = "modelStatus") String modelStatus);
}