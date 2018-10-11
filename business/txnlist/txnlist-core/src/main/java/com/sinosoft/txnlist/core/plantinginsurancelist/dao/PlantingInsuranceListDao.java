package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.api.gisinsurelist.dto.InsuranceInfoDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingInsuranceList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingInsuranceListKey;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 03:27:26.178 
 * 投保明细表Dao数据操作对象
 */
@Repository
public interface PlantingInsuranceListDao extends JpaBaseDao<PlantingInsuranceList,PlantingInsuranceListKey> {

    /**
     * @description:（根据inusreListcode汇总查询获取投保清单中总户数）
     * @author: 田健
     * @date: 2017/10/20 11:52
     * @param inusreListCode
     * @return int
     */
    @Query(value = "select count(distinct p.fCode) from PlantingInsuranceList p where inusreListCode=:inusreListCode and validity='1' AND insureArea>0")
    public int getSumInsured(@Param("inusreListCode") String inusreListCode);

    /**
     * @description:（根据inreListcode查询各项补贴金额与农户自缴份额）
     * @author: 田健
     * @date: 2017/10/20 11:52
     * @param inusreListCode
     * @return List<Object[]>
     */
    @Query(value = "select sum(a.sumPremium) as sumpremium ,sum(a.fPremium) as fpremium,sum(a.centralPremium) as centralpremium,sum(a.provincePremium) as provincepremium,sum(a.cityPremium) as citypremium,sum(a.townPremium) as townpremium,sum(a.otherPremium) as otherpremium from PlantingInsuranceList a where a.inusreListCode=:inusreListCode and validity='1' AND insureArea>0")
    public List<Object[]> getSumFee(@Param("inusreListCode") String inusreListCode);

    /**
     * @description:（根据inreListcode删除清单数据）
     * @author: 田健
     * @date: 2017/10/20 11:52
     * @param inusreListCode
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "delete from PlantingInsuranceList d where d.inusreListCode=:inusreListCode")
    public void removeByInusreListCode(@Param("inusreListCode") String inusreListCode);
    /**
     * @description:根据inusrelistcode查询PlantingInsuranceList
     * @author: 陈道洋
     * @date: 2017/10/31 14:19
     * @param inusreListCode
     * @return
     */
    public List<PlantingInsuranceList> findByInusreListCode(String inusreListCode);

    /**
     * @param inusreListCode
     * @author: 潘峰
     * @description 传inusreListCode查询PlantingInsuranceList集合
     * 将PlantingInsuranceList集合的每一条entity保存到PlantingPolicyList和Plantingpolicylistorigin
     */
    List<PlantingInsuranceList> inusreListCode(String inusreListCode);

    @Query(value = "select new com.sinosoft.txnlist.api.gisinsurelist.dto.InsuranceInfoDto( sum(a.fPremium) as fPremium,sum(a.centralPremium) " +
            "as centralPremium,sum(a.provincePremium) as provincePremium ,sum(a.cityPremium) as cityPremium,sum(a.townPremium) as townPremium,sum(a.otherPremium) " +
            "as otherPremium,sum(a.insureArea) as insureArea,count(a.fCode) as iSumInsured) from PlantingInsuranceList a where a.inusreListCode=:insureListCode and a.itemCode=:itemCode " +
            "and a.kindCode=:kindCode and a.validity='1' and a.fCode in (select b.fCode from GisFarmerItem b where b.insureListCode=:gisInsureListCode and b.serialNo=:serialNo and b.itemListCode=:itemListCode)")
    public InsuranceInfoDto queryByConditioin(@Param("insureListCode") String insureListCode,@Param("itemCode") String itemCode,@Param("kindCode")String kindCode,@Param("gisInsureListCode")String gisInsureListCode,@Param("serialNo") Integer serialNo,@Param("itemListCode") String itemListCode);
    /**
     *
     * @param
     * @return
     * @throws
     * @author 陈道洋
     * @date 10:37 2017/11/22
     */
    @Query(value = "select h from PlantingInsuranceList h where h.inusreListCode=?1 and h.fCode=?2")
    PlantingInsuranceList queryByInusreListCodeAndFcode(String insureListCode,String fCode);

}