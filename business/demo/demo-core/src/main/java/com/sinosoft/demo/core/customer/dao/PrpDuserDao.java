package com.sinosoft.demo.core.customer.dao;

import com.sinosoft.demo.core.customer.entity.PrpDuser;
import com.sinosoft.demo.core.customer.entity.PrpDuserKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PrpDuserDao extends JpaBaseDao<PrpDuser,PrpDuserKey> {



    /**
     * @description 根据主键修改用户姓名
     * @param userName
     * @param userCode
     * @return boolean
     * @throws Exception
     * @author 汪强
     * @date 2017年10月12日
     */
    @Transactional
    @Modifying(clearAutomatically = true)//自动清除实体里保存的数据。
    @Query(value = "update PrpDuser  set userName = ?1 where userCode=?2")
    int updateUserName(String userName, String userCode);



    /**
     * @description 根据主键修改用户姓名
     * @param userName
     * @param userCode
     * @return boolean
     * @throws Exception
     * @author 汪强
     * @date 2017年10月12日
     */
    @Transactional
    @Modifying(clearAutomatically = true)//自动清除实体里保存的数据。
    @Query(value = "update PrpDuser  set userName =:userName where userCode=:userCode")
    int updateUserNameByCode(@Param("userName") String userName,@Param("userCode") String userCode);



    /**
     * @description 根据用户名查找
     * @param userName
     * @return List<PrpDcustomer>
     * @throws Exception
     * @author 汪强
     * @date 2017年10月12日
     */
    @Query(value="select u from PrpDuser u where u.userName like :userName%")
    List<PrpDuser> findCustomerByName(@Param("userName") String userName);


    //统计人数
    @Query(value = "select count(u) from PrpDuser u")
    Long findCountUser();







}
