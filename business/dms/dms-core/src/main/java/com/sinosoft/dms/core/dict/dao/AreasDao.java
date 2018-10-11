package com.sinosoft.dms.core.dict.dao;

import com.sinosoft.dms.core.dict.entity.Areas;
import com.sinosoft.dms.core.dict.entity.AreasKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-10 06:45:04.724 
 * 行政区域表Dao数据操作对象
 */
@Repository
public interface AreasDao extends JpaBaseDao<Areas,AreasKey> {
}