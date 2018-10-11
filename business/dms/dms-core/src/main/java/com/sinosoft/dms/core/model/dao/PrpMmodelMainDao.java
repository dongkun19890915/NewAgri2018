package com.sinosoft.dms.core.model.dao;

import com.sinosoft.dms.core.model.entity.PrpMmodelMain;
import com.sinosoft.dms.core.model.entity.PrpMmodelMainKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:35:35.009 
 * 模板配置主表Dao数据操作对象
 */
@Repository
public interface PrpMmodelMainDao extends JpaBaseDao<PrpMmodelMain,PrpMmodelMainKey> {

    /**
     * 根据模板代码删除模板配置主表信息
     *
     * @param modelCodeList 模板代码集合
     * @author: 田慧
     * @date: 2017/11/12 11:11
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "delete from PrpMmodelMain pp where pp.modelCode in(:modelCodeList)")
    public void deleteByModelCodeList(@Param("modelCodeList") List<String> modelCodeList);

    /**
     *  根据模板代码查询PrpMmodelMain 模板配置主表信息
     * @author: 田慧
     * @date: 2017/11/29 17:13
     * @param modelCodeList 模板代码集合
     * @return PrpMmodelMain 模板配置主表的集合
     */
//    @Query(value = "select p from PrpMmodelMain p where p.modelCode in(:modelCodeList)")
//    public List<PrpMmodelMain> queryBymodelCode(@Param("modelCodeList") List<String> modelCodeList);

    /**
     *  根据模板代码更新PrpMmodelMain 模板配置主表信息,PrpMmodelMain 模板配置主表的flag 置为0 表示该模板被删除。
     * @author: 田慧
     * @date: 2017/11/29 18:04
     * @param modelCodeList 模板代码集合
     */
    @Modifying
    @Transactional
    @Query(value = "update  PrpMmodelMain p set p.logicdelete=0 where p.modelCode in (:modelCodeList)")
     public void   modifyByModelCode(@Param("modelCodeList") List<String> modelCodeList);

    /**
     * * （查询模板配置主表信息）
     * @author: 田慧
     * @date: 10:38
     * @param modelCode 模板代码
     * @param date 当前日期
     * @return PrpMmodelMain
     */
    @Query(value = "select c from PrpMmodelMain c where c.validStatus='1' and c.logicdelete='1' and c.modelCode=:modelCode and c.startDate <= :date and c.endDate >= :date and c.flag='1'")
    PrpMmodelMain getPrpmmodelmainInfo(@Param("modelCode") String modelCode, @Param("date") Date date);


}