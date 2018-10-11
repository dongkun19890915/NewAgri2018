package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.kernel.entity.PrpDkindItem;
import com.sinosoft.pms.core.kernel.entity.PrpDkindItemKey;
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
 * PrpDkindItemDao数据操作对象
 */
@Repository
public interface PrpDkindItemDao extends JpaBaseDao<PrpDkindItem,PrpDkindItemKey> {
    /**
     * 根据险种与险别查询险别标的关联表
     * @author: 田健
     * @date: 2018/3/23 11:57
     * @param riskCode 险种代码
     * @param kindCode 险别代码
     * @return 险别标的关联信息
     */
    @Query(value = "SELECT p.itemCode from PrpDkindItem p where p.riskCode=:riskCode and p.kindCode=:kindCode")
    List<String> findByRiskCodeAndKindCode (@Param("riskCode") String riskCode,@Param("kindCode") String kindCode);

    /**
     * 根据险别和险种及标的代码查询险别标的关联表
     * @author: 刘曼曼
     * @date: 10:29 10:29
     * @param riskCode 险种代码
     * @param kindCodes 险别代码
     * @param itemCodes 标的代码
     * @return List<PrpDkindItem> 询险别标的关联表集合
     */
    @Query(value = "SELECT p from PrpDkindItem p where p.riskCode=:riskCode and p.kindCode in(:kindCodes) and p.itemCode in (:itemCodes)")
    List<PrpDkindItem> findByRiskCodeAndKindCodeAndItemCode (@Param("riskCode") String riskCode,@Param("kindCodes") List<String> kindCodes, @Param("itemCodes") List<String> itemCodes);
}