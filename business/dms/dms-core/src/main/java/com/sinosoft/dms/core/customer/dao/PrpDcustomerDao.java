package com.sinosoft.dms.core.customer.dao;

import com.sinosoft.dms.core.customer.entity.PrpDcustomer;
import com.sinosoft.dms.core.customer.entity.PrpDcustomerKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-23 00:57:55.527 
 * 客户信息表Dao数据操作对象
 */
@Repository
public interface PrpDcustomerDao extends JpaBaseDao<PrpDcustomer,PrpDcustomerKey> {

    @Query(value = "select p from PrpDcustomer p where p.customerCName=:customerCName")
    public List<PrpDcustomer> queryByCustomerCName(@Param("customerCName") String customerCName);


}