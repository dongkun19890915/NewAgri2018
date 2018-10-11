package com.sinosoft.notice.core.model.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.notice.core.model.entity.HisUtilNoticeModel;
import com.sinosoft.notice.core.model.entity.HisUtilNoticeModelKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-30 07:15:42.402
 * 通知模板表Dao数据操作对象
 */
@Repository
public interface HisUtilNoticeModelDao extends JpaBaseDao<HisUtilNoticeModel, HisUtilNoticeModelKey> {

    @Query("select COALESCE(max(h.serialNo),'0') from HisUtilNoticeModel h where h.noticeCode =:noticeCode")
    Integer serialNoMax(@Param("noticeCode") String noticeCode);

}