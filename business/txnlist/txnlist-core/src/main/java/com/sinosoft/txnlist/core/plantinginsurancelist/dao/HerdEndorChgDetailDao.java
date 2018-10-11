package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdEndorChgDetail;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdEndorChgDetailKey;
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
 * @time  2017-11-14 07:07:05.012 
 * 养殖险保单清单最新数据表Dao数据操作对象
 */
@Repository
public interface HerdEndorChgDetailDao extends JpaBaseDao<HerdEndorChgDetail,HerdEndorChgDetailKey> {

    /**
     * 按照清单号删除
     *@param inusreListCode 清单号
     *@author 王心洋
     *@time 2017-11-18
     */
    @Query(value = "delete from HerdEndorChgDetail h where h.inusreListCode=:inusreListCode")
    @Modifying
    @Transactional
    public void removeByInusreListCode(@Param("inusreListCode") String inusreListCode);
    /**
     * 按照清单号删除
     *@param inusreListCode 清单号
     *@author 王心洋
     *@time 2017-11-18
     */
    @Query(value = "select count(distinct u.fCode) FROM HerdEndorChgDetail u WHERE u.inusreListCode=:inusreListCode and u.validity='1'")
    public int getSumInsured(@Param("inusreListCode") String inusreListCode);
    /**
     * 按照条件查询清单
     *@param inusreListCode 清单号
     *@author 马俊玲
     *@time 2017-12-08
     */
    @Query(value = "select * FROM HerdEndorChgDetail  WHERE endorseNo=:endorseNo and earLabel=:earLabel and inusreListCode=:inusreListCode and kindCode=:kindCode and (STARTDATE <= to_date(:damageDate,'yyyy-mm-dd')  and ENDDATE >= to_date(:damageDate+,'yyyy-mm-dd')) ",nativeQuery=true)
    public List<HerdEndorChgDetail> findByConditions(@Param("endorseNo") String endorseNo, @Param("earLabel")  String earLabel, @Param("inusreListCode") String inusreListCode, @Param("kindCode") String kindCode, @Param("damageDate") String damageDate);
    /**
    * 批改清单保存前删除
    * @param
    * @return void
    * @throws
    * @author 李冬松
    * @date 17:06 2018/4/12
    */
    @Query(value = "delete from HerdEndorChgDetail h where h.endorseNo=:endorseNo")
    @Modifying
    @Transactional
    public void removeByEndorseNo(@Param("endorseNo") String endorseNo);
    /**
     * 根据批单号码查询planting的批改变化量清单
     *
     * @param endorseNo 批单号码
     * @return 分户清单批改变化量信息
     * @author: 何伟东
     * @date: 2018/1/19 9:41
     */
    List<HerdEndorChgDetail> findByEndorseNo(String endorseNo);
}