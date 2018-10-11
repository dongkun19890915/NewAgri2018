package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingPolicyList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingPolicyListKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-30 07:53:53.940
 * 投保明细最新数据表3Dao数据操作对象
 */
@Repository
public interface PlantingPolicyListDao extends JpaBaseDao<PlantingPolicyList, PlantingPolicyListKey> {


    List<PlantingPolicyList> findByInusreListCode(String inusreListCode);


    /**
     *  根据GIS清单号查询承保清单 种植险
     * @param gisInsureListCode
     * @return
     * @throws Exception
     * @author 汪强
     */
    @Query("select p from PlantingPolicyList p where p.inusreListCode in (select c.inusreListCode from InsureMainList c where c.gisInsureListCode=:gisInsureListCode and c.classCode='31')")
    List<PlantingPolicyList> queryByGisInsureListCode(@Param("gisInsureListCode")String gisInsureListCode);

    @Query("SELECT p.insureArea FROM  PlantingPolicyList p WHERE p.inusreListCode=:inuserlistcode and p.fCode=:fCode")
    Double findInsureAreaByInusreListCodeAndfcode(@Param("inuserlistcode") String inusreListCodeByPolicyNo,@Param("fCode") String fCode);

    @Query("SELECT p FROM  PlantingPolicyList p WHERE p.inusreListCode=:inuserlistcode and p.fCode=:fCode and p.itemCode=:itemCode")
    PlantingPolicyList findInsureAreaByInusreListCodeAndfcode1(@Param("inuserlistcode") String inusreListCodeByPolicyNo,@Param("fCode") String fCode,@Param("itemCode")String itemCode);


    @Query("SELECT p FROM  PlantingPolicyList p WHERE p.inusreListCode=:inuserlistcode ")
    List<PlantingPolicyList> findInsureAreaByInusreListCodeAndfcode2(@Param("inuserlistcode") String inusreListCodeByPolicyNo);


    @Query("select count(distinct p.phone) from PlantingPolicyList p where p.inusreListCode = :insureListCode and p.phone is not null")
    int findFarmerPhoneNumberCount(@Param("insureListCode")String insureListCode);

    @Query(value = "select p from PlantingPolicyList p where p.inusreListCode=:inusreListCode")
    List<PlantingPolicyList> queryByInusreListCode(@Param("inusreListCode") String inusreListCode);

}