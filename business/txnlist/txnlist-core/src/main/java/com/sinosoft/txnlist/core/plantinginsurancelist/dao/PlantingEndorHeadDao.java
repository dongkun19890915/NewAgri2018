package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingEndorHead;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingEndorHeadKey;
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
 * @time  2017-10-24 08:27:04.457 
 * PlantingEndorHeadDao数据操作对象
 */
@Repository
public interface PlantingEndorHeadDao extends JpaBaseDao<PlantingEndorHead,PlantingEndorHeadKey> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PlantingEndorHead p WHERE p.endorseNo=:endorseNo")
    public void deletePlantingEndorHead(@Param("endorseNo") String endorseNo);

    /**
     * 修改批改清单是否删除清单标志
     * @author: 何伟东
     * @date: 2017/12/11 16:00
     * @param endorseNo 批单号码
     * @param isDeleteFlag 是否删除标志
     */
    @Modifying
    @Query(value = "update PlantingEndorHead planting set planting.isDeleteFlag = :isDeleteFlag where planting.endorseNo = :endorseNo")
    int updateIsDeleteFlag(@Param(value = "endorseNo") String endorseNo,@Param(value = "isDeleteFlag") String isDeleteFlag);

}