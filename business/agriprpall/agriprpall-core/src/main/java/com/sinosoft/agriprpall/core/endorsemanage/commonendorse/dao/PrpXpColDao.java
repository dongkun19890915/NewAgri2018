package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpXpCol;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpXpColKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 06:23:40.452 
 * 批文数据字典表Dao数据操作对象
 */
@Repository
public interface PrpXpColDao extends JpaBaseDao<PrpXpCol,PrpXpColKey> {
}