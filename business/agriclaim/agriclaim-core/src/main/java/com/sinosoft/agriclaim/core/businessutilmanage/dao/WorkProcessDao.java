package com.sinosoft.agriclaim.core.businessutilmanage.dao;

import com.sinosoft.agriclaim.core.businessutilmanage.entity.WorkProcess;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.WorkProcessKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-15 07:15:21.216 
 * 工作流程表Dao数据操作对象
 */
@Repository
public interface WorkProcessDao extends JpaBaseDao<WorkProcess,WorkProcessKey> {
    @Query(value="select nvl(max(id),1) from WorkProcess  where registNo=:registNo")
    public Integer findMaxKeyByRegistNo(@Param("registNo") String registNo);

}