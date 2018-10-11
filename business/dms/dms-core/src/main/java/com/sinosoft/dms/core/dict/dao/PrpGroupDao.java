package com.sinosoft.dms.core.dict.dao;


import com.sinosoft.dms.api.billno.dto.PrpGroupDto;
import com.sinosoft.dms.core.dict.entity.PrpGroup;
import com.sinosoft.dms.core.dict.entity.PrpGroupKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-10 12:51:20.949 
 * PrpGroupDao数据操作对象
 */
@Repository
public interface PrpGroupDao extends JpaBaseDao<PrpGroup,PrpGroupKey> {

    @Query(value = "Select distinct p.groupNo From PrpGroup p Where p.subGroupNo=:subGroupNo ")
    public List<PrpGroupDto> queryPrpGroup(@Param("subGroupNo") String subGroupNo);

    @Query(value = "Select p From PrpGroup p Where p.groupNo=:groupNo ")
    public List<PrpGroupDto> queryAllPrpGroup(@Param("groupNo") String groupNo);
}