package com.sinosoft.txnlist.core.claiminsurancelist.dao;

import com.sinosoft.txnlist.core.claiminsurancelist.entity.NyxPlantingClaimList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.NyxPlantingClaimListKey;
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
 * 种植险理赔清单信息表Dao数据操作对象
 */
@Repository
public interface NyxPlantingClaimListDao extends JpaBaseDao<NyxPlantingClaimList,NyxPlantingClaimListKey> {

    /**
     * （判断损失率是否全部相同）
     * @author: 王志文
     * @date: 2017/12/29 19:59
     * @param billNo 清单号
     * @return
     */
    @Query("select n.lossRate from NyxPlantingClaimList n where n.listNo =:billNo group by n.lossRate")
    List<Double> getLossRateGroupCountByBillNo(@Param("billNo") String billNo);

    /**
     * （判断赔付比例是否全部相同）
     * @author: 王志文
     * @date: 2018/3/22 9:55
     * @param billNo
     * @return
     */
    @Query("select n.claimRate from NyxPlantingClaimList n where n.listNo =:billNo group by n.claimRate")
    List<Double> getClaimRateGroupCountByBillNo(@Param("billNo") String billNo);

    /**
     * （判断标的是否全部相同）
     * @author: 王志文
     * @date: 2018/3/22 9:55
     * @param billNo
     * @return
     */
    @Query("select n.itemCode from NyxPlantingClaimList n where n.listNo =:billNo group by n.itemCode")
    List<String> getItemCodeCountByBillNo(@Param("billNo") String billNo);

    /**
     * （判断理算环节是否已导入理赔清单）
     * @author: 王志文
     * @date: 2018/3/22 9:55
     * @param billNo
     * @return
     */
    @Query("select count(n) from NyxPlantingClaimList n where n.listNo =:billNo and n.nodeType='compe'")
    Integer checkCompeNodeType(@Param("billNo") String billNo);

    @Transactional
    @Modifying
    @Query("delete from NyxPlantingClaimList where registNo=:registNo and nodeType =:nodeType")
    public void deleteNyxPlantingClaimListByRegistNo(@Param("registNo") String registNo,@Param("nodeType")String nodeType);

    /**
     * （按报案号和计算书号删除理赔清单历史数据）
     * @author: 王志文
     * @date: 2018/4/16 11:35
     * @param registNo
     * @param compensateNo
     * @param nodeType
     */
    @Modifying
    @Query("delete from NyxPlantingClaimList where registNo=:registNo and compensateNo=:compensateNo and nodeType =:nodeType")
    public void deleteNyxPlantingClaimListByRegistNoAndCompensateNoAndNodeType(@Param("registNo") String registNo,@Param("compensateNo")String compensateNo,@Param("nodeType")String nodeType);

    @Query("select n from NyxPlantingClaimList n where n.registNo=:registNo and n.nodeType =:nodeType")
    List<NyxPlantingClaimList> queryAllByRegistNoAndNodeType(@Param("registNo") String registNo,@Param("nodeType")String nodeType);
    @Transactional
    @Modifying
    @Query("update NyxPlantingClaimList n set n.claimNo=:claimNo where n.registNo=:registNo and n.listNo=:listNo")
    void saveclaimNo(@Param("listNo") String listNo,@Param("registNo")String registNo,@Param("claimNo")String claimNo);

    /**
     * （计算过程时判断时候手动输入了金额，获取表中金额）
     * @author: 王志文
     * @date: 2018/5/4 14:57
     * @param listNo
     * @param nodeType
     * @return
     */
    @Query(value = "select sum(n.settleAmount) from NyxPlantingClaimList n where n.listNo =:listNo and n.nodeType =:nodeType")
    Double querySumSettleAmountByListNoAndNodeType(@Param("listNo") String listNo,@Param("nodeType") String nodeType);
}