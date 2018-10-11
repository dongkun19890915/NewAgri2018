package com.sinosoft.agriprpall.core.proposalmanage.dao;

import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTplan;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTplanKey;
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
 * 收费计划表Dao数据操作对象
 */
@Repository
public interface PrpTplanDao extends JpaBaseDao<PrpTplan,PrpTplanKey> {
    /**
     *  根据投保单号查询prpTplan 收费计划表详细信息
     * @author: 田慧
     * @date: 2017/11/20 9:26
     * @param proposalNo 投保单号
     * @return 返回PrpTplan收费计划表集合
     */
    public List<PrpTplan> findByProposalNoLike(String proposalNo);

    /**
     * 根据投保单号删除信息
     * @author: 田健
     * @date: 2018/4/12 15:34
     * @param proposalNo 投保单号
     */
    @Modifying
    @Transactional
    @Query(value = "delete from PrpTplan p where p.proposalNo=:proposalNo")
    void deleteByProposalNo(@Param("proposalNo") String proposalNo);
}