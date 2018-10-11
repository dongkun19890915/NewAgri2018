package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxPolicyList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxPolicyListKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-30 07:53:53.940
 * 种植险保单清单最新数据1Dao数据操作对象
 */
@Repository
public interface NyxPolicyListDao extends JpaBaseDao<NyxPolicyList, NyxPolicyListKey> {

    @Query(value="select u from NyxPolicyList u where u.inusreListCode=:inusreListCode")
    List<NyxPolicyList> queryNyxByInsureListCode(@Param("inusreListCode") String inusreListCode);

    @Query(value=" select p from NyxPolicyList p where p.inusreListCode=:inusreListCode and p.itemCode=:itemCode and p.fCode=:fCode")
    List<NyxPolicyList> findNyxPolicyListByLossListCodeAndItemCode(@Param("inusreListCode") String inusreListCode,@Param("itemCode") String itemCode,@Param("fCode")String fCode);

    @Query(value = " select p from NyxPolicyList p where p.inusreListCode=:inusreListCode ")
    List<NyxPolicyList> findNyxPolicyListByLossListCodeAndItemCode1(@Param("inusreListCode") String inusreListCode);

    /**
     * 根据清单号查询NyxPolicyList信息集合
     * @author: 田健
     * @date: 2018/3/19 14:41
     * @param inusreListCode 清单编号
     * @return NyxPolicyList信息集合
     */
    public List<NyxPolicyList> findByInusreListCode(String inusreListCode);

    @Query("select count(distinct p.phone) from NyxPolicyList p where p.inusreListCode = :insureListCode and p.phone is not null")
    int findFarmerPhoneNumberCount(@Param("insureListCode")String insureListCode);
}