package com.sinosoft.agriclaim.core.jobmanage.dao;

import com.sinosoft.agriclaim.core.jobmanage.entity.PrpLJobManagerTime;
import com.sinosoft.agriclaim.core.jobmanage.entity.PrpLJobManagerTimeKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:38.981 
 * 班表管理从表Dao数据操作对象
 */
@Repository
public interface PrpLJobManagerTimeDao extends JpaBaseDao<PrpLJobManagerTime,PrpLJobManagerTimeKey> {
    @Modifying
    @Transactional
    @Query(value = "delete from PrpLJobManagerTime t where t.fid =:fid")
    public void deleteTimeCondition(@Param("fid") String fid);

    @Query(value="select fid from PrpLJobManagerTime where time=:time and dateType=:dateType")
    public List<String> findPrpLJobManagerTimeByTime(@Param("time") String time,@Param("dateType") String dateType);
}