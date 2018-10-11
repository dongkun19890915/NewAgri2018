package com.sinosoft.txnlist.core.claiminsurancelist.dao;

import com.sinosoft.txnlist.core.claiminsurancelist.entity.LossRateList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.LossRateListKey;
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
 * @time  2017-12-26 08:50:16.862 
 * 理赔清单信息主表Dao数据操作对象
 */
@Repository
public interface LossRateListDao extends JpaBaseDao<LossRateList,LossRateListKey> {
    /**
     * 按保单号、报案号查询实体集合
     * @param policyNo 保单号
     * @param registNo 报案号
     * @return List<LossRateList>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-25
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "select pl from LossRateList pl where pl.policyNo=:policyNo and " +
            "(pl.registNo is null or pl.registNo='' or pl.registNo=:registNo)")
    public List<LossRateList> queryByConditions(@Param(value = "policyNo") String policyNo, @Param(value = "registNo") String registNo);
    /**
     * 关联报案号和清单信息
     * @param listNo 损失率清单号
     * @param registNo 报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update LossRateList pl set pl.registNo=:registNo where pl.listNo=:listNo")
    public void compareInsurance(@Param(value = "listNo") String listNo, @Param(value = "registNo") String registNo);

    /**
     * 按条件查询已关联实体集合
     * @param policyNo 保单号
     * @param registNo 报案号
     * @return List<LossRateList>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-26
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "select pl from LossRateList pl where pl.policyNo=:policyNo and pl.registNo=:registNo")
    public List<LossRateList> queryComparable(@Param(value = "policyNo") String policyNo, @Param(value = "registNo") String registNo);

}