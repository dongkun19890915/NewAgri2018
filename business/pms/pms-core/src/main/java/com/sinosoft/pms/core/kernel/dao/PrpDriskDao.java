package com.sinosoft.pms.core.kernel.dao;


import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.kernel.entity.PrpDrisk;
import com.sinosoft.pms.core.kernel.entity.PrpDriskKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 12:48:22.282 
 * 险种代码表Dao数据操作对象
 */
@Repository
public interface PrpDriskDao extends JpaBaseDao<PrpDrisk,PrpDriskKey> {

    @Query(value = "select p from PrpDrisk p where p.classCode=:classCode order by p.riskCode")
    List<PrpDrisk> queryAllByClassCode(@Param("classCode") String classCode);

    /**
     * 根据险类、标的查询险种（快速出单）
     * @author: 田健
     * @date: 2018/4/8 22:03
     * @param classCode 险类
     * @param itemCodeList 标的集合
     * @return 险种集合
     */
    @Query(value = "select p from PrpDrisk p where p.classCode=:classCode and p.riskCode in (select q.riskCode from PrpDitemAgri q where q.itemCode in(:itemCodeList)) order by p.riskCode")
    List<PrpDrisk> queryAllByClassCodeAndItemCodeList(@Param("classCode") String classCode,@Param("itemCodeList") List<String> itemCodeList);
    @Query(value = "select p from PrpDrisk p where p.riskCode=:riskCode")
    PrpDrisk queryAllByRiskCode(@Param("riskCode") String riskCode);


    /**
     * 根据险种代码查询险种名称
     * @author: 刘曼曼
     * @date: 2017/12/19 11:52
     * @param riskCodes 险种代码集合
     * @return List<String>险种名称集合
     * @throws Exception
     */
    @Query(value = "select p.riskCName from PrpDrisk p where p.riskCode in(:riskCodes)")
    public List<String> queryAllByRiskName(@Param("riskCodes") List<String> riskCodes);

    @Query(value = "select p.riskCode from PrpDrisk p where p.riskCName=:riskCName")
    public List<String> queryRiskName(@Param("riskCName") String riskCName);
    /**
     * 根据险种代码查询保费计算方式
     * @author: 刘曼曼
     * @date: 2017/12/19 11:52
     * @param riskCode 险种代码
     * @return Double 费率分位
     * @throws Exception
     */
    @Query(value = "select p.calculator from PrpDrisk p where p.riskCode =:riskCode")
    public Double queryByRiskCode(@Param("riskCode") String riskCode);

    @Query(value = "select p.riskCode from PrpDrisk p where p.validStatus='1'")
    public String[] findByValidStatus();

    @Query(value = "select p.riskCode from PrpDrisk p where p.flag='ZC' and p.validStatus='1'")
    public String[] findByValidStatusAndFlag();

    /**
     * 根据险类代码查询该险类下的所有险种,如果没有传险类,则默认查询31和32下的所有险种
     * @author: 王保良
     * @date: 2017/01/09 11:50
     * @return List<PrpDrisk>
     * @throws Exception
     */
    @Query(value = "select p from PrpDrisk p where p.classCode in ('31','32') ")
    public List<PrpDrisk> queryByCondition();

    /**
     * 根据险种集合查询险种信息
     * @author: 田健
     * @date: 2018/4/27 11:54
     * @param riskCodes 险种集合
     * @return 险种集合信息
     */
    @Query(value = "select p from PrpDrisk p where p.riskCode  in (:riskCodes)")
    public List<PrpDrisk> findAllByRiskCodes(@Param("riskCodes") List<String> riskCodes);

    /*
    * @author: 钱浩
    * @date: 2018/5/23 下午 23:44
    * */
    @Query(value = "select p from PrpDrisk p ")
    public List<PrpDrisk> queryByriskName();
}