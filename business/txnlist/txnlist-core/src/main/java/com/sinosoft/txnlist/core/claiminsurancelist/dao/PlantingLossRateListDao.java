package com.sinosoft.txnlist.core.claiminsurancelist.dao;

import com.sinosoft.txnlist.api.claiminsurancelist.dto.PlantingLossRateListDto;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.PlantingLossRateList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.PlantingLossRateListKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 01:34:50.838 
 * 定损清单信息表Dao数据操作对象
 */
@Repository
public interface PlantingLossRateListDao extends JpaBaseDao<PlantingLossRateList,PlantingLossRateListKey> {


    /**
     * 关联报案号和清单信息
     * @param listNo 损失率清单号
     * @param registNo 报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update PlantingLossRateList pl set pl.registNo=:registNo where pl.listNo=:listNo")
    public void compareInsurance(@Param(value = "listNo") String listNo, @Param(value = "registNo") String registNo);

    /**
     * 按条件查询已关联实体集合
     * @param policyNo 保单号
     * @param registNo 报案号
     * @return List<PlantingLossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-26
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "select pl from PlantingLossRateList pl where pl.policyNo=:policyNo and pl.registNo=:registNo")
    List<PlantingLossRateList> queryComparable(@Param(value = "policyNo") String policyNo, @Param(value = "registNo") String registNo);

    /**
     * 查询种植险定损清单
     * @author: 祁小龙
     * @date: 2017/12/29 20:11
     * @param registNo 报案号
     * @return List<PlantingLossRateList> 定损清单集合
     * @throws Exception
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "select pl from PlantingLossRateList pl where  pl.registNo=:registNo")
    List<PlantingLossRateList> queryPlantingLossRateListByRegistNo(@Param(value = "registNo") String registNo);


}