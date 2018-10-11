package com.sinosoft.dms.core.customer.dao;

import com.sinosoft.dms.core.customer.entity.PrpDcustomerRiskLevelSub;
import com.sinosoft.dms.core.customer.entity.PrpDcustomerRiskLevelSubKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * 记录客户风险等级详细表Dao数据操作对象
 */
@Repository
public interface PrpDcustomerRiskLevelSubDao extends JpaBaseDao<PrpDcustomerRiskLevelSub,PrpDcustomerRiskLevelSubKey> {

    @Query("select p from PrpDcustomerRiskLevelSub p where p.customerCode=:customerCode ")
    public List<PrpDcustomerRiskLevelSub> queryAllByCustomerCode(@Param("customerCode") String customerCode);
}