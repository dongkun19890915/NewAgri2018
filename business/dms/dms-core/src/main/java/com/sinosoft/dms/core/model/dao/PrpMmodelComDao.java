package com.sinosoft.dms.core.model.dao;

import com.sinosoft.dms.core.model.entity.PrpMmodelCom;
import com.sinosoft.dms.core.model.entity.PrpMmodelComKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-07 03:35:35.009
 * 模板机构配置表Dao数据操作对象
 */
@Repository
public interface PrpMmodelComDao extends JpaBaseDao<PrpMmodelCom, PrpMmodelComKey> {

//    @Query(value="select a.modelcode from PrpmModelCom a where a.comcode=:comcode ")
//    public List<PrpMmodelCom> queryCodeListByComcode(@Param("comcode") String comcode);

//   public List<PrpMmodelCom> findByComCode(@Param("comCode") String comCode);

    /**
     * 根据机构代码和模板代码模糊查询模板机构配置表信息
     *
     * @author: 田慧
     * @date: 2017/11/16 12:02
     */
    @Query(value = "select p from PrpMmodelCom p where p.modelCode like:modelCode  and  p.comCode=:comCode")
    public List<PrpMmodelCom> findByComCodeModelCode(@Param("modelCode") String modelCode, @Param("comCode") String comCode);

    /**
     * 根据模板代码删除模板机构配置表信息
     *
     * @param modelCodeList 模板代码集合
     * @author: 田慧
     * @date: 2017/11/14 15:06
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "delete from PrpMmodelCom pp where pp.modelCode in(:modelCodeList)")
    public void deleteByModelCodeList(@Param("modelCodeList") List<String> modelCodeList);

    /**
     * 根据模板代码查询模板机构配置表信息
     *
     * @param modelCode 模板代码
     * @return
     * @author: 田慧
     * @date: 2017/11/15 9:57
     */
    List<PrpMmodelCom> findByModelCode(String modelCode);

    @Modifying
    @Query(value = "delete from PrpMmodelCom pp where pp.modelCode=:modelCode")
    void deleteByModelCode(@Param("modelCode") String modelCode);

    List<PrpMmodelCom> findByComCodeAndFlag(String comCode, String flag);
}














