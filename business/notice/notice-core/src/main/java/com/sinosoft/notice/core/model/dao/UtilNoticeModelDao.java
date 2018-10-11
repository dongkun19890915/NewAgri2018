package com.sinosoft.notice.core.model.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.notice.core.model.entity.UtilNoticeModel;
import com.sinosoft.notice.core.model.entity.UtilNoticeModelKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-30 07:15:42.402
 * 通知模板表Dao数据操作对象
 */
@Repository
public interface UtilNoticeModelDao extends JpaBaseDao<UtilNoticeModel, UtilNoticeModelKey> {
    UtilNoticeModel findByNoticeCodeAndDeleteFlag(String noticeCode, String deleteFlag);

    Page<UtilNoticeModel> findByNoticeNameContainingAndDeleteFlag(Pageable pageable, String noticeName, String deleteFlag);


    Page<UtilNoticeModel> findByNoticeCodeAndDeleteFlag(Pageable pageable, String noticeCode, String deleteFlag);


    Page<UtilNoticeModel> findByDeleteFlag(Pageable pageable, String deleteOn);

    Page<UtilNoticeModel> findByModelCreatedByAndDeleteFlag(Pageable pageable, String modelCreated, String deleteFlag);


    /**
     * @param noticeCodes
     * @author: 潘峰
     * @date: 2017/11/10 10:26
     */
    @Modifying
    @Query(value = "update UtilNoticeModel p set p.deleteFlag='0' where noticeCode in(:noticeCodes)")
    void deleteList(@Param("noticeCodes") List<String> noticeCodes);

}