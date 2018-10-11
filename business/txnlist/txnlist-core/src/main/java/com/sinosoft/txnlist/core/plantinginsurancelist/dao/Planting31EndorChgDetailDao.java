package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.txnlist.core.plantinginsurancelist.entity.Planting31EndorChgDetail;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.Planting31EndorChgDetailKey;
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
 * @time  2017-11-18 08:36:26.740 
 * planting31endorchgdetailDao数据操作对象
 */
@Repository
public interface Planting31EndorChgDetailDao extends JpaBaseDao<Planting31EndorChgDetail,Planting31EndorChgDetailKey> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Planting31EndorChgDetail p WHERE p.endorseNo=:endorseNo")
    public void deletePlanting31EndorChgDetail(@Param("endorseNo") String endorseNo);
    /**
     * 根据批单号码查询planting的批改变化量清单
     *
     * @param endorseNo 批单号码
     * @return 分户清单批改变化量信息
     * @author: 何伟东
     * @date: 2018/1/19 9:41
     */
    List<Planting31EndorChgDetail> findByEndorseNo(String endorseNo);
}