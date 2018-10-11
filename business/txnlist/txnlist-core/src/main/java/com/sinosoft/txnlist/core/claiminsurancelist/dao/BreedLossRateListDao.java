package com.sinosoft.txnlist.core.claiminsurancelist.dao;

import com.sinosoft.txnlist.api.claiminsurancelist.dto.BreedLossRateListDto;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.BreedLossRateList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.BreedLossRateListKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 06:26:52.496 
 * 养殖险定损清单信息表Dao数据操作对象
 */
@Repository
public interface BreedLossRateListDao extends JpaBaseDao<BreedLossRateList,BreedLossRateListKey> {


    /**
     * 关联报案号和清单信息
     * @param listNo 损失率清单号
     * @param registNo 报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update BreedLossRateList pl set pl.registNo=:registNo where pl.listNo=:listNo")
    public void compareInsurance(@Param(value = "listNo") String listNo, @Param(value = "registNo") String registNo);

    /**
     * 按条件查询已关联实体集合
     * @param policyNo 保单号
     * @param registNo 报案号
     * @return List<BreedLossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-26
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "select pl from BreedLossRateList pl where pl.policyNo=:policyNo and pl.registNo=:registNo")
    public List<BreedLossRateList> queryComparable(@Param(value = "policyNo") String policyNo, @Param(value = "registNo") String registNo);

    @Query(value = "select p from BreedLossRateList p where registNo=:registNo")
    public List<BreedLossRateList> findBreedLossRateListByRegistNo(@Param("registNo") String registNo);
    /**
     * 根据定损清单号删除养植险定损清单
     * @author: 杨璐
     * @date: 2017/01/22
     * @param map清单号
     * @return 种植险定损清单集合
     * @throws Exception
     */
    @Modifying
    @Transactional
    @Query("DELETE from BreedLossRateList where listNo=?1")
    int deleteByListNo(String listNo);
}