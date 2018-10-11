package com.sinosoft.txnlist.core.claiminsurancelist.dao;

import com.sinosoft.txnlist.core.claiminsurancelist.entity.NyxBreedClaimList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.NyxBreedClaimListKey;
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
 * @time  2017-12-26 03:26:32.072 
 * 养殖险理赔清单信息表Dao数据操作对象
 */
@Repository
public interface NyxBreedClaimListDao extends JpaBaseDao<NyxBreedClaimList,NyxBreedClaimListKey> {
    @Transactional
    @Modifying
    @Query("update NyxBreedClaimList n set n.claimNo=:claimNo where n.registNo=:registNo and n.listNo=:listNo")
    void saveclaimNo(@Param("listNo") String listNo,@Param("registNo")String registNo,@Param("claimNo")String claimNo);
    @Modifying
    @Query("delete from NyxBreedClaimList where registNo=:registNo and compensateNo=:compensateNo and nodeType =:nodeType")
    public void deleteNyxBreedClaimListByRegistNoandAndCompensateNo(@Param("registNo") String registNo,@Param("compensateNo")String compensateNo,@Param("nodeType")String nodeType);

    @Transactional
    @Modifying
    @Query("delete from NyxBreedClaimList where registNo=:registNo and nodeType =:nodeType")
    public void deleteNyxPlantingClaimListByRegistNo(@Param("registNo") String registNo,@Param("nodeType")String nodeType);

    /**
     * （查询清单号下养殖标的死亡数量）
     * @author: 王志文
     * @date: 2018/4/26 20:49
     * @param listNo
     * @return
     */
    @Query(value = "select count(n.earConNo) from NyxBreedClaimList n where n.listNo =:listNo and n.nodeType='compe' group by n.fCode")
    public List<Long> queryCountEarNoByListNo(@Param("listNo") String listNo);

    /**
     * （判断标的是否全部相同）
     * @author: 王志文
     * @date: 2018/3/22 9:55
     * @param listNo
     * @return
     */
    @Query("select n.itemCode from NyxBreedClaimList n where n.listNo =:listNo group by n.itemCode")
    List<String> getItemCodeCountByBillNo(@Param("listNo") String listNo);

    /**
     * （判断理算环节是否已导入理赔清单）
     * @author: 王志文
     * @date: 2018/3/22 9:55
     * @param listNo
     * @return
     */
    @Query("select count(n) from NyxBreedClaimList n where n.listNo =:listNo and n.nodeType='compe'")
    Integer checkCompeNodeType(@Param("listNo") String listNo);

    /**
     * （求扣除金额的总和）
     * @author: 王志文
     * @date: 2018/3/22 9:55
     * @param listNo
     * @return
     */
    @Query(value = "select n.deductionAmount from NyxBreedClaimList n where n.listNo =:listNo")
    List<Double> queryDeductionAmountSum(@Param("listNo") String listNo);

    /**
     * 根据清单号更新理算书号
     * @author: 孙朋飞
     * @date: 2018/5/14 19:10
     * @param listNo 清单号
     * @param compensateNo 理算书号
     */
    @Modifying
    @Transactional
    @Query(value = "update NyxBreedClaimList set compensateNo=:compensateNo where listNo=:listNo")
    void updateNyxBreedClaimListByListNo(@Param("listNo") String listNo,@Param("compensateNo") String compensateNo);
    /**
     * （根据立案号查立案信息）
     * @author: 陈道洋
     * @date: 2018/3/22 9:55
     * @param listNo
     * @return
     */
    @Query(value = "select  n  from NyxBreedClaimList n where n.claimNo in(:list)")
    List<NyxBreedClaimList> queryByClaimNo(@Param("list") List list);

    /**
     * （计算过程时判断时候手动输入了金额，获取表中金额）
     * @author: 王志文
     * @date: 2018/5/4 14:57
     * @param listNo
     * @param nodeType
     * @return
     */
    @Query(value = "select sum(n.payAmount) from NyxBreedClaimList n where n.listNo =:listNo and n.nodeType =:nodeType")
    Double querySumSettleAmountByListNoAndNodeType(@Param("listNo") String listNo,@Param("nodeType") String nodeType);
}