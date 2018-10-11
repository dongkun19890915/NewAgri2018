package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPcommissionDetail;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPcommissionDetailKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:00:38.844 
 * 手续费细节表Dao数据操作对象
 */
@Repository
public interface PrpCPcommissionDetailDao extends JpaBaseDao<PrpCPcommissionDetail,PrpCPcommissionDetailKey> {
}