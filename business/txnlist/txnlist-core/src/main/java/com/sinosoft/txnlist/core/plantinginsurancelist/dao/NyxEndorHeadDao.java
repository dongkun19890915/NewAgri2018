package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxEndorHead;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxEndorHeadKey;
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
 * nyxendorheadDao数据操作对象
 */
@Repository
public interface NyxEndorHeadDao extends JpaBaseDao<NyxEndorHead,NyxEndorHeadKey> {

    /**
     * 修改批改清单是否删除清单标志
     * @author: 何伟东
     * @date: 2017/12/11 16:00
     * @param endorseNo 批单号码
     * @param isDeleteFlag 是否删除标志
     */
    @Modifying
    @Query(value = "update NyxEndorHead nyx set nyx.isDeleteFlag = :isDeleteFlag where nyx.endorseNo = :endorseNo")
    public int updateIsDeleteFlag(@Param(value = "endorseNo") String endorseNo,@Param(value = "isDeleteFlag") String isDeleteFlag);
    @Query(value = "delete from NyxEndorHead n where n.endorseNo=?1")
    @Modifying
    @Transactional
    public void removeByEndorseNo(String endorseNo)throws Exception;
}