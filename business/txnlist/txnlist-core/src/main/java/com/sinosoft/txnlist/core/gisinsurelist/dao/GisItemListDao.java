package com.sinosoft.txnlist.core.gisinsurelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.gisinsurelist.entity.GisItemList;
import com.sinosoft.txnlist.core.gisinsurelist.entity.GisItemListKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 预投保清单标的表Dao数据操作对象
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:32
 */
@Repository
public interface GisItemListDao extends JpaBaseDao<GisItemList, GisItemListKey> {
    @Query(value = "select g from GisItemList g where g.insureListCode=?1 and g.serialNo=?2 ")
    public List<GisItemList> queryAllByInsureListCodeAndSerialNo(String insureListCode,Integer serialNo);

    @Query(value = "select g from GisItemList g where g.insureListCode=?1 and  g.serialNo=?2 and g.itemCode=?3")
    public GisItemList queryByCondition(String insureListCode,Integer serialNo,String itemCode);
}