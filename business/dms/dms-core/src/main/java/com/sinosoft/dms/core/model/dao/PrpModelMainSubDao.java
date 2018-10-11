package com.sinosoft.dms.core.model.dao;

import com.sinosoft.dms.core.model.entity.PrpModelMainSub;
import com.sinosoft.dms.core.model.entity.PrpModelMainSubKey;
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
 * @time  2017-11-13 11:42:08.278 
 * 保单基本信息表Dao数据操作对象
 */
@Repository
public interface PrpModelMainSubDao extends JpaBaseDao<PrpModelMainSub,PrpModelMainSubKey> {
    /**
     *  根据模板代码删除保单基本信息表信息
     * @author: 田慧
     * @date: 2017/11/14 15:16
     * @param modelCodeList  模板代码集合
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "delete from PrpModelMainAgriSub pp where pp.modelCode in(:modelCodeList)")
    public void deleteByModelCodeList(@Param("modelCodeList") List<String> modelCodeList);
}