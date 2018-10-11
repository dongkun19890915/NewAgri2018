package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxInsuranceInfoDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxInsuranceList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxInsuranceListKey;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-30 07:53:53.940
 * 种植业投保明细Dao数据操作对象
 */
@Repository
public interface NyxInsuranceListDao extends JpaBaseDao<NyxInsuranceList, NyxInsuranceListKey> {


/**
 * (根据inreListcode查询各项补贴金额与农户自缴份额）
 * @author: 田健
 * @date: 2017/10/20 11:52
 * @param inusreListCode
 * @return List<Object[]>
 */
@Query(value = "select sum(a.sumPremium) as sumpremium ,sum(a.fPremium) as fpremium,sum(a.centralPremium) as centralpremium,sum(a.provincePremium) as provincepremium,sum(a.cityPremium) as citypremium,sum(a.townPremium) as townpremium,sum(a.otherPremium) as otherpremium from NyxInsuranceList a where a.inusreListCode=:inusreListCode and a.validity='4' AND a.insureArea>0")
public List<Object[]> getSumFee(@Param("inusreListCode") String inusreListCode);

    /**
     * @param inusreListCode
     * @description:（根据inreListcode删除清单数据）
     * @author: 田健
     * @date: 2017/10/20 11:52
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "delete from NyxInsuranceList d where d.inusreListCode=:inusreListCode")
    public void removeByInusreListCode(@Param("inusreListCode") String inusreListCode);

    /**
     * @description:（根据inusreListcode汇总查询获取投保清单中总户数）
     * @author: 田健
     * @date: 2017/10/20 11:52
     * @param inusreListCode 清单号码
     * @return int 农户总数
     */
    @Query(value = "select count(distinct p.fCode) from NyxInsuranceList p where p.inusreListCode=:inusreListCode and p.validity='1' AND p.insureNumber>0")
    public int getSumInsured(@Param("inusreListCode") String inusreListCode);

      /**
     * 根据清单号关联查询标的清单下的所有农户及费用信息---种植险存NyxInsuranceList
     * @author: 田健
     * @date: 2018/3/2 17:06
     * @param insureListCode 清单号码
     * @param itemListCode 标的清单号
     * @return
     */
    @Query(value = "select new com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxInsuranceInfoDto( sum(a.fPremium) as " +
            "fPremium,sum(a.centralPremium) as centralPremium,sum(a.provincePremium) " +
            "as provincePremium ,sum(a.cityPremium) as cityPremium,sum(a.townPremium) as townPremium,sum(a.otherPremium) " +
            "as otherPremium,sum(a.insureArea) as insureArea,count(a.fCode) as iSumInsured) from NyxInsuranceList a where a.inusreListCode=:insureListCode and a.kindCode=:kindCode and a.validity=1 and a.itemCode=:itemCode and a.fCode in " +
            "(select b.fCode from GisFarmerItem b where b.insureListCode=:gisInsureListCode and b.serialNo=:serialNo and b.itemListCode=:itemListCode)")
    public NyxInsuranceInfoDto queryByConditioinForPlant(@Param("insureListCode") String insureListCode, @Param("itemListCode") String itemListCode, @Param("serialNo") Integer serialNo, @Param("gisInsureListCode") String gisInsureListCode,@Param("itemCode") String itemCode,@Param("kindCode") String kindCode);

    /**
     * 根据清单号关联查询标的清单下的所有农户及费用信息---种植险存NyxInsuranceList
     * @author: 田健
     * @date: 2018/3/2 17:06
     * @param insureListCode 清单号码
     * @param itemListCode 标的清单号
     * @return
     */
    @Query(value = "select new com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxInsuranceInfoDto( sum(a.fPremium) as " +
            "fPremium,sum(a.centralPremium) as centralPremium,sum(a.provincePremium) " +
            "as provincePremium ,sum(a.cityPremium) as cityPremium,sum(a.townPremium) as townPremium,sum(a.otherPremium) " +
            "as otherPremium,sum(a.insureNumber) as insureArea,count(a.fCode) as iSumInsured) from NyxInsuranceList a where a.inusreListCode=:insureListCode and a.validity=1 and a.kindCode=:kindCode and a.itemCode=:itemCode and a.fCode in " +
            "(select b.fCode from GisFarmerItem b where b.insureListCode=:gisInsureListCode and b.serialNo=:serialNo and b.itemListCode=:itemListCode)")
    public NyxInsuranceInfoDto queryByConditioinForHerd(@Param("insureListCode") String insureListCode, @Param("itemListCode") String itemListCode, @Param("serialNo") Integer serialNo, @Param("gisInsureListCode") String gisInsureListCode,@Param("itemCode") String itemCode,@Param("kindCode") String kindCode);

    /**
     * 根据清单号查询NyxInsuranceList信息集合
     * @author: 田健
     * @date: 2018/3/19 14:41
     * @param inusreListCode 清单编号
     * @return HerdInsuranceList信息集合
     */
    public List<NyxInsuranceList> findByInusreListCode(String inusreListCode);
}