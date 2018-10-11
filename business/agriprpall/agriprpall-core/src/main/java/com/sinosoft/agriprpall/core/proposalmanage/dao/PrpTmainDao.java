package com.sinosoft.agriprpall.core.proposalmanage.dao;

import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmain;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmainKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 投保单基本信息表Dao数据操作对象
 * @Author: 何伟东
 * @Date: 2017/10/15 11:18
 */
@Repository
public interface PrpTmainDao extends JpaBaseDao<PrpTmain, PrpTmainKey> {
    /**
     * 根据policyNo保单号、riskCode险种代码检查保单号是否存在
     *
     * @param policyNo 保单号
     * @param riskCode 险种代码
     * @return 返回List<prpTmain></prpTmain>投保单基本信息表信息
     * @throws Exception
     * @author: 田慧
     * @date: 2017/12/1 14:38
     */
    @Query(value = "select p from PrpTmain p where p.policyNo= :policyNo and p.riskCode= :riskCode")
    public List<PrpTmain> queryPrpTMainInfo(@Param("policyNo") String policyNo, @Param("riskCode") String riskCode);

    /**
     * 根据policyNo保单号、riskCode险种代码检查保单号是否存在
     *
     * @param proposalNo tou保单号
     * @return 返回List<prpTmain></prpTmain>投保单基本信息表信息
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/1 14:38
     */
    @Query(value = "select count(p) from PrpTmain p where p.proposalNo= :proposalNo ")
    public Integer queryPrpTMainCount(@Param("proposalNo") String proposalNo);

    @Query(value = "select p from PrpTmain p where p.riskCode in (:riskCode) and p.startDate+30<current_date and p.underwriteFlag in ('0','2','9')")
    public List<PrpTmain> findByCondition(@Param("riskCode") String[] riskCode);

    @Query(value = "select p from PrpTmain p where p.proposalNo=:proposalNo")
    public PrpTmain findByProposalNo(@Param("proposalNo") String proposalNo);

    @Modifying
    @Transactional
    @Query(value = "delete from PrpTmain p where p.proposalNo=:proposalNo")
    public void deleteByProposalNo(@Param("proposalNo") String proposalNo);


    PrpTmain findByProposalNoAndUnderwriteFlag(String proposalNo, String underwriteFlag);

    /**
     * 批量回写打印号
     *
     * @param printNo
     * @param proposalNos
     * @author: 宋振振
     * @date: 2018/3/31 11:59
     */
    @Modifying
    @Transactional
    @Query(value = "update PrpTmain p set p.printNo=:printNo where p.proposalNo=:proposalNo")
    public void updatePrintNo(@Param("printNo") String printNo, @Param("proposalNo") String proposalNos);

    /**
     * 根据投保单号查询指定状态的投保单
     *
     * @param proposalNos 投保单号码集合
     * @param systemFlag  系统标志
     * @author: 何伟东
     * @date: 2018/4/17 15:52
     */
    @Query(value = "select p from PrpTmain p where p.proposalNo in (:proposalNos) and p.systemFlag=:systemFlag")
    List<PrpTmain> queryProposal(@Param(value = "proposalNos") List<String> proposalNos, @Param(value = "systemFlag") String systemFlag);
}