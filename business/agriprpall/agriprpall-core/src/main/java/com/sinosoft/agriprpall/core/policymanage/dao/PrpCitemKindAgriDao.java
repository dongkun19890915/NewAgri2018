package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemKindAgri;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemKindAgriKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 07:54:48.524
 * 农险保单标的子险信息表Dao数据操作对象
 */
@Repository
public interface PrpCitemKindAgriDao extends JpaBaseDao<PrpCitemKindAgri,PrpCitemKindAgriKey> {

    /**
     *  根据保单号查询险别信息
     * @author: 何伟东
     * @date: 2017/10/22 17:01
     * @return
     */
    public List<PrpCitemKindAgri> findByPolicyNo(String policyNo);

    /**
     * 按照 policyNo 查询 PrpCitemKind 集合
     * @author 王心洋
     * @time 2017-11-09
     * @param policyNo 保单号
     * @param kindCode 险别
     * @return List<PrpCitemKindAgriDto>
     */
    @Query("select p from PrpCitemKindAgri p where p.policyNo=:policyNo and p.kindCode=:kindCode ")
    List<PrpCitemKindAgri> findByPolicyNoAndItemKindNoAndKindCode(@Param("policyNo") String policyNo, @Param("kindCode") String kindCode);

    /**
     * 按照 policyNo 查询 PrpCitemKind 集合
     * @author 王志文
     * @time 2017-11-09
     * @param policyNo 保单号
     * @param kindCode 险别
     * @return List<PrpCitemKindAgriDto>
     */
    @Query("select p from PrpCitemKindAgri p where p.policyNo=:policyNo and p.kindCode=:kindCode and p.itemKindNo=:itemKindNo and p.times>0 ")
    List<PrpCitemKindAgri> findByPolicyNoAndKindCodeAndItemKindNo(@Param("policyNo") String policyNo, @Param("kindCode") String kindCode,@Param("itemKindNo")Integer itemKindNo);

    @Modifying
    @Transactional
    @Query(value = "delete from PrpCitemKindAgri p where p.policyNo=:policyNo")
    public void deleteByPolicyNo(@Param("policyNo")String policyNo);

    /**
     * 根据保单号、险种、险别、出险时间查询茬次信息
     * @author: 孙朋飞
     * @date: 2018/4/25 8:52
     * @param policyNo 保单号
     * @param riskCode 险种
     * @param kindCode 险别
     * @param damageStartDate 出险时间
     * @return 茬次
     */
    @Query(value="select nvl(p.times,0) from PrpCitemKindAgri p where p.policyNo=:policyNo and p.riskCode=:riskCode and p.kindCode=:kindCode and p.stratDate<=:damageStartDate and p.endDate>=:damageStartDate and p.times<>0",nativeQuery = true)
    Integer findPrpcItemKindAgriTimesByConditions(@Param("policyNo") String policyNo, @Param("riskCode") String riskCode,@Param("kindCode") String kindCode,@Param("damageStartDate") Date damageStartDate);
}