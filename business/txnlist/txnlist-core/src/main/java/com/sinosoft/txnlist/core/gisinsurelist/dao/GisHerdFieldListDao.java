package com.sinosoft.txnlist.core.gisinsurelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.gisinsurelist.entity.GisHerdFieldList;
import com.sinosoft.txnlist.core.gisinsurelist.entity.GisHerdFieldListKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * 预投保清单农户标的清单明细表（物）Dao数据操作对象
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:31
 */
@Repository
public interface GisHerdFieldListDao extends JpaBaseDao<GisHerdFieldList, GisHerdFieldListKey> {


    @Query("select count(p) from GisHerdFieldList p where p.serialNo='1' and p.insureListCode =:insureListCode ")
    int getCountByInsureListCode(@Param("insureListCode") String insureListCode);

    @Query(value = "select p from GisHerdFieldList p where p.insureListCode=?1 and p.serialNo=?2")
    public List<GisHerdFieldList> findGisHerdFieldListByCondition(String insureListCode, Integer serialNo);

    /**
     *  根据清单号、序列号、农户代码查询耳标号信息
     * @author: 田健
     * @date: 2018/3/1 16:00
     * @param insureListCode 清单号
     * @param serialNo 序列号
     * @param fCodeList 农户代码集合
     * @return GisHerdFieldList耳标号信息集合
     */
    @Query(value = "select p from GisHerdFieldList p where p.insureListCode=?1 and p.serialNo=?2 and p.fCode in (?3)")
    public List<GisHerdFieldList> findGisHerdFieldListByInsureListCodeAndSerialNoAndFCode(String insureListCode, Integer serialNo,List<String> fCodeList);

    /**
     *  根据清单号、序列号、农户代码查询耳标号信息条数
     * @author: 田健
     * @date: 2018/3/1 16:00
     * @param insureListCode 清单号
     * @param serialNo 序列号
     * @param fCodeList 农户代码集合
     * @return GisHerdFieldList耳标号信息集合
     */
    @Query(value = "select count(p) from GisHerdFieldList p where p.insureListCode=?1 and p.serialNo=?2 and p.fCode in (?3)")
    public Long findCountByInsureListCodeAndSerialNoAndFCode(String insureListCode, Integer serialNo,List<String> fCodeList);

    /**
     *  根据清单号、序列号、农户代码查询耳标号信息
     * @author: 田健
     * @date: 2018/3/1 16:00
     * @param insureListCode 清单号
     * @param serialNo 序列号
     * @param fCodeList 农户代码集合
     * @return GisHerdFieldList耳标号信息集合
     */
    @Query(value = "select p from GisHerdFieldList p where p.insureListCode=?1 and p.serialNo=?2 and p.fCode in (?3)")
    public List<GisHerdFieldList> findGisHerdFieldListByInsureListCodeAndSerialNoAndFCode(String insureListCode, Integer serialNo,Set<String> fCodeList);
}