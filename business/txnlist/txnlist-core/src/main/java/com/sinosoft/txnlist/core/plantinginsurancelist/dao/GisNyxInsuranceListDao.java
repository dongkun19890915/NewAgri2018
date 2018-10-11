package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.GisNyxInsuranceList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.GisNyxInsuranceListKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-06 02:22:27.335
 * 投保预确认农户清单表Dao数据操作对象
 */
@Repository
public interface GisNyxInsuranceListDao extends JpaBaseDao<GisNyxInsuranceList, GisNyxInsuranceListKey> {

    /**
     * 根据清单号查询最大的序列号 如果没有查到则为零
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param insureListCode
     * @return Integer
     * @throws Exception
     */
    @Query(value = "select COALESCE(MAX(p.serialNo),'0') from GisNyxInsuranceList p where p.insureListCode=:insureListCode")
    public Integer getMaxSerialNo(@Param("insureListCode")String insureListCode)throws Exception;

    @Query(value = "select i from GisNyxInsuranceList i where i.insureListCode=?1 and i.serialNo=?2 ")
    public List<GisNyxInsuranceList> findByInsureListCodeAndSerialNo(String insureListCode, Integer serialNo);

}