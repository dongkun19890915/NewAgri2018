package com.sinosoft.dms.core.customer.dao;

import com.sinosoft.dms.core.customer.entity.PrpDcustomerUnit;
import com.sinosoft.dms.core.customer.entity.PrpDcustomerUnitKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-23 00:57:55.527 
 * 团体客户信息表Dao数据操作对象
 */
@Repository
public interface PrpDcustomerUnitDao extends JpaBaseDao<PrpDcustomerUnit,PrpDcustomerUnitKey> {
    /**
     * @description: 根据客户姓名查询团体客户信息表
     * @author: 宋振振
     * @date: 2017/11/3 14:18
     * @param customerCName
     * @return List<PrpDcustomerUnit>
     */
    public List<PrpDcustomerUnit> findPrpDcustomerUnitByCustomerCName(String customerCName);
    /**
     * @description: 根据客户代码查询团体客户信息表
     * @author: 宋振振
     * @date: 2017/11/3 14:18
     * @param customerCode
     * @return PrpDcustomerUnit
     */
    public PrpDcustomerUnit findPrpDcustomerIdvByCustomerCode(String customerCode);

    /**
     *  根据客户中文名称查询 prpdcustomerunit集体客户代码表信息
     * @author: 田慧
     * @date: 2017/12/2 9:27
     * @param customerCName 客户中文名称
     * @return 返回PrpDcustomerUnit 集体客户代码表集合
     */
    @Query(value = "select p from PrpDcustomerUnit p where p.customerCName= :customerCName")
    public List<PrpDcustomerUnit> queryPrpDcustomerUnitByCondition(@Param("customerCName") String customerCName);

}