package com.sinosoft.agriprpall.core.proposalmanage.dao;

import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTengage;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTengageKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail yanghang@sinosoft.com.cn
 * @time  2017-10-19 06:31:19.937 
 * 特别约定表Dao数据操作对象
 */
@Repository
public interface PrpTengageDao extends JpaBaseDao<PrpTengage,PrpTengageKey> {

    /**
     * @description: 根据投保单号查询特别约定信息
     * @author: 何伟东
     * @date: 2017/10/22 15:26
     * @param proposalNo
     * @return
     */
    @Query(value = "select pt from PrpTengage pt where pt.proposalNo=:proposalNo and (pt.clauseCode like 'T%' or pt.clauseCode like 'L%' or pt.clauseCode like 'S%' or pt.clauseCode like 'G%') order by pt.serialNo")
    public List<PrpTengage> findByProposalNo(@Param(value = "proposalNo") String proposalNo);

    /**
     * 根据投保单号删除信息
     * @author: 田健
     * @date: 2018/4/12 15:23
     * @param proposalNo 投保单号
     */
    @Modifying
    @Transactional
    @Query(value = "delete from PrpTengage p where p.proposalNo=:proposalNo")
    void deleteByProposalNo(@Param("proposalNo") String proposalNo);
}