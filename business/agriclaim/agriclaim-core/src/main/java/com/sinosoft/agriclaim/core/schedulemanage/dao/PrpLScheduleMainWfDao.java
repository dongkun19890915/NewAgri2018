package com.sinosoft.agriclaim.core.schedulemanage.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleMainWf;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleMainWfKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:58.930 
 * 调度任务/查勘任务主表Dao数据操作对象
 */
@Repository
public interface PrpLScheduleMainWfDao extends JpaBaseDao<PrpLScheduleMainWf,PrpLScheduleMainWfKey> {
	@Modifying
	@Transactional
	@Query("DELETE FROM PrpLScheduleMainWf Where registNo = ?1")
	void deleteByRegistNo(String registNo);

	@Query("SELECT p FROM PrpLScheduleMainWf p Where registNo = ?1 and scheduleId = ?2")
	PrpLScheduleMainWf findByRegistNoAndScheduleId(String registNo, int scheduleId);
}