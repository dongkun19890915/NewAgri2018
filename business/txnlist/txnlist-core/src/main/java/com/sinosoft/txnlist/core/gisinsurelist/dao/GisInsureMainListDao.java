package com.sinosoft.txnlist.core.gisinsurelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.gisinsurelist.entity.GisInsureMainList;
import com.sinosoft.txnlist.core.gisinsurelist.entity.GisInsureMainListKey;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 投保预确认数据主表Dao数据操作对象
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:31
 */
@Repository
public interface GisInsureMainListDao extends JpaBaseDao<GisInsureMainList, GisInsureMainListKey> {
    GisInsureMainList findByInsureListCodeAndNewFlagEquals(String insureListCode, String newFlag);


    Integer countByInsureListCode(String insureListCode);



    /**
     * 根据清单号查询最大的序列号 如果没有查到则为零
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param insureListCode
     * @return Integer
     * @throws Exception
     */
    @Query(value = "select COALESCE(MAX(p.serialNo),'0') from GisInsureMainList p where p.insureListCode=:insureListCode")
    public Integer getMaxSerialNo(@Param("insureListCode")String insureListCode)throws Exception;


//    /**
//     * 根据清单号、序列号判断对象是否存在
//     * @author: 汪强
//     * @date: 9:00 2017/11/06
//     * @param insureListCode
//     * @return Integer
//     * @throws Exception
//     */
//    @Query(value = "select COALESCE(MAX(p.insureListCode),'0') from GisInsureMainList p where p.insureListCode=:insureListCode")
//    public Boolean isExistByIcodeAndSerialNo (@Param("insureListCode")String insureListCode)throws Exception;


    /**
     * 根据清单号修改最新标志状态
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param insureListCode 清单号
     * @param newFlag 最新标志状态
     * @return Integer
     * @throws Exception
     */
    @Modifying
    @Transactional
    @Query(value = "update GisInsureMainList p set p.newFlag=:newFlag where p.insureListCode=:insureListCode ")
    public void updateNewFlag(@Param("insureListCode") String insureListCode,@Param("newFlag") String newFlag)throws Exception;


    @Query(value = "select  g from GisInsureMainList g where g.insureListCode=?1 and g.serialNo=?2")
    public GisInsureMainList queryAllByInsureListCodeAndSerialNo(String insureListCode,Integer serialNo);


}