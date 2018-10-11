package com.sinosoft.agriprpall.core.proposalmanage.dao;

import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTcoinsDetail;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTcoinsDetailKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 05:54:45.680 
 * 共保明细信息表Dao数据操作对象
 */
@Repository
public interface PrpTcoinsDetailDao extends JpaBaseDao<PrpTcoinsDetail,PrpTcoinsDetailKey> {
    /**
     * 根据投保单号删除信息
     * @author: 田健
     * @date: 2018/4/12 15:20
     * @param proposalNo 投保单号
     */
    @Modifying
    @Transactional
    @Query(value = "delete from PrpTcoinsDetail p where p.proposalNo=:proposalNo")
    void deleteByProposalNo(@Param("proposalNo") String proposalNo);
}