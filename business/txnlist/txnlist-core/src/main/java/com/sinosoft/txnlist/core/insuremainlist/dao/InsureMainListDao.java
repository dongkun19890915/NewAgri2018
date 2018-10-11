package com.sinosoft.txnlist.core.insuremainlist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.insuremainlist.entity.InsureMainList;
import com.sinosoft.txnlist.core.insuremainlist.entity.InsureMainListKey;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-17 07:14:54.112 
 * 清单主表Dao数据操作对象
 */
@Repository
public interface InsureMainListDao extends JpaBaseDao<InsureMainList,InsureMainListKey> {
    /**
     * @description: 根据投保单号查询
     * @author: 何伟东
     * @date: 2017/10/26 9:20
     * @param proposalNo
     * @return
     */
    public List<InsureMainList> findByProposalNo(@Param(value = "proposalNo") String proposalNo);
    /**
     * @description: 根据保单号查询
     * @author: 王心洋
     * @date: 2017/11/08
     * @param policyNo
     * @return
     */
    @Query(value = "select i from InsureMainList i where i.policyNo=:policyNo")
    public List<InsureMainList> findByPolicyNo(@Param(value = "policyNo") String policyNo);

    /**
     * 根据清单编号回写投保单号和清单标志
     * @author: 陈道洋
     * @date: 2017/11/15 17:40
     * @param inusreListCode 清单编号
     * @param proposalNo 投保单号
     * @param validity 清单标志
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying(clearAutomatically = true)
    @Query(value = "update InsureMainList i set i.proposalNo=:proposalNo,i.validity=:validity where i.inusreListCode=:inusreListCode")
    public int updateInsuredMainList(@Param("proposalNo") String proposalNo,@Param("validity") String validity,@Param("inusreListCode") String inusreListCode);
  
    /**
     * @description: 方法功能简述：根据保单号查清单信息
     * @author: 杨成程
     * @date: 2017/11/28 11:44
     * @param policyNo 
     * @return List<InsureMainList>
     * @throws
     */
    @Query(value = "select i from InsureMainList i where i.policyNo=:policyNo and i.validity in ('2','3')")
    public List<InsureMainList> findByPolicyNoAndValidity(@Param(value = "policyNo") String policyNo);

    @Query (value = "select i from InsureMainList i where i.inusreListCode=?1 ")
    public List<InsureMainList> queryByInsureListCode (String insureListCode);
    
    @Query(value = "select policyno FROM Plantingpolicylist d,insuremainlist e  WHERE  d.INUSRELISTCODE= e.INUSRELISTCODE  and e.VALIDITY in ('2') and d.VALIDITY in ('1')  and d.fname like :fname1  and d.fIdCard like :fIdCard ",nativeQuery=true)
    public List<String> findByCondition(@Param(value = "fname1") String fname1,@Param(value = "fIdCard") String fIdCard);

    @Query(value="select * from InsureMainList where policyNo =:policyNo  and VALIDITY in ('2','3') and (startTime <= to_date(:startTime ,'yyyy-mm-dd') and ENDTIME >= to_date( :startTime,'yyyy-mm-dd'))",nativeQuery=true)
    public List<InsureMainList> findByPolicynoAndDate(@Param(value = "policyNo") String policyNo,@Param(value = "startTime") String startTime);
    
    @Query(value = "select policyno FROM Plantingpolicylist d,insuremainlist e  WHERE  d.INUSRELISTCODE= e.INUSRELISTCODE  and e.VALIDITY in ('2') and d.VALIDITY in ('1')  and d.fname like :fname ",nativeQuery=true)
    public List<String> findByFname(@Param(value = "fname") String fname);
    
    @Query(value = "select policyno FROM Plantingpolicylist d,insuremainlist e  WHERE  d.INUSRELISTCODE= e.INUSRELISTCODE  and e.VALIDITY in ('2') and d.VALIDITY in ('1')  and d.fIdCard like :fIdCard ",nativeQuery=true)
    public List<String> findByFcardId(@Param(value = "fIdCard") String fIdCard);

    @Query(value = "select i from InsureMainList i where i.inusreListCode=?1 and i.proposalNo is not null ")
    public List<InsureMainList> queryAllByCondition(String insureListCode);

    @Query(value = "select i from InsureMainList i where i.inusreListCode=?1 and i.serialNo=?2")
    public InsureMainList queryByGisInsureListCode(String insureListCode,Integer serialNo);

    List<InsureMainList> findByGisInsureListCode(String gisInsureListCode);

    List<InsureMainList> findByInusreListCode(String insureListCode);

    @Query(value ="SELECT i.inusreListCode FROM InsureMainList i WHERE i.policyNo=:policyNo")
    public String findInusreListCodeByPolicyNo(@Param(value="policyNo")String policyNo);

    /**
     * 根据金禾清单号查询对应的保单号码
     *
     * @param gisInsureListCode 金禾清单号
     * @return 保单号集合
     * @date: 2018/4/12 17:03
     * @author: 何伟东
     */
    @Query(value = "select  g.policyNo from InsureMainList g where g.gisInsureListCode=:gisInsureListCode and g.policyNo is not null")
    List<String> findGisInsureListCode(@Param("gisInsureListCode") String gisInsureListCode);


    /**
     * 根据金禾清单号查询对应的保单号码
     *
     * @param gisInsureListCode 金禾清单号
     * @return 保单号集合
     * @date: 2018/4/12 17:03
     * @author: 何伟东
     */
    @Query(value = "select  g from InsureMainList g where g.gisInsureListCode in(:gisInsureListCode) and g.policyNo is not null")
    List<InsureMainList> findGisInsureListCodes(@Param("gisInsureListCode") List<String> gisInsureListCode);


    @Query(value = "select  g.gisInsureListCode from InsureMainList g where g.proposalNo in(:proposalNos) and g.proposalNo is not null and g.policyNo is not null ")
    List<String> findGisInsureListCode(@Param("proposalNos") List<String> proposalNos);

    @Query(value="select * from InsureMainList where policyNo =:policyNo  and VALIDITY in ('2','3') --注释掉后面条件 and (startTime <= to_date(:startTime ,'yyyy-mm-dd') and ENDTIME >= to_date( :startTime,'yyyy-mm-dd'))",nativeQuery=true)
    public List<InsureMainList> findByPolicynoAndDate(@Param(value = "policyNo") String policyNo);

    /**
     * 根据金禾清单号查询还未生成保单的清单信息
     *
     * @author: 何伟东
     * @date: 2018/4/17 15:23
     */
    @Query(value = "select distinct i.proposalNo from InsureMainList i where i.gisInsureListCode=:gisInsureListCode and i.policyNo is null")
    List<String> findProposalNosByGisInsureListCode(@Param(value = "gisInsureListCode") String gisInsureListCode);

    /**
     * 根据gis清单号码批量查询清单的信息
     *
     * @param gisInsureListCode
     * @return
     * @author: 何伟东
     * @date: 2018/4/21 17:57
     */
    @Query(value = "select g from InsureMainList g where g.gisInsureListCode in(:gisInsureListCode)")
    List<InsureMainList> findByGisInsureListCodes(@Param("gisInsureListCode") List<String> gisInsureListCode);

    /**
     * 根据投保单号码批量查询金禾清单号码
     *
     * @param proposalNos 投保单号码集合
     * @return gis清单号码集合
     * @author: 何伟东
     * @date: 2018/4/23 8:34
     */
    @Query(value = "select  g.gisInsureListCode from InsureMainList g where g.proposalNo in(:proposalNos)")
    List<String> findGisInsureListCodeByProposalNos(@Param("proposalNos") List<String> proposalNos);
    /**
     * 根据投保单号码批量查询金禾清单信息
     * @param proposalNos 投保单号码集合
     * @return gis清单号码集合
     * @author: 何伟东
     * @date: 2018/4/23 8:34
     */
    @Query(value = "select g from InsureMainList g where g.policyNo is not null and g.gisInsureListCode in (select j.gisInsureListCode from InsureMainList j where j.proposalNo in(:proposalNos))")
    List<InsureMainList> findAllByProposalNos(@Param("proposalNos") List<String> proposalNos);

    /**
     * 根据清单号码批量查询清单的信息
     *
     * @param gisInsureListCode
     * @return
     * @author: 陈道洋
     * @date: 2018/4/21 17:57
     */
    @Query(value = "select g from InsureMainList g where g.inusreListCode in(:list)")
    List<InsureMainList> findByInsureListCodes(@Param("list") HashSet list);
}