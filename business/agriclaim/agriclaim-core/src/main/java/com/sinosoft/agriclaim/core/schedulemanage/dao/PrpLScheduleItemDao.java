package com.sinosoft.agriclaim.core.schedulemanage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleItem;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleItemKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-08 05:45:58.930 调度任务标的表Dao数据操作对象
 */
@Repository
public interface PrpLScheduleItemDao extends JpaBaseDao<PrpLScheduleItem, PrpLScheduleItemKey> {
	@Modifying
	@Transactional
	@Query("DELETE FROM PrpLScheduleItem Where registNo = ?1")
	void deleteByRegistNo(String registNo);

	@Query("SELECT p FROM PrpLScheduleItem p Where registNo = ?1 and scheduleId = ?2")
	List<PrpLScheduleItem> findByRegistNoAndScheduleId(String registNo, int scheduleId);
}