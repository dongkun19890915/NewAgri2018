package com.sinosoft.txnlist.core.customer.dao;


import com.sinosoft.txnlist.core.customer.entity.PrpDcustomer;
import com.sinosoft.txnlist.core.customer.entity.PrpDcustomerKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-23 00:57:55.527 
 * 客户信息表Dao数据操作对象
 */
@Repository
public interface PrpDcustomerDao extends JpaBaseDao<PrpDcustomer,PrpDcustomerKey> {
}