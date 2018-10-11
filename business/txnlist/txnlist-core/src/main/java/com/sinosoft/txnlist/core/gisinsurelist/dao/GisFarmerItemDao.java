package com.sinosoft.txnlist.core.gisinsurelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.gisinsurelist.entity.GisFarmerItem;
import com.sinosoft.txnlist.core.gisinsurelist.entity.GisFarmerItemKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 预投保清单农户标的表Dao数据操作对象
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:30
 */
@Repository
public interface GisFarmerItemDao extends JpaBaseDao<GisFarmerItem, GisFarmerItemKey> {

    /**
     * 根据清单号和序列号查询金禾清单gisFarmerItem表
     * @param insureListCode 清单号
     * @param serialNo 序列号
     * @return List<GisInsureMainList>
     * @author: 李冬松
     */

    @Query(value = "select g from GisFarmerItem g where g.insureListCode=?1 and g.serialNo=?2 ")
    public List<GisFarmerItem> queryAllByInsureListCodeAndSerialNo(String insureListCode, Integer serialNo);

    @Query(value = "select g from GisFarmerItem g where g.insureListCode=?1 and g.serialNo=?2 and g.itemListCode in (?3)")
    public List<GisFarmerItem> queryAllByCondition(String insureListCode, Integer serialNo, List<String> itemListCodes);

    /**
     * 根据清单号、序列号、标的集合查询GisFarmerItem农户标的表条数
     * @author: 田健
     * @date: 2018/3/7 20:22
     * @param insureListCode 清单编号
     * @param serialNo 序列号
     * @param itemListCodes 标的清单集合
     * @return 条数
     */
    @Query(value = "select count(g) from GisFarmerItem g where g.insureListCode=?1 and g.serialNo=?2 and g.itemListCode in (?3)")
    public Long queryCountByCondition(String insureListCode, Integer serialNo, List<String> itemListCodes);
    /**
     * 根据清单号和序列号查询金禾清单gisFarmerItem表
     * @author: 田健
     * @date: 2018/3/1 15:58
     * @param inusreListCode 清单号
     * @param serialNo 序列号
     * @param itemCode 标的清单号
     * @return 农户信息集合
     */
    @Query(value = "select g from GisFarmerItem g where g.insureListCode=?1 and g.serialNo=?2 and g.itemListCode in (?3)")
    List<GisFarmerItem> queryAllByInsureListCodeAndSerialNoAndItemCode(String inusreListCode, Integer serialNo, String itemCode);


    /**
     * 根据清单号、序列号、标的代码集合查询GisFarmerItem农户标的表
     *
     * @param insureListCode
     * @param serialNo
     * @param itemCodes
     * @author: 何伟东
     * @date: 2018-05-10 11:31
     */
    @Query(value = "select g from GisFarmerItem g where g.insureListCode=?1 and g.serialNo=?2 and g.itemCode in (?3)")
    public List<GisFarmerItem> queryByInsureListCodeAndSerialNoAndItemCodes(String insureListCode, Integer serialNo, List<String> itemCodes);

    /**
     * 保费计算时校验标的清单与标的是否匹配（除新单外）
     * @author: 田健
     * @date: 2018/5/17 20:15
     * @param gisInsureListCode 金禾清单编号
     * @param serialNo 序列号
     * @param itemCode 标的代码
     * @param itemCodeList 标的清单号
     * @return map集合 ，key为1：数据匹配 ，0:数据不匹配
     */
    @Query(value = "select g from GisFarmerItem g where g.insureListCode=?1 and g.serialNo=?2 and g.itemCode =?3 and g.itemListCode=?4")
    public List<GisFarmerItem> CheckItemCodeListMethod (String gisInsureListCode,Integer serialNo,String itemCode,String itemCodeList);
    @Query(value = "select g from GisFarmerItem g where g.insureListCode=?1 and g.serialNo=?2 and g.itemCode =?3")
    public List<GisFarmerItem> queryInsureCount (String gisInsureListCode,Integer serialNo,String itemCode);
}