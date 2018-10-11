package com.sinosoft.ims.core.auth.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.ims.core.auth.entity.UtiUserMenu;
import com.sinosoft.ims.core.auth.entity.UtiUserMenuKey;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 07:55:48.156 
 * 常用菜单信息表Dao数据操作对象
 */
@Repository
public interface UtiUserMenuDao extends JpaBaseDao<UtiUserMenu,UtiUserMenuKey> {

    /**
     * 常用菜单查询：按照用户代码查询菜单列表
     * @author 王心洋
     * @time 2017-11-14
     * @param userCode 用户代码
     */
    @Query(" select u from UtiUserMenu u where u.userCode=:userCode and u.sysFlag=:sysFlag and u.comCode=:comCode order by u.menuId")
    public List<UtiUserMenu> findByUserCode(@Param("userCode") String userCode, @Param("sysFlag") String sysFlag, @Param("comCode") String comCode);

    /**
     * (描述)
     * @author: 宋振振
     * @date: 2018/1/27 12:06
     * @param userCode
     * @return
     * @throws Exception
     */
    @Query("select max (a.menuId) from UtiUserMenu a where a.userCode=:userCode  and a.sysFlag=:sysFlag and a.comCode=:comCode ")
    public Integer findMaxIndexNo(@Param("userCode") String userCode, @Param("sysFlag") String sysFlag, @Param("comCode") String comCode);

     @Transactional
     @Modifying
     @Query(value = "delete from UtiUserMenu m where m.userCode=:userCode and m.menuCName=:menuCName anD m.comCode=:comCode")
     public void deleteUtiUserMenu(@Param("userCode") String userCode, @Param("menuCName") String menuCName, @Param("comCode") String comCode);

}