package com.sinosoft.txnlist.core.gisinsurelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.gisinsurelist.entity.GisManFieldList;
import com.sinosoft.txnlist.core.gisinsurelist.entity.GisManFieldListKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 预投保清单农户标的清单明细表（人）Dao数据操作对象
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:32
 */
@Repository
public interface GisManFieldListDao extends JpaBaseDao<GisManFieldList, GisManFieldListKey> {


    @Query("select count(p) from GisManFieldList p where p.serialNo='1' and p.insureListCode =:insureListCode ")
    int getCount(@Param("insureListCode") String insureListCode);

    @Query("select p from GisManFieldList p where  p.insureListCode =:insureListCode  and p.serialNo=:serialNo")
    List<GisManFieldList> queryByFind(@Param("insureListCode") String insureListCode, @Param("serialNo") Integer serialNo);

}