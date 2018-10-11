package com.sinosoft.demo.core.customer.dao;

import com.sinosoft.demo.core.customer.entity.PrpDcustomer;
import com.sinosoft.demo.core.customer.entity.PrpDcustomerKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-23 00:57:55.527 
 * 客户信息表Dao数据操作对象
 */
@Repository
public interface PrpDcustomerDao extends JpaBaseDao<PrpDcustomer,PrpDcustomerKey>{

    /**
     * @description 根据主键修改用户姓名
     * @param customerCName
     * @param customerCode
     * @return boolean
     * @throws Exception
     * @author 汪强
     * @date 2017年9月30日
     */
    @Transactional
    @Modifying(clearAutomatically = true)//自动清除实体里保存的数据。
    @Query(value = "update PrpDcustomer  set customerCName = ?1 where customerCode=?2")
    int updateCustomerName(String customerCName, String customerCode);



    /**
     * @description 根据用户名查找 jpql方法
     * @param customerCName
     * @return List<PrpDcustomer>
     * @throws Exception
     * @author 汪强
     * @date 2017年9月30日
     */
    @Query(value="select u from PrpDcustomer u where u.customerCName like %:customerCName%")
    List<PrpDcustomer> findCustomerByName(@Param("customerCName") String customerCName);



//    //1､按名称入参
//    @Query("select p from PrpDcustomer p where customerCName like :customerName%)”)
//            public List<PrpDcustomer> queryJpql(@Param(“customerName”) String customerName);
//    //2､按位入参
//    @Query(value = "update UserInfo  set isEnabled = abs(1-isEnabled) where id=?1")
//    public int updateEnabled(int id);//按位参数注入
//    //3､按对象入参
//    @Query(value = "select p from PrpDcustomer p where p.customerCode=:#{#pc.customerCode} and p.customerCName=:#{#pc.customerCName}")
//    public Page<PrpDcustomer> queryJpql(@Param("pc") PrpDcustomer pc, Pageable pageable);

}