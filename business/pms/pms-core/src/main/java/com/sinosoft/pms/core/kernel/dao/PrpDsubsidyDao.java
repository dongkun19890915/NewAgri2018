package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.kernel.entity.PrpDsubsidy;
import com.sinosoft.pms.core.kernel.entity.PrpDsubsidyKey;
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
 * @time  2017-11-04 10:42:46.546 
 * PrpDsubsidyDao数据操作对象
 */
@Repository
public interface PrpDsubsidyDao extends JpaBaseDao<PrpDsubsidy,PrpDsubsidyKey> {

    /**
     * 根据条件查询PrpDsubsidy补贴信息表信息(此方法只针对3218险种)
     * @author: 田健
     * @date: 2017/12/1 18:41
     * @param riskCode 险种代码
     * @param comCode 归属机构代码
     * @param subsidyYear 年份
     * @return 返回List<PrpDsubsidyDto>补贴信息表信息集合
     * @throws Exception
     */
    @Query(value = "select p from PrpDsubsidy p where p.validStatus='1' and p.riskCode=:riskCode and p.comCode=:comCode and p.subsidyYear=:subsidyYear")
    public List<PrpDsubsidy> findPrpDsubsidyDtoListByCondition(@Param("riskCode") String riskCode,@Param("comCode") String comCode,@Param("subsidyYear") String subsidyYear);
}