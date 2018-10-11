package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingEndorChgDetail;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingEndorChgDetailKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Map;
/**
*清单批改持久化接口
* @Author: 陈道洋
* @Date: 2017/11/17 10:27
*/
@Repository
public interface PlantingEndorChgDetailDao extends JpaBaseDao<PlantingEndorChgDetail,PlantingEndorChgDetailKey> {


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PlantingEndorChgDetail p WHERE p.endorseNo=:endorseNo")
    public void deleteInsureList(@Param("endorseNo") String endorseNo);


    /**
     * 根据批单号码查询planting的批改变化量清单
     *
     * @param endorseNo 批单号码
     * @return 分户清单批改变化量信息
     * @author: 何伟东
     * @date: 2018/1/19 9:41
     */
    List<PlantingEndorChgDetail> findByEndorseNo(String endorseNo);

}