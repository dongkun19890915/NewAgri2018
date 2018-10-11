package com.sinosoft.ims.core.auth.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.ims.core.auth.entity.UtiUserLogin;
import com.sinosoft.ims.core.auth.entity.UtiUserLoginKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
 * @time  2017-11-05 01:11:08.689 
 * UtiUserLoginDao数据操作对象
 */
@Repository
public interface UtiUserLoginDao extends JpaBaseDao<UtiUserLogin,UtiUserLoginKey> {
    @Modifying
    @Transactional
    @Query(value = "update UtiUserLogin u set u.lastSuccessLoginTime= :#{#utiUserLogin.lastSuccessLoginTime}, " +
            "u.lastFailLoginTime=:#{#utiUserLogin.lastFailLoginTime},u.failLoginCount= :#{#utiUserLogin.failLoginCount}, " +
            "u.lockToTime=:#{#utiUserLogin.lockToTime} where u.userCode=:#{#utiUserLogin.userCode} ")
    public void update(@Param("utiUserLogin") UtiUserLogin utiUserLogin);
    /**
    * @description
    * @param lastSuccessLoginTime 最后成功登录时间
     * @param  lastFailLoginTime  最后失败登录时间
     *@param   failLoginCount   失败次数
     @param  lockToTime   锁定时间
     *@param userCode   用户代码
    * @return void
    * @throws
    * @author 李冬松
    * @date 14:32 2017/11/17
    */
    @Modifying
    @Transactional
    @Query(value = "update UtiUserLogin u set u.lastSuccessLoginTime= ?1, " +
            "u.lastFailLoginTime=?2,u.failLoginCount=?3, " +
            "u.lockToTime=?4 where u.userCode=?5 ")
    public void updated(String lastSuccessLoginTime,String lastFailLoginTime,String failLoginCount,String lockToTime,String userCode);
}