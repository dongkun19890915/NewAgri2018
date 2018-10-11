package com.sinosoft.txnlist.core.gisinsurelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.gisinsurelist.entity.GisFieldList;
import com.sinosoft.txnlist.core.gisinsurelist.entity.GisFieldListKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 投保预确认农户田块清单表Dao数据操作对象
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:31
 */
@Repository
public interface GisFieldListDao extends JpaBaseDao<GisFieldList, GisFieldListKey> {

    @Query(value = "select p from GisFieldList p where p.insureListCode=?1 and p.serialNo=?2")
    public List<GisFieldList> findGisFieldListByCondition(String insureListCode,Integer serialNo);

    @Query(value = "select p from GisFieldList p where p.insureListCode=:insureListCode and p.serialNo=:serialNo and p.fCode=:fCode")
    public List<GisFieldList> queryByCondition(@Param("insureListCode")String insureListCode,@Param("serialNo") Integer serialNo,@Param("fCode") String fCode);
    /**
     *  根据清单号、序列号、农户代码查询田块信息条数
     * @author: 田健
     * @date: 2018/3/1 16:00
     * @param insureListCode 清单号
     * @param serialNo 序列号
     * @param fCode 农户代码
     * @return GisHerdFieldList耳标号信息集合
     */
    @Query(value = "select count(p) from GisFieldList p where p.insureListCode=:insureListCode and p.serialNo=:serialNo and p.fCode=:fCode")
    public Long queryCountByCondition(@Param("insureListCode")String insureListCode,@Param("serialNo") Integer serialNo,@Param("fCode") String fCode);
}