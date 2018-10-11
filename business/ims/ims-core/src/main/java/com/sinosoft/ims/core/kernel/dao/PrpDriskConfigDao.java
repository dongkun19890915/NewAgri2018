package com.sinosoft.ims.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.ims.core.kernel.entity.PrpDriskConfig;
import com.sinosoft.ims.core.kernel.entity.PrpDriskConfigKey;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 03:18:29.180 
 * PrpDriskConfigDao数据操作对象
 */
@Repository
public interface PrpDriskConfigDao extends JpaBaseDao<PrpDriskConfig,PrpDriskConfigKey> {
}