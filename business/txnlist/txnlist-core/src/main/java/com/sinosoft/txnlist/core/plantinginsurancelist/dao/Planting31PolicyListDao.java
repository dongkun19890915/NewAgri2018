package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.Planting31PolicyList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.Planting31PolicyListKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-16 03:27:26.178
 * 投保明细表Dao数据操作对象
 */
@Repository
public interface Planting31PolicyListDao extends JpaBaseDao<Planting31PolicyList, Planting31PolicyListKey> {

    @Query(value = "select u from Planting31PolicyList u where u.inusreListCode=:inusreListCode")
    List<Planting31PolicyList> queryPlanting31ByInsuereListCode(@Param("inusreListCode") String inusreListCode);
    /**
     * 根据清单号查询Planting31PolicyList信息集合
     * @author: 田健
     * @date: 2018/3/19 14:41
     * @param inusreListCode 清单编号
     * @return Planting31PolicyList信息集合
     */
    public List<Planting31PolicyList> findByInusreListCode(String inusreListCode);

    @Query("select count(distinct p.phone) from Planting31PolicyList p where p.inusreListCode = :insureListCode and p.phone is not null")
    int findFarmerPhoneNumberCount(@Param("insureListCode")String insureListCode);

    /**
     * 根据清单号、农户代码、标的代码查询
     * @author: 孙朋飞
     * @date: 2018/4/25 17:43
     * @param inusreListCode 清单号
     * @param fCode 农户代码
     * @param itemCode 标的代码
     * @return
     */
    @Query(value = "select p from Planting31PolicyList p where p.inusreListCode=:inusreListCode and p.fCode=:fCode and p.itemCode=:itemCode")
    public List<Planting31PolicyList> findPlanting31PolicyListByConditions(@Param("inusreListCode") String inusreListCode,@Param("fCode") String fCode,@Param("itemCode") String itemCode);

    @Query(value = "select p from Planting31PolicyList p where p.inusreListCode=:inusreListCode ")
    public List<Planting31PolicyList> findPlanting31PolicyListByConditions1(@Param("inusreListCode") String inusreListCodee);
}