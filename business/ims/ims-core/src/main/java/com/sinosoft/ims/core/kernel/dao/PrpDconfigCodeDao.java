package com.sinosoft.ims.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.ims.core.kernel.entity.PrpDconfigCode;
import com.sinosoft.ims.core.kernel.entity.PrpDconfigCodeKey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * 开关配置表Dao数据操作对象
 */
@Repository
public interface PrpDconfigCodeDao extends JpaBaseDao<PrpDconfigCode,PrpDconfigCodeKey> {
}