package com.sinosoft.agriclaim.core.docmanage.dao;

import com.sinosoft.agriclaim.core.docmanage.entity.PrpLCertifyCollect;
import com.sinosoft.agriclaim.core.docmanage.entity.PrpLCertifyCollectKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:41:23.407 
 * 单证收集表Dao数据操作对象
 */
@Repository
public interface PrpLCertifyCollectDao extends JpaBaseDao<PrpLCertifyCollect,PrpLCertifyCollectKey> {
    /**
     * @description:方法功能简述：通过业务号删除
     * @author 安齐崇
     * @date 2017年12月23日下午5:37:09
     * @param businessNo
     */
    @Modifying
    @Query("delete from PrpLCertifyCollect where businessNo =:businessNo")
    void deleteByBusinessNo(@Param("businessNo") String businessNo);
}