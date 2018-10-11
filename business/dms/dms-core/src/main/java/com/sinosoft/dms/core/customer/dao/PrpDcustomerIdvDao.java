package com.sinosoft.dms.core.customer.dao;

import com.sinosoft.dms.core.customer.entity.PrpDcustomerIdv;
import com.sinosoft.dms.core.customer.entity.PrpDcustomerIdvKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-23 00:57:55.527 
 * 个人客户信息表Dao数据操作对象
 */
@Repository
public interface PrpDcustomerIdvDao extends JpaBaseDao<PrpDcustomerIdv,PrpDcustomerIdvKey> {
    /**
     * @description: 根据客户姓名查询个人客户信息表
     * @author: 宋振振
     * @date: 2017/11/3 14:13
     * @param customerCName
     * @return List<PrpDcustomerIdv>
     */
    public List<PrpDcustomerIdv> findPrpDcustomerIdvByCustomerCName(String customerCName);
    /**
     * @description: 根据客户代码查询个人客户信息表
     * @author: 宋振振
     * @date: 2017/11/3 14:13
     * @param customerCode
     * @return PrpDcustomerIdv
     */
    public PrpDcustomerIdv findPrpDcustomerIdvByCustomerCode(String customerCode);
    /**
     *  根据客户中文名称查询prpDcustomerIdv 个人客户代码表信息
     * @author: 田慧
     * @date: 2017/12/2 9:27
     * @param customerCName 客户中文名称
     * @return 返回prpDcustomerIdv 个人客户代码表信息
     */
    @Query(value = "select p from PrpDcustomerIdv p where p.customerCName= :customerCName")
    public List<PrpDcustomerIdv> queryPrpDcustomerIdvByCondition(@Param("customerCName") String customerCName);

    @Query(value = "select p from PrpDcustomerIdv p where p.identifyType=:identifyType and p.identifyNumber=:identifyNumber")
    public List<PrpDcustomerIdv> queryByIndentity(@Param("identifyType")String identifyType,@Param("identifyNumber") String identifyNumber);

}