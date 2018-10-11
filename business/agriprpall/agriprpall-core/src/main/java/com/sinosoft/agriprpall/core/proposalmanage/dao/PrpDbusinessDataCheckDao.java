package com.sinosoft.agriprpall.core.proposalmanage.dao;

import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpDbusinessDataCheck;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpDbusinessDataCheckKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-31 01:52:20.999 
 * 业务数据检查表Dao数据操作对象
 */
@Repository
public interface PrpDbusinessDataCheckDao extends JpaBaseDao<PrpDbusinessDataCheck,PrpDbusinessDataCheckKey> {
}