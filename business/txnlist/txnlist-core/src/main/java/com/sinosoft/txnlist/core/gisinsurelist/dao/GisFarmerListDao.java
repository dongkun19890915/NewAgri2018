package com.sinosoft.txnlist.core.gisinsurelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.gisinsurelist.entity.GisFarmerList;
import com.sinosoft.txnlist.core.gisinsurelist.entity.GisFarmerListKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * 投保预确认农户清单表Dao数据操作对象
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:30
 */
@Repository
public interface GisFarmerListDao extends JpaBaseDao<GisFarmerList, GisFarmerListKey> {
    @Query(value = "select g from GisFarmerList g where g.insureListCode=?1 and g.serialNo=?2 and g.fCode in (?3)")
    public List<GisFarmerList> queryAllByInsurelistCodeAndSerialNoAndFCode(String insureListCode,Integer serialNo,Set<String> fCodes);

    @Query(value = "select g from GisFarmerList g where g.insureListCode=?1 and g.serialNo=?2 ")
    public List<GisFarmerList> queryAllByInsurelistCodeAndSerialNo(String insureListCode,Integer serialNo);

    @Query(value = "select g from GisFarmerList g where g.insureListCode=?1 and g.serialNo=?2 and g.fCode =?3")
    public GisFarmerList queryAllByInsurelistCodeAndSerialNoAndFCode(String insureListCode,Integer serialNo,String fCodes);
}