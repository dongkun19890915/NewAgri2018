package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCinsured;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCinsuredKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-23 06:09:14.757
 * 保险人关系表Dao数据操作对象
 */
@Repository
public interface PrpCinsuredDao extends JpaBaseDao<PrpCinsured,PrpCinsuredKey> {

    public List<PrpCinsured> findByPolicyNoAndInsuredFlag(@Param(value = "policyNo") String policyNo,@Param(value = "insuredFlag") String insuredFlag);
    @Modifying
    @Transactional
    @Query(value = "delete from PrpCinsured p " +
            "where p.policyNo=?1 ")
    public void deleteAllByCondition(String policyNo);

    /**
     *  根据保单号查询prpCinsured表（投保人被保险人关系）信息
     * @author: 田慧
     * @date: 2017/11/20 16:18
     * @param policyNo 保单号
     * @return PrpCinsured的集合
     */
    @Query(value = "select p from PrpCinsured p where p.policyNo like :policyNo")
    public List<PrpCinsured> findByPolicyNoLike(@Param("policyNo") String policyNo);

    /**
     *  根据保单号、关系人标识查询prpCinsured表（投保人被保险人关系）信息
     * @author: 田慧
     * @date: 2017/11/20 16:55
     * @param policyNo 保单号
     * @param insuredFlag 关系人标识
     * @return PrpCinsured的集合
     */
    @Query(value = "select p from PrpCinsured p where p.policyNo like :policyNo AND p.insuredFlag=:insuredFlag")
    public List<PrpCinsured> queryByCondition(@Param("policyNo")String policyNo,@Param("insuredFlag")String insuredFlag);

    /**
     *  根据身份证查询PrpCinsuredDto 投保人被保险人关系Dto结果集
     * @author: 田慧
     * @date: 2017/11/22 10:20
     * @param policyNo 保单号
     * @param identifyNumber 身份证件号
     * @return 返回PrpCinsured的集合
     */
    @Query(value = "select p from PrpCinsured p where p.policyNo like :policyNo AND p.identifyNumber like :identifyNumber")
    public List<PrpCinsured> queryPolicyNoByID(@Param("policyNo")String policyNo,@Param("identifyNumber")String identifyNumber);

    /**
     * 根据保单号和familyNos查询满足条件的PrpCindured并放入集合中
     * @author: 王保良
     * @date: 2017/11/28 15:30
     * @param policyNo 保单号
     * @param str 在insured表中是serialNo 序号
     * @return List<PrpCinsured> 关系人表集合
     * @throws Exception
     */
    @Query(value = "select p from PrpCinsured p where p.policyNo=:policyNo and p.serialNo in :str ")
    public List<PrpCinsured> findAllByCondition(@Param("policyNo") String policyNo,@Param("str") String str);

    /**
     * 根据身份证号模糊查询被保险人信息
     * @author: 王保良
     * @date: 2018/3/31 18:14
     * @param map
     * @return
     * @throws Exception
     */
    @Query(value = "select p from PrpCinsured p where p.identifyNumber like :identifyNumber and p.identifyType='01'")
    public List<PrpCinsured> queryByIdentifyNumber(@Param("identifyNumber") String identifyNumber);

    @Query("select p from PrpCinsured p where p.policyNo=:policyNo ")
    public List<PrpCinsured> queryAllByPolicyNoAndInsuredName(@Param("policyNo")String policyNo);

    /**
     * 根据被保险人代码查询被保险人信息
     * @author: 王志文
     * @date: 2018/3/31 18:14
     * @param map
     * @return
     * @throws Exception
     */
    @Query("select p from PrpCinsured p where p.insuredCode = :insuredCode")
    public List<PrpCinsured> queryByInsuredCode(@Param("insuredCode") String insuredCode);
}