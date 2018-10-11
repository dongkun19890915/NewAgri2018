package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainKey;
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
 * @time  2017-10-25 00:11:08.712 
 * 保单信息主表Dao数据操作对象
 */
@Repository
public interface PrpCmainDao extends JpaBaseDao<PrpCmain,PrpCmainKey> {
    @Query(value = "select p from PrpCmain p where " +
            "p.policyNo= ?1")
    public PrpCmain queryPrpCMainByCondition(String policyNo);

    public List<PrpCmain> findPrpCmainByProposalNo(String proposalNo);

    /**
     * * 根据投保单号查询保单号
     * @author: 田慧
     * @date: 19:40
     * @param proposalNo 投保单号
     * @return
     */
    List<PrpCmain> findByProposalNo(String proposalNo);

    /**
     * 根据起始保单号，结束保单号区间查询保单号
     * @author: 刘曼曼
     * @date: 2017/11/22 17:02
     * @param startPolicyNo 起始保单号
     * @param endPolicyNo  结束保单号
     * @return List<String> 保单号集合
     */
    @Query(value = "select a.policyNo from PrpCmain a  where a.classCode in ('31','32') and a.policyNo between :startPolicyNo and :endPolicyNo and rownum <= 50")
    public List<String> queryPolicyNoList(@Param("startPolicyNo") String startPolicyNo,@Param("endPolicyNo") String endPolicyNo);
    /**
     *  根据policyNo保单号、riskCode险种代码检查保单号是否存在
     * @author: 田慧
     * @date: 2017/12/1 14:38
     * @param policyNo 保单号
     * @param riskCode 险种代码
     * @return 返回List<prpCmain></prpCmain> 保单基本信息表信息
     * @throws Exception
     */
    @Query(value = "select p from PrpCmain p where p.policyNo=:policyNo and p.riskCode=:riskCode")
    public List<PrpCmain> queryPrpCMain(@Param("policyNo") String policyNo,@Param("riskCode") String riskCode);

    /**
     * 根据policyNo保单号、riskCode险种代码检查保单号是否存在
     *
     * @param policyNo tou保单号
     * @return 返回List<prpTmain></prpTmain>投保单基本信息表信息
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/1 14:38
     */
    @Query(value = "select count(p) from PrpCmain  p where p.policyNo= :policyNo ")
    public Integer queryPrpcMainCount(@Param("policyNo") String policyNo);
    /**
     * 根据保单号回写PrpCmain表的理赔次数claimTimes字段
     * @author: 宋振振
     * @date: 2017/12/15 9:58
     * @param policyNo 保单号
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "update PrpCmain p set p.claimTimes=p.claimTimes+1  Where p.policyNo = ?1")
    public void modifyPrpCmainAddClaimTimes(String policyNo)throws Exception;

    /**
     * 根据保单号查询PrpCmain数据
     * @author: 王保良
     * @date: 2017/12/6 17:02
     * @param policyNo 起始保单号
     * @return PrpCmain PrpCmain对象
     */
    @Query(value = "select p from PrpCmain p where p.policyNo=:policyNo")
    public PrpCmain findByPolicyNo(@Param("policyNo") String policyNo);

    @Query(value = "select p from PrpCmain p where p.policyNo=:oldPolicyNo")
    public List<PrpCmain> findByOldPolicyNo(@Param("oldPolicyNo") String oldPolicyNo);

    @Query(value = "select p from PrpCmain p where p.riskCode in (:riskCode) and p.underwriteFlag='4' and substring(p.othFlag,4,1) <>'1' and (p.underwriteEndDate + 30 < current_date or p.startDate + 30 < current_date) ")
    public List<PrpCmain> findByCondition1(@Param("riskCode") String[] riskCode);

    @Query(value = "select p from PrpCmain p where p.underwriteFlag='4' and p.riskCode in (:riskCode) and substring(p.othFlag,4,1) <>'1' and p.policyNo=:policyNo")
    public List<PrpCmain> findByCondition2(@Param("riskCode") String[] riskCode,@Param("policyNo") String policyNo);

    @Query(value = "select count(p) from PrpCmain p where p.proposalNo=:proposalNo ")
    public Integer findCountByProposalNo(@Param("proposalNo") String proposalNo);

    @Modifying
    @Transactional
    @Query(value = "delete from PrpCmain p where p.policyNo=:policyNo")
    public void deleteByPolicyNo(@Param("policyNo")String policyNo);

    /**
     * 批量回写打印号
     * @author: 宋振振
     * @date: 2018/3/31 11:59
     * @param printNo
     * @param policyNos
     */
    @Modifying
    @Transactional
    @Query(value = "update PrpCmain p set p.printNo=:printNo where p.policyNo in (:policyNos)")
    public void updatePrintNo(@Param("printNo")String printNo,@Param("policyNos")String [] policyNos);
    @Modifying
    @Transactional
    @Query(value = "update PrpCmain p set p.printNo='' where p.policyNo in (:policyNos)")
    public void updatePrintNos(@Param("policyNos") List<String> policyNos);

    @Modifying
    @Transactional
    @Query(value = "select p from PrpCmain p where p.policyNo in (:policyNos)")
    public List<PrpCmain> findPrpCmainByPolicyNos(@Param("policyNos")List<String> policyNos);

    @Query(value = "select p from PrpCmain p where p.policyNo in (:policyList)")
    public List<PrpCmain> queryAllByPolicyNo (@Param("policyList") List<String> policyList);
    /**
     * * （根据保单号查看是否已经打印）
     * @author: 田慧
     * @date: 20:02
     * @param policyNoList  保单号集合
     * @return resultMap
     * @throws Exception
     */
    @Query(value = "select p from PrpCmain p where p.policyNo in (:policyNoList)")
    List<PrpCmain> queryPrintNo(@Param("policyNoList") List<String> policyNoList);

    /**
     * 查询指定起保日期的保单数据
     *
     * @param startDate  指定时间
     * @param systemFlag 系统标识
     * @return List<PrpCmain>
     * @date: 2018/4/10 17:00
     * @author: 何伟东
     */
    @Query(value = "select p from PrpCmain p where p.systemFlag=:systemFlag and p.startDate = to_date(:startDate, 'yyyy-mm-dd hh24:mi:ss')")
    List<PrpCmain> queryByStartDate(@Param("systemFlag") String systemFlag, @Param("startDate") String startDate);

    /**
     * 查询指定起保日期的保单数据
     *
     * @param endDate  指定时间
     * @param systemFlag 系统标识
     * @return List<PrpCmain>
     * @date: 2018/4/10 17:00
     * @author: 何伟东
     */
    @Query(value = "select p from PrpCmain p where p.systemFlag=:systemFlag and p.endDate = to_date(:endDate, 'yyyy-mm-dd hh24:mi:ss')")
    List<PrpCmain> queryByEndDate(@Param("systemFlag") String systemFlag, @Param("endDate") String endDate);

    /**
     * 批量查询保单信息
     * @param policyNos 多个保单号
     * @return List<PrpCmain>
     * @date: 2018/4/12 10:48
     * @author: 何伟东
     */
    @Query(value = "select p from PrpCmain p where p.systemFlag=:systemFlag and p.policyNo in (:policyNos)")
    List<PrpCmain> queryPolicyInfoByPolicyNos(@Param("systemFlag") String systemFlag, @Param("policyNos") List<String> policyNos);


    /**
     * 批量查询保单信息
     * @param proposalNos 多个保单号
     * @return List<PrpCmain>
     * @date: 2018/4/12 10:48
     * @author: 何伟东
     */
    @Query(value = "select p.policyNo from PrpCmain p where   p.proposalNo in (:proposalNos)")
    List<String> queryPolicyInfoByProposalNos( @Param("proposalNos") List<String> proposalNos);
}