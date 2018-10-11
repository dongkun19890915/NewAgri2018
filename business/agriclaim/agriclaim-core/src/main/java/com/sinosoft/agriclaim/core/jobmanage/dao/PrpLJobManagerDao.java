package com.sinosoft.agriclaim.core.jobmanage.dao;

import com.sinosoft.agriclaim.core.jobmanage.entity.PrpLJobManager;
import com.sinosoft.agriclaim.core.jobmanage.entity.PrpLJobManagerKey;
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
 * 班表管理主表Dao数据操作对象
 */
@Repository
public interface PrpLJobManagerDao extends JpaBaseDao<PrpLJobManager,PrpLJobManagerKey> {
    @Modifying
    @Transactional
    @Query(value= "delete from  PrpLJobManager where handleDept=:handleDept and  classCode=:classCode and  month=:month ")
    public void deleteManagerCondition(@Param("handleDept") String handleDept,
                                       @Param("classCode") String classCode,
                                       @Param("month") String month);




}



