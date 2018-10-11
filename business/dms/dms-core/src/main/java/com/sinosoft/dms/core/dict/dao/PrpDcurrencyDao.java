package com.sinosoft.dms.core.dict.dao;

import com.sinosoft.dms.core.dict.entity.PrpDcurrency;
import com.sinosoft.dms.core.dict.entity.PrpDcurrencyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447 
 * 币别代码表Dao数据操作对象
 */
@Repository
public interface PrpDcurrencyDao extends JpaBaseDao<PrpDcurrency,PrpDcurrencyKey> {
}