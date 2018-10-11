package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.kernel.entity.PrpDclass;
import com.sinosoft.pms.core.kernel.entity.PrpDclassKey;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 12:48:22.282 
 * 险类代码表Dao数据操作对象
 */
@Repository
public interface PrpDclassDao extends JpaBaseDao<PrpDclass,PrpDclassKey> {
}