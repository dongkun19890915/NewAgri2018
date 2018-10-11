package com.sinosoft.agriprpall.core.proposalmanage.dao;

import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTinsured;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTinsuredKey;
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
 * @time  2017-10-18 03:10:49.566 
 * 保险关系人表Dao数据操作对象
 */
@Repository
public interface PrpTinsuredDao extends JpaBaseDao<PrpTinsured,PrpTinsuredKey> {
    /**
     *  根据投保单号查询prpTinsured表信息
     * @author: 田慧
     * @date: 2017/11/20 13:37
     * @param proposalNo 投保单号
     * @return 返回PrpTinsured的集合
     */
    public List<PrpTinsured> findByProposalNoLike(String proposalNo);

    /**
     *  根据投保单号、关系人标识查询prpTinsured保险关系人表信息
     * @author: 田慧
     * @date: 2017/11/20 13:48
     * @param proposalNo 投保单号
     * @param insuredFlag 关系人标识
     * @return PrpTinsured 返回保险关系人表的集合
     */
    @Query(value = "select p from PrpTinsured p where p.proposalNo like :proposalNo AND p.insuredFlag =:insuredFlag")
    public List<PrpTinsured> queryByCondition(@Param("proposalNo") String proposalNo, @Param("insuredFlag") String insuredFlag);

    /**
     * 根据投保单号删除信息
     * @author: 田健
     * @date: 2018/4/12 15:17
     * @param proposalNo 投保单号
     */
    @Modifying
    @Transactional
    @Query(value = "delete from PrpTinsured p where p.proposalNo=:proposalNo")
    void deleteByProposalNo(@Param("proposalNo") String proposalNo);
}