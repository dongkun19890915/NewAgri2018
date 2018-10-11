package com.sinosoft.agriclaim.core.compensatemanage.dao;

import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensate;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensateKey;
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
 * @time  2017-11-08 05:40:44.225 
 * 赔款计算书表Dao数据操作对象
 */
@Repository
public interface PrpLCompensateDao extends JpaBaseDao<PrpLCompensate,PrpLCompensateKey> {
    /**
     * （通过立案号找到所有对应计算书号）
     * @author: 王志文
     * @date: 2017/11/16 20:00
     * @param claimNo
     * @return
     */
    @Query("select p from PrpLCompensate p where p.claimNo =:claimNo ")
    List<PrpLCompensate> queryPrpLCompensatesByClaimNo(@Param("claimNo") String claimNo);
    @Query("select  distinct(p.claimNo) from PrpLCompensate p where p.policyNo =:policyNo and underWriteFlag='1'")
    List<String> queryPrpLCompensatesByPolicyNo(@Param("policyNo") String policyNo);

    @Query("select p from PrpLCompensate p where p.claimNo like :claimNo")
    List<PrpLCompensate> queryPrpLCompensateByClaimNoLike(@Param("claimNo") String claimNo);

    /**
     * （通过立案号找到所有对应计算书号,按计算书号倒序排列输出）
     * @author: 王志文
     * @date: 2017/11/16 20:00
     * @param claimNo
     * @return
     */
    @Query("select p from PrpLCompensate p where p.claimNo like CONCAT('%',:claimNo,'%') ORDER BY p.compensateNo DESC")
    List<PrpLCompensate> queryAllByClaimNo(@Param("claimNo") String claimNo);

    @Query("select p from PrpLCompensate p where p.compensateNo like CONCAT('%',:riskCode,'%') and rownum=1 ORDER BY p.compensateNo DESC")
    List<PrpLCompensate> queryByRiskCode(@Param("riskCode")String riskCode);

    @Query("select p from PrpLCompensate p where p.compensateNo like CONCAT('%',:compensateNo,'%') ")
    List<PrpLCompensate> queryAllByCompensateNoLike(@Param("compensateNo") String compensateNo);
    @Modifying
    @Transactional
    @Query("update PrpLCompensate p set p.isVericBack='1' where p.compensateNo=:compensateNo ")
    void updateByisVericBack(@Param("compensateNo") String compensateNo);
}