package com.sinosoft.agriclaim.core.workflowmanage.dao;

import com.sinosoft.agriclaim.core.workflowmanage.entity.PrpLAutoClaimList;
import com.sinosoft.agriclaim.core.workflowmanage.entity.PrpLAutoClaimListKey;
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
 * @time  2018-01-23 10:17:47.442 
 * 自动理赔清单数据表Dao数据操作对象
 */
@Repository
public interface PrpLAutoClaimListDao extends JpaBaseDao<PrpLAutoClaimList,PrpLAutoClaimListKey> {
}