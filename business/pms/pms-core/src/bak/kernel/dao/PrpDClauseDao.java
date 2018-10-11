package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.kernel.entity.PrpDClause;
import com.sinosoft.pms.core.kernel.entity.PrpDClauseKey;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail yinqingzhu
 * @time  2016-10-13 16:30:54.800 
 * 条款定义表-PrpDClause  数据操作接口类
 */
@Repository
public interface PrpDClauseDao extends JpaBaseDao<PrpDClause,PrpDClauseKey> {

}