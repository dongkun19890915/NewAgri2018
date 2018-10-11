package com.sinosoft.dms.core.dict.dao;

import com.sinosoft.dms.core.dict.entity.PrpTownCode;
import com.sinosoft.dms.core.dict.entity.PrpTownCodeKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-28 10:26:37.210 
 * prpTownCodeDao数据操作对象
 */
@Repository
public interface PrpTownCodeDao extends JpaBaseDao<PrpTownCode,PrpTownCodeKey> {

    @Query("select p from PrpTownCode p where p.codeType='BusinessZone' and p.upCode=:fieldExt")
    public List<PrpTownCode> findAllByUpCode(@Param("fieldExt") String fieldExt);
}