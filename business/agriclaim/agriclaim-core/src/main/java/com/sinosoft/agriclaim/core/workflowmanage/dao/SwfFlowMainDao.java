package com.sinosoft.agriclaim.core.workflowmanage.dao;

import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfFlowMain;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfFlowMainKey;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 流程主表Dao数据操作对象
 */
@Repository
public interface SwfFlowMainDao extends JpaBaseDao<SwfFlowMain,SwfFlowMainKey> {
	@Query(value = "Select s From SwfFlowMain s Where s.policyNo = :policyNo")
	public List<SwfFlowMain> findAllByPolicyNo(@Param(value = "policyNo") String policyNo);

	/**
	 * （重开赔案申请失败更新流程主表的数据）
	 * @author: 王志文
	 * @date: 2017/11/17 10:12
	 * @param flowId
	 */
	@Modifying
	@Query("Update SwfFlowMain s set s.flowStatus ='0',s.storeFlag ='1' where s.flowId =:flowId")
	void updateMsgByFlowId(@Param("flowId") String flowId);

}