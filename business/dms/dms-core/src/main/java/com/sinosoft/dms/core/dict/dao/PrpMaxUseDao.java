package com.sinosoft.dms.core.dict.dao;

import com.sinosoft.dms.core.dict.entity.PrpMaxUse;
import com.sinosoft.dms.core.dict.entity.PrpMaxUseKey;
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
 * @time  2017-11-05 01:02:29.563 
 * PrpMaxUseDao数据操作对象
 */
@Repository
public interface PrpMaxUseDao extends JpaBaseDao<PrpMaxUse,PrpMaxUseKey> {

    /**
     * @author 王保良
     * @time  2017-10-11
     * @description 根据groupNo,tableName,maxNo删除PrpMaxUse表相关数据
     */
    @Modifying
    @Transactional
    @Query(value = "delete from PrpMaxUse p where p.groupNo=:groupNo and p.tableName=:tableName and p.maxNo=:maxNo")
    public void deleteByCondition(@Param("groupNo") String groupNo, @Param("tableName") String tableName, @Param("maxNo") String maxNo);
}