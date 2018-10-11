package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.kernel.entity.PrpDitemAgri;
import com.sinosoft.pms.core.kernel.entity.PrpDitemAgriKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * 标的项目代码表Dao数据操作对象
 */
@Repository
public interface PrpDitemAgriDao extends JpaBaseDao<PrpDitemAgri,PrpDitemAgriKey> {

    /**
     * 根据险种和标的代码查询标的名称
     * @param riskCode 险种代码
     * @param itemCode 标的代码
     * @return PrpDitem 标的项目代码表信息
     */
    @Query(value = "select p.itemCName from PrpDitemAgri p where p.riskCode=:riskCode and p.itemCode=:itemCode " )
    public String findByRiskCodeAndItemCName(@Param("riskCode") String riskCode,@Param("itemCode") String itemCode);

    /**
     * 根据险种查询prpditem表
     * @param riskCode 险种代码
     * @return List<PrpDitem> 标的项目代码表信息
     */
    public List<PrpDitemAgri> findByRiskCode(String riskCode);
    /**
     *  根据标的名称查询标的代码
     * @author: 田慧
     * @date: 2017/12/22 11:12
     * @param itemCName 标的名称
     * @return itemCode的集合
     * @throws Exception
     */
    @Query(value = "select distinct (p.itemCode) from PrpDitemAgri  p where p.itemCName =:itemCName")
    List<String> queryItemCode(@Param("itemCName") String itemCName);

    /**
     * 根据标的查询险种（快速出单带出险种、险类）
     *
     * @param itemCodeList 标的代码集合
     * @return 标的对象集合
     * @author: 田健
     * @date: 2018/4/8 20:21
     */
    @Query(value = "select p.riskCode from PrpDitemAgri p where p.itemCode in(?1)")
    public List<String> queryByItemCode(List<String> itemCodeList);
    /**
     *  根据标的查询险种（快速出单带出险种、险类）
     * @author: 钱浩
     * @date: 2018/4/8 20:21
     * @return 标的对象集合
     */
    @Query(value = "select p from PrpDitemAgri p where p.riskCode =:riskCode")
    public List<PrpDitemAgri> queryByRiskinfo(@Param("riskCode") String riskCode);
}