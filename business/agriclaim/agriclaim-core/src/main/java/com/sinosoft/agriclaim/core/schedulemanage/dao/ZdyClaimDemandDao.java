package com.sinosoft.agriclaim.core.schedulemanage.dao;

import com.sinosoft.agriclaim.core.schedulemanage.entity.ZdyClaimDemand;
import com.sinosoft.agriclaim.core.schedulemanage.entity.ZdyClaimDemandKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-10 02:49:33.975 
 * 驻点员App案件推送日志表Dao数据操作对象
 */
@Repository
public interface ZdyClaimDemandDao extends JpaBaseDao<ZdyClaimDemand,ZdyClaimDemandKey> {
}