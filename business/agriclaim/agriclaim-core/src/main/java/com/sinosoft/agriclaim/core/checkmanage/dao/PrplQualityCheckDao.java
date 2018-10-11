package com.sinosoft.agriclaim.core.checkmanage.dao;

import com.sinosoft.agriclaim.core.checkmanage.entity.PrplQualityCheck;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrplQualityCheckKey;
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
 * @time  2017-11-10 02:44:49.773 
 * 质量评审内容表Dao数据操作对象
 */
@Repository
public interface PrplQualityCheckDao extends JpaBaseDao<PrplQualityCheck,PrplQualityCheckKey> {
    /**
     * @description:方法功能简述：通过业务号删除
     * @author 安齐崇
     * @date 2017年12月23日下午5:37:09
     * @param businessNo
     */
    @Modifying
    @Query("delete from PrplQualityCheck where registNo =:registNo")
    void deleteByRegistNo(@Param("registNo") String registNo);
}