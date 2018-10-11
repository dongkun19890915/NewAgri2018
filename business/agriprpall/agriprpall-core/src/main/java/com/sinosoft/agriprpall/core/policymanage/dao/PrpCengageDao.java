package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCengage;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCengageKey;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTengage;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PostRemove;
import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * 特别约定表Dao数据操作对象
 */
@Repository
public interface PrpCengageDao extends JpaBaseDao<PrpCengage,PrpCengageKey> {
    @Modifying
    @Transactional
    @Query(value = "delete  from PrpCengage p " +
            "where p.policyNo= ?1 " )
    public void deleteAllByCondition(String policyNo);

    /**
     * @description: （保单抄件通过保单号查找特别约定）
     * @author: 王志文
     * @date: 2017/11/16 8:51
     * @param policyNo
     * @return
     */
    @Query("select p from PrpCengage p where p.policyNo =:policyNo ")
    List<PrpCengage> queryEngageListByPolicyNo(@Param("policyNo") String policyNo);
    /**
     * 根据保单号，编码查询免赔率
     * @author: 田健
     * @date: 2018/4/13 12:32
     * @param policyNo 保单号
     * @param clauseCode 免赔率编码
     * @return PrpCengage集合
     */
    @Query("select p from PrpCengage p where p.policyNo =:policyNo and p.clauseCode =:clauseCode")
    List<PrpCengage> queryAllByPolicyNoAndClauseCode(@Param("policyNo") String policyNo,@Param("clauseCode") String clauseCode);
    /**
     * @description: 根据投保单号查询特别约定信息
     * @author: 刘曼曼
     * @date: 2018/03/21 15:26
     * @param policyNo
     * @return
     */
    @Query(value = "select pt from PrpCengage pt where pt.policyNo=:policyNo and (pt.clauseCode like 'T%' or pt.clauseCode like 'L%' or pt.clauseCode like 'S%' or pt.clauseCode like 'G%') order by pt.serialNo")
    public List<PrpCengage> findByPolicyNo(@Param(value = "policyNo") String policyNo);
}