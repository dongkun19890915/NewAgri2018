package com.sinosoft.dms.core.model.dao;

import com.sinosoft.dms.api.model.dto.PrpModelInsuredSubDto;
import com.sinosoft.dms.core.model.entity.PrpModelInsuredSub;
import com.sinosoft.dms.core.model.entity.PrpModelInsuredSubKey;
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
 * 模板保险关系人表Dao数据操作对象
 */
@Repository
public interface PrpModelInsuredSubDao extends JpaBaseDao<PrpModelInsuredSub,PrpModelInsuredSubKey> {

    /**
     *  根据模板代码删除模板保险关系人表信息
     * @author: 田慧
     * @date: 2017/11/14 15:14
     * @param modelCodeList 模板代码集合
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "delete from PrpModelInsuredSub pp where pp.modelCode in(:modelCodeList)")
    public void deleteByModelCodeList(@Param("modelCodeList") List<String> modelCodeList);

    /**
     *  根据模板代码查询模板保险关系人表信息
     * @author: 田慧
     * @date: 2017/11/15 9:55
     * @param modelCode 模板代码
     * @return
     */
//    @Query(value = "select p from PrpModelInsuredSub p where p.modelCode=:modelCode")
//    public  List<PrpModelInsuredSub> queryPrpMmodelMainByHyperLink(@Param("modelCode") String modelCode);

    public  List<PrpModelInsuredSub> findByModelCode(String modelCode);
}