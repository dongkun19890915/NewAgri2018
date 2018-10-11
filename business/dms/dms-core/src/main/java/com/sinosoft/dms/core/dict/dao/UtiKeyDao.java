package com.sinosoft.dms.core.dict.dao;

import com.sinosoft.dms.api.billno.dto.UtiKeyDto;
import com.sinosoft.dms.core.dict.entity.UtiKey;
import com.sinosoft.dms.core.dict.entity.UtiKeyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-10 12:51:20.949 
 * UtiKeyDao数据操作对象
 */
@Repository
public interface UtiKeyDao extends JpaBaseDao<UtiKey,UtiKeyKey > {

    @Query(value = "Select u From UtiKey u Where u.tableName=:tableName ")
    public List<UtiKeyDto> queryAllPrpGroup(@Param("tableName") String tableName);
}