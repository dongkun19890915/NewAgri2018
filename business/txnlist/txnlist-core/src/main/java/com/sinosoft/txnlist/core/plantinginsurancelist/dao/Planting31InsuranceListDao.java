package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.api.gisinsurelist.dto.InsuranceInfoDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.Planting31InsuranceList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.Planting31InsuranceListKey;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-16 03:27:26.178
 * 投保明细表Dao数据操作对象
 */
@Repository
public interface Planting31InsuranceListDao extends JpaBaseDao<Planting31InsuranceList, Planting31InsuranceListKey> {
    /**
     * 根据清单号查询Planting31InsuranceList信息集合
     * @author: 田健
     * @date: 2018/3/19 14:41
     * @param inusreListCode 清单编号
     * @return Planting31InsuranceList信息集合
     */
    List<Planting31InsuranceList> findByInusreListCode(String inusreListCode);

    /**
     * @description:（根据inreListcode删除清单数据）
     * @author: 田健
     * @date: 2017/10/20 11:52
     * @param inusreListCode
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "delete from Planting31InsuranceList d where d.inusreListCode=:inusreListCode")
    public void removeByInusreListCode(@Param("inusreListCode") String inusreListCode);
    /**
     * @description:（根据inusreListcode汇总查询获取投保清单中总户数）
     * @author: 田健
     * @date: 2017/10/20 11:52
     * @param inusreListCode
     * @return int
     */
    @Query(value = "select count(distinct p.fCode) from Planting31InsuranceList p where inusreListCode=:inusreListCode and validity='1' AND insureArea>0")
    public int getSumInsured(@Param("inusreListCode") String inusreListCode);


    @Query(value = "select new com.sinosoft.txnlist.api.gisinsurelist.dto.InsuranceInfoDto( sum(a.fPremium) as fPremium,sum(a.centralPremium) as centralPremium,sum(a.provincePremium)" +
            " as provincePremium ,sum(a.cityPremium) as cityPremium,sum(a.townPremium) as townPremium,sum(a.otherPremium) as otherPremium,sum(a.insureArea) as insureArea,count(a.fCode)" +
            " as iSumInsured) from Planting31InsuranceList a where a.inusreListCode=:insureListCode and a.itemCode=:itemCode and a.kindCode=:kindCode and a.validity='1' and a.fCode in " +
            "(select b.fCode from GisFarmerItem b where b.insureListCode=:gisInsureListCode and b.serialNo=:serialNo and b.itemListCode=:itemListCode)")
    public InsuranceInfoDto queryByConditioin(@Param("insureListCode") String insureListCode,@Param("kindCode")String kindCode,@Param("itemCode") String itemCode,@Param("gisInsureListCode")String gisInsureListCode,@Param("serialNo") Integer serialNo,@Param("itemListCode") String itemListCode);
}