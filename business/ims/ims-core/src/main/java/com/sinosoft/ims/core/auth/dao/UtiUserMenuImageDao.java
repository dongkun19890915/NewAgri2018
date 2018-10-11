package com.sinosoft.ims.core.auth.dao;

import com.sinosoft.ims.core.auth.entity.UtiUserMenuImage;
import com.sinosoft.ims.core.auth.entity.UtiUserMenuImageKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 07:56:24.672 
 * 常用菜单图标信息表Dao数据操作对象
 */
@Repository
public interface UtiUserMenuImageDao extends JpaBaseDao<UtiUserMenuImage,UtiUserMenuImageKey> {

    /**
     * 常用菜单图标查询
     * @author 王心洋
     * @time 2017-11-14
     * @return utiUserMenuImageDtoList
     */
    @Query(value = "select u from UtiUserMenuImage u where u.validStatus='1' and u.sysFlag=:sysFlag")
    public List<UtiUserMenuImage> findValid(@Param("sysFlag") String sysFlag);
}