package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPhead;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPheadKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface PrpPheadDao extends JpaBaseDao<PrpPhead,PrpPheadKey>{
    @Modifying
    @Transactional
    @Query(value = "delete from PrpPhead p where p.endorseNo=:endorseNo")
    public void deleteByEndorseNo(@Param("endorseNo") String endorseNo);

    @Query(value = "select count(p) from PrpPhead p where p.policyNo=?1 and p.validDate>?2 ")
    public int countAllByDate(String policyNo, Date validDate);

    @Query(value = "select count(p) from PrpPhead p where p.policyNo=?1 " +
            " AND (p.underwriteFlag is null OR (p.underwriteFlag<>'1' AND p.underwriteFlag<>'3')) ")
    public int countAllByFlag(String policyNo);

    @Query(value = "select p from PrpPhead p where p.policyNo=?1 AND (p.underwriteFlag<>'1' AND p.underwriteFlag<>'3')")
    public List<PrpPhead> queryAllByCondition(String policyNo);

    //public PrpPhead queryByPK(String endorseNo);
    /**
     * 根据保单号查询PrpPhead表
     * @author: 宋振振
     * @date: 2017/11/5 11:01
     * @param policyNo
     * @return List<PrpPhead>
     * @throws Exception
     */
    public List<PrpPhead> findPrpPheadByPolicyNo(String policyNo) throws Exception;
    public PrpPhead queryByEndorseNo(String endorseNo);
    @Query(value = "select p from PrpPhead p where p.policyNo=?1 ")
    public List<PrpPhead> queryAllByByPolicyNo(String policyNo);

    @Query(value = "select p from PrpPhead p where p.endorseNo in (:endorseNos)")
    public List<PrpPhead> findPrpPheadByPolicyNos(@Param("endorseNos")List<String> endorseNo);
    /**
     * 根据条件查询prpPhead表 并返回符合条件的PrpPhead放入list中
     * @author: 王保良
     * @date: 2017/11/20 11:01
     * @param policyNo 保单号
     * @param endorDate 批改日期
     * @param endorseNo 批单号
     * @return List<PrpPhead>
     * @throws Exception
     */
    @Query(value = "select p from PrpPhead p where p.policyNo=:policyNo and p.endorseNo>=:endorseNo and p.endorDate>=:endorDate order by p.endorDate DESC ,p.endorseNo desc ")
    public List<PrpPhead> findByCondition(@Param("policyNo") String policyNo, @Param("endorseNo") String endorseNo, @Param("endorDate") Date endorDate);

    /**
     * 根据保单号和出险日期查询PrpPhead表信息
     * @author: 刘曼曼
     * @date: 2017/11/27 17:43
     * @param policyNo 保单号
     * @param backWardDate 出险日期
     * @return PrpPhead 批改信息表信息
     */
    @Query(value = "select p from PrpPhead p where p.policyNo=:policyNo AND p.validDate > :backWardDate AND p.underwriteFlag in ('1', '3') ORDER BY p.inputDate DESC,p.endorseTimes DESC")
    public List<PrpPhead> queryPrpPheadInfo(@Param("policyNo") String policyNo, @Param("backWardDate") Date backWardDate);


    /**
     * 根据保单号查询PrpPhead表信息
     * @author: 刘曼曼
     * @date: 2017/11/27 17:43
     * @param policyNo 保单号
     * @return PrpPhead 批改信息表信息
     */
    @Query(value = "select p from PrpPhead p where p.policyNo=:policyNo  AND p.underwriteFlag in ('1', '3') ORDER BY p.inputDate DESC,p.endorseTimes DESC")
    public List<PrpPhead> queryPrpPheadInfoList(@Param("policyNo") String policyNo);

    /**
     * 根据批单号查询PrpPhead表信息(已核保)
     * @author: 王保良
     * @date: 2017/11/27 17:43
     * @param endorseNo 批单号
     * @return PrpPhead 批改信息表信息
     */
    @Query(value = "select p from PrpPhead p where p.endorseNo=:endorseNo and p.underwriteFlag not in ('1','3')")
    public List<PrpPhead> findAllByCondition(@Param("endorseNo") String endorseNo);
    @Query(value = "select p from PrpPhead p where p.endorseNo=:endorseNo")
    public PrpPhead findByEndorseNo(@Param("endorseNo") String endorseNo);

    /**
     *通过保单号，出险小时，出险日期查询批单头表信息
     * @author: 李冬松
     * @date: 2017/12/23 14:32
     * @param policyNo 保单号
     * @param validDate 出险日期
     * @param  validhour  出险小时
     * @return List<PrpPheadDto>批单表集合
     * @throws Exception
     */
    @Query(value = "select p from PrpPhead  p where p.policyNo=?1 and p.validDate=?2 and p.validHour=?3 ")
    public List<PrpPhead> queryByPolicyNoAndDamagerDate(String policyNo,Date validDate,Integer validhour);

    /**
     * 根据policyNo和时间条件查询PrpPheadDto集合
     * @author: 刘曼曼
     * @date: 2017/12/23 14:36
     * @param policyNo 保单号
     * @param damageDate
     * @param damageHour 小时
     * @return List<PrpPhead>集合
     */
    @Query(value = "select p from PrpPhead p where p.policyNo =:policyNo  AND (p.validDate > :damageDate OR (p.validDate=:damageDate AND p.validHour>:damageHour)) AND p.underwriteFlag in ('1', '3')  ORDER BY p.inputDate DESC,p.endorseTimes DESC")
    public List<PrpPhead> queryPrpPheadDtoByNoANDTime(@Param("policyNo") String policyNo,@Param("damageDate") Date damageDate,@Param("damageHour") int damageHour);

    /**
     * （根据保单号查询PrpPhead表）
     * @author: 王志文
     * @date: 2017/11/16 17:34
     * @param policyNo
     * @return
     */
    @Query("select p from PrpPhead p where p.policyNo =:policyNo ")
    List<PrpPhead> queryPrpPheadByPolicyNo(@Param("policyNo") String policyNo);

    @Query(value = "select p from PrpPhead p where p.underwriteEndDate+30<current_date and p.underwriteFlag='4' and p.riskCode in (:riskCode)")
    public List<PrpPhead> findByCondition1(@Param("riskCode") String[] riskCode);

    @Query(value = "select p from PrpPhead p where p.underwriteFlag='4' and p.riskCode in (:riskCode) and p.endorseNo=:endorseNo")
    public List<PrpPhead> findByCondition2(@Param("riskCode") String[] riskCode,@Param("endorseNo") String endorseNo);

    @Modifying
    @Transactional
    @Query(value = "update PrpPhead p set p.printNo='' where p.endorseNo in (:endorseNos)")
    public void updatePrintNoos(@Param("endorseNos") List<String> endorseNos);
    /**
     * 根据出险时间、保单号查询批单表信息
     * @author: 田健
     * @date: 2018/4/11 9:44
     * @param policyNo 保单号
     * @param validDate 出险时间
     * @return 批单信息
     */
    @Query("select p from PrpPhead p where p.policyNo=?1 and p.validDate> ?2")
    public List<PrpPhead> queryByCondition(String policyNo,Date validDate);
    @Query(value = "select p from PrpPhead p where p.endorseNo=?1")
    public List<PrpPhead> queryOnlyByEndorseNo(String endorseNo);
}
