package com.sinosoft.dms.core.dict.dao;

import com.sinosoft.dms.core.dict.entity.PrpCountryCode;
import com.sinosoft.dms.core.dict.entity.PrpCountryCodeKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
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
 * @time  2017-11-05 01:01:20.710 
 * PrpCountryCodeDao数据操作对象
 */
@Repository
public interface PrpCountryCodeDao extends JpaBaseDao<PrpCountryCode,PrpCountryCodeKey> {

    @Query("select p from PrpCountryCode p where p.codeType='BusinessZone' and p.upCode=:fieldExt")
    public List<PrpCountryCode> findAllByUpCode(@Param("fieldExt") String fieldExt);

    /**
     * 按CodeCode查询实体
     * @param codeCode 代码
     * @author 王心洋
     * @time 21080104
     * @return PrpCountryCodeDto
     */
    @Query("select p from PrpCountryCode p where p.codeType='BusinessZone' and p.codeCode=:codeCode")
    public PrpCountryCode queryByCodeCode(@Param("codeCode") String codeCode);
}