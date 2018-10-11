package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxEffectiveAmount;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxEffectiveAmountKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NyxEffectiveAmountDao extends JpaBaseDao<NyxEffectiveAmount, NyxEffectiveAmountKey> {

    /**
     * 根据条件查询NyxEffectiveAmount的最新一条数据
     * @author: 刘曼曼
     * @date: 15:24 15:24
     * @param policyNo 保单号
     * @param riskCode 险种
     * @param kindCode 险别
     * @param itemCode 标的
     * @param fCode 农户代码
     * @param flag 其他（茬次）
     * @return List<NyxEffectiveAmount>
     */
    @Query(value = "select t from NyxEffectiveAmount t where t.policyNo=:policyNo and t.riskCode=:riskCode and t.kindCode=:kindCode and t.itemCode=:itemCode and t.fCode=:fCode and t.flag=:flag and t.startDate <=:startDate " +
            " and t.serialNo=(select max(c.serialNo) from NyxEffectiveAmount c where t.policyNo=c.policyNo and t.riskCode=c.riskCode and t.kindCode=c.kindCode and t.itemCode=c.itemCode and t.fCode=c.fCode and t.flag=c.flag)")
    NyxEffectiveAmount findByNew(@Param("policyNo") String policyNo,@Param("riskCode") String riskCode,@Param("kindCode") String kindCode,@Param("itemCode") String itemCode,@Param("fCode") String fCode,@Param("flag") Integer flag,@Param("startDate") Date startDate);

    /**
     * 根据条件查询NyxEffectiveAmount的最新一条数据
     * @author: 刘曼曼
     * @date: 15:24 15:24
     * @param policyNo 保单号
     * @param riskCode 险种
     * @param kindCode 险别
     * @param itemCode 标的
     * @param fCode 农户代码
     * @param flag 其他（茬次）
     * @return List<NyxEffectiveAmount>
     */
    @Query(value = "select t from NyxEffectiveAmount t where t.policyNo=:policyNo and t.riskCode=:riskCode and t.kindCode=:kindCode and t.itemCode=:itemCode and t.fCode=:fCode and t.flag=:flag " +
            " and t.serialNo=(select max(c.serialNo) from NyxEffectiveAmount c where t.policyNo=c.policyNo and t.riskCode=c.riskCode and t.kindCode=c.kindCode and t.itemCode=c.itemCode and t.fCode=c.fCode and t.flag=c.flag)")
    NyxEffectiveAmount findByAll(@Param("policyNo") String policyNo,@Param("riskCode") String riskCode,@Param("kindCode") String kindCode,@Param("itemCode") String itemCode,@Param("fCode") String fCode,@Param("flag") Integer flag);


    /**
     * 根据条件查询NyxEffectiveAmount集合
     * @author: 刘曼曼
     * @date: 15:24 15:24
     * @param policyNo 保单号
     * @param riskCode 险种
     * @param kindCode 险别
     * @param itemCode 标的
     * @param fCode 农户代码
     * @param flag 其他（茬次）
     * @return List<NyxEffectiveAmount>
     */
    @Query(value = "select t from NyxEffectiveAmount t where t.policyNo=:policyNo and t.riskCode=:riskCode and t.kindCode=:kindCode and t.itemCode=:itemCode and t.fCode=:fCode and t.flag=:flag ")
    List<NyxEffectiveAmount> findNyxEffectiveAmount(@Param("policyNo") String policyNo, @Param("riskCode") String riskCode, @Param("kindCode") String kindCode, @Param("itemCode") String itemCode, @Param("fCode") String fCode, @Param("flag") Integer flag);


    /**
     * 根据条件查询NyxEffectiveAmount的最新一条数据集合
     * @author: 刘曼曼
     * @date: 15:24 15:24
     * @param policyNos 保单号
     * @param riskCodes 险种
     * @param kindCodes 险别
     * @param itemCodes 标的
     * @param fCodes 农户代码
     * @param flags 其他（茬次）
     * @return List<NyxEffectiveAmount>
     */
    @Query(value = "select t from NyxEffectiveAmount t where t.policyNo in(:policyNos) and t.riskCode in(:riskCodes) and t.kindCode in(:kindCodes) and t.itemCode in(:itemCodes) and t.fCode in(:fCodes) and t.flag in(:flags) " +
            " and t.serialNo=(select max(c.serialNo) from NyxEffectiveAmount c where t.policyNo=c.policyNo and t.riskCode=c.riskCode and t.kindCode=c.kindCode and t.itemCode=c.itemCode and t.fCode=c.fCode and t.flag=c.flag)")
    List<NyxEffectiveAmount> findNyxEffectiveAmountList(@Param("policyNos") List<String> policyNos,@Param("riskCodes") List<String> riskCodes,@Param("kindCodes") List<String> kindCodes,@Param("itemCodes") List<String> itemCodes,@Param("fCodes") List<String> fCodes,@Param("flags") List<Integer> flags);


    /**
     * 根据保单号查询有效保额
     * @author: 孙朋飞
     * @date: 2018/5/18 18:17
     * @param policyNo 保单号
     * @return
     */
    @Query(value="select sum(amount) from NyxEffectiveAmount t WHERE t.policyNo=:policyNo and t.startDate <=:startDate " +
            " and t.serialNo=(select max(c.serialNo) from NyxEffectiveAmount c where t.policyNo=c.policyNo)")
    public Double findNyxEffectiveAmountByPolicyNo(@Param("policyNo") String policyNo,@Param("startDate") Date startDate);

    /**
     * 根据保单号查询有效保额
     *
     * @param policyNo 保单号
     * @return
     * @author: 孙朋飞
     * @date: 2018/5/18 18:17
     */
    @Query(value = "select t from NyxEffectiveAmount t WHERE t.policyNo=:policyNo and t.startDate <=:startDate " +
            " and t.serialNo=(select max(c.serialNo) from NyxEffectiveAmount c where t.policyNo=c.policyNo)")
    public List<NyxEffectiveAmount> findNyxEffectiveAmountByPolicyNo1(@Param("policyNo") String policyNo, @Param("startDate") Date startDate);
}
