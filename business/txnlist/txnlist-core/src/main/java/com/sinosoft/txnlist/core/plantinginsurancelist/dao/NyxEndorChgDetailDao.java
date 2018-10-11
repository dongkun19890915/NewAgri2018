package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxEndorChgDetail;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxEndorChgDetailKey;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-18 08:36:26.740
 * nyxendorchgdetailDao数据操作对象
 */
@Repository
public interface NyxEndorChgDetailDao extends JpaBaseDao<NyxEndorChgDetail, NyxEndorChgDetailKey> {

    /**
     * 根据批单号码、农户代码查询批改过的农户总数
     *
     * @param endorseNo 批单号码
     * @return 总数量
     * @author: 何伟东
     * @date: 2017/12/23 14:53
     */
    @Query("select n from  NyxEndorChgDetail n where n.endorseNo = :endorseNo and n.chgSumPremium < 0 ")
    List<NyxEndorChgDetail> getFarmerInfo(@Param(value = "endorseNo") String endorseNo);

    @Query(value = "delete from NyxEndorChgDetail n where n.endorseNo=?1")
    @Modifying
    @Transactional
    public void removeByEnodrseNo(String endorseNo)throws Exception;

    /**
     * 根据批单号码查询planting的批改变化量清单
     *
     * @param endorseNo 批单号码
     * @return 分户清单批改变化量信息
     * @author: 何伟东
     * @date: 2018/1/19 9:41
     */
    List<NyxEndorChgDetail> findByEndorseNo(String endorseNo);
}