package com.sinosoft.agriclaim.core.workflowmanage.dao;

import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfNotion;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfNotionKey;
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
 * @time  2017-11-08 05:47:03.090 
 * 处理意见表Dao数据操作对象
 */
@Repository
public interface SwfNotionDao extends JpaBaseDao<SwfNotion,SwfNotionKey> {
	@Query(value = "Select max(s.lineNo)+1 from SwfNotion s Where s.flowId=?1 and s.logNo=?2")
	Integer getMaxLineNo(String flowID,int logNo);
}