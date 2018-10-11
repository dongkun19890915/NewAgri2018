package com.sinosoft.agriclaim.core.workflowmanage.dao;

import com.sinosoft.agriclaim.core.workflowmanage.entity.PrplReturnVisitSwflog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.PrplReturnVisitSwflogKey;
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
 * @time  2017-11-10 02:50:26.122 
 * 回访工作流表Dao数据操作对象
 */
@Repository
public interface PrplReturnVisitSwflogDao extends JpaBaseDao<PrplReturnVisitSwflog,PrplReturnVisitSwflogKey> {
}