package com.sinosoft.dms.core.paymanage.dao;

import org.springframework.stereotype.Repository;

import com.sinosoft.dms.core.paymanage.entity.PrpDbank;
import com.sinosoft.dms.core.paymanage.entity.PrpDbankKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-02-13 03:08:45.046 
 * 银行定义表Dao数据操作对象
 */
@Repository
public interface PrpDbankDao extends JpaBaseDao<PrpDbank,PrpDbankKey> {
}