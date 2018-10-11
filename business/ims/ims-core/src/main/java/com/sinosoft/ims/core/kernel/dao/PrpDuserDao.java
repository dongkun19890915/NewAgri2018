package com.sinosoft.ims.core.kernel.dao;

import com.sinosoft.ims.core.kernel.entity.PrpDuser;
import com.sinosoft.ims.core.kernel.entity.PrpDuserKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * 员工代码表Dao数据操作对象
 */
@Repository
public interface PrpDuserDao extends JpaBaseDao<PrpDuser,PrpDuserKey> {

    /**
     *  根据用户代码查询用户名称
     * @author: 刘曼曼
     * @date: 2017/11/24 14:11
     * @param operatorCodes 用户代码集合
     * @return List<String>用户名称集合
     */
    @Query(value = " select d.userName from PrpDuser d where userCode in(:operatorCodes)")
    public List<String> queryOperatorName(@Param("operatorCodes") List<String> operatorCodes);

    /**
     * * 根据用户代码查询用户名称
     * @author: 田慧
     * @date: 20:09
     * @param operatorCodes 用户代码集合
     * @return  List<String> 用户信息集合
     * @throws Exception
     */
    @Query(value = " select d from PrpDuser d where userCode in(:operatorCodes)")
    public List<PrpDuser> getOperatorCode(@Param("operatorCodes") List<String> operatorCodes);
    /**
     *  根据员工名称获取员工代码
     * @author: 田慧
     * @date: 2017/12/4 14:46
     * @param userName 员工名称
     * @return PrpDuser的集合
     * @throws Exception
     */
    @Query(value = "select p.userCode from PrpDuser p where p.userName=:userName")
    public  List<String> queryUserCodeByUserName(@Param("userName") String userName);


    @Query("select p from PrpDuser p where p.userCode=:userCode and p.password=:pwd")
    public PrpDuser findUserByPwd(@Param("userCode")String userCode,@Param("pwd")String pwd);


    @Modifying
    @Transactional
    @Query("update  PrpDuser p set p.password=:pwd where p.userCode=:userCode")
    public Integer modifypwd(@Param("userCode")String userCode,@Param("pwd")String pwd);
}