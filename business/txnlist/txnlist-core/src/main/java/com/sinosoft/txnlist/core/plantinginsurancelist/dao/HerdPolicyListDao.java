package com.sinosoft.txnlist.core.plantinginsurancelist.dao;


import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdPolicyList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdPolicyListKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-30 07:53:53.940
 * 养殖险保单清单最新数据表1Dao数据操作对象
 */
@Repository
public interface HerdPolicyListDao extends JpaBaseDao<HerdPolicyList, HerdPolicyListKey> {
    @Query(value="select u from HerdPolicyList u where u.inusreListCode=:inusreListCode")
    List<HerdPolicyList> queryHerdByInsureListCode(@Param("inusreListCode") String inusreListCode);

    /**
     * 按照fCardId,inusreListCode查询查询结果集
     *@param fIdCard 农户身份证
     *@param inusreListCode 投保清单编号
     *@return boolean 有无查询结果
     * @author 王心洋
     * @time 2017-11-17
     */
    @Query(value="select u from HerdPolicyList u where u.fIdCard=:fIdCard and u.inusreListCode=:inusreListCode")
    List<HerdPolicyList> queryByInsureListCodeAndFIdCard(@Param("fIdCard")String fIdCard,@Param("inusreListCode") String inusreListCode);

    @Query(value = "select p from HerdPolicyList p where p.inusreListCode=:inusreListCode")
    public List<HerdPolicyList> queryByInusreListCode(@Param("inusreListCode") String inusreListCode);

    /**
    *
    * @param
    * @return
    * @throws
    * @author 李冬松
    * @date 10:37 2017/11/22
    */
    @Query(value = "select h from HerdPolicyList h where h.inusreListCode=?1 ")
    List<HerdPolicyList> queryByinsureListCode(String insureListCode);
    /**
     * 按照条件查询查询结果集
     *@param earLabel 耳标号
     *@param inusreListCode 投保清单编号
     *@param startDate 出险时间
     *@return list
     * @author 马俊玲
     * @time 2017-11-17
     */
    @Query(value="select * from HerdPolicyList  where earLabel=:earLabel and kindCode=:kindCode and inusrelistCode=:inusreListCode and VALIDITY = '1' and (STARTDATE <= to_date(:startDate,'yyyy-mm-dd hh24:mi:ss')  and ENDDATE >= to_date(:startDate,'yyyy-mm-dd hh24:mi:ss'))",nativeQuery=true)
    List<HerdPolicyList> queryByConditon(@Param("earLabel")String earLabel,@Param("kindCode") String kindCode,@Param("inusreListCode") String inusreListCode,@Param("startDate") String startDate);
    /**
     *
     * @param
     * @return
     * @throws
     * @author 陈道洋
     * @date 10:37 2017/11/22
     */
    @Query(value = "select h from HerdPolicyList h where h.inusreListCode=?1 and h.fCode=?2")
    HerdPolicyList queryByInusreListCodeAndFcode(String insureListCode,String fCode);

    /**
     * 根据清单号查询HerdPolicyList信息集合
     * @author: 田健
     * @date: 2018/3/19 14:41
     * @param inusreListCode 清单编号
     * @return HerdPolicyList信息集合
     */
    public List<HerdPolicyList> findByInusreListCode(String inusreListCode);

    @Query("select count(distinct p.phone) from HerdPolicyList p where p.inusreListCode = :insureListCode and p.phone is not null")
    int findFarmerPhoneNumberCount(@Param("insureListCode")String insureListCode);
}