package com.sinosoft.ims.core.auth.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.ims.core.auth.entity.UtiPlatConfig;
import com.sinosoft.ims.core.auth.entity.UtiPlatConfigKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * UtiPlatConfigDao数据操作对象
 */
@Repository
public interface UtiPlatConfigDao extends JpaBaseDao<UtiPlatConfig,UtiPlatConfigKey> {
    @Query(value = "select u from UtiPlatConfig u where u.systemCode=?1 and u.paramCode=?2 ")
    public UtiPlatConfig queryByCondition(String systemCode,String paramCode);
}