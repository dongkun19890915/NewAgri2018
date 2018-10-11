package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.kernel.entity.PrpDitem;
import com.sinosoft.pms.core.kernel.entity.PrpDitemKey;
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
 * 标的项目代码表Dao数据操作对象
 */
@Repository
public interface PrpDitemDao extends JpaBaseDao<PrpDitem,PrpDitemKey> {

    /**
     * 根据险种和标的代码查询标的名称
     * @param riskCode 险种代码
     * @param itemCode 标的代码
     * @return PrpDitem 标的项目代码表信息
     */
    @Query(value = "select p.itemCName from PrpDitem p where p.riskCode=:riskCode and p.itemCode=:itemCode " )
    public String findByRiskCodeAndItemCName(@Param("riskCode") String riskCode,@Param("itemCode") String itemCode);

    /**
     * 根据险种查询prpditem表
     * @param riskCode 险种代码
     * @return List<PrpDitem> 标的项目代码表信息
     */
    public List<PrpDitem> findByRiskCode(String riskCode);
    /**
     *  根据标的名称查询标的代码
     * @author: 田慧
     * @date: 2017/12/22 11:12
     * @param itemCName 标的名称
     * @return itemCode的集合
     * @throws Exception
     */
    @Query(value = "select distinct (p.itemCode) from PrpDitem  p where p.itemCName =:itemCName")
    List<String> queryItemCode(@Param("itemCName") String itemCName);

    /**
     * 根据险种代码和多个标的代码查询标的中文名称
     *
     * @param riskCode  险种代码
     * @param itemCodes 标的代码
     * @return 标的代码-标的名称
     * @author: 何伟东
     * @date: 2018/1/11 19:29
     */
    @Query(value = "select i from PrpDitem i where i.riskCode=:riskCode and i.itemCode in (:itemCode) and i.validStatus='1'")
    List<PrpDitem> queryByItemCodes(@Param(value = "riskCode") String riskCode,@Param(value = "itemCode") List<String> itemCodes);

    /**
     * 根据险种代码查询对应的标的信息
     *
     * @param riskCode 险种代码
     * @return 标的代码-标的名称
     * @author: 何伟东
     * @date: 2018/1/11 19:29
     */
    @Query(value = "select i from PrpDitem i where i.riskCode=:riskCode and i.validStatus='1'")
    List<PrpDitem> queryByRiskCode(@Param(value = "riskCode") String riskCode);
}