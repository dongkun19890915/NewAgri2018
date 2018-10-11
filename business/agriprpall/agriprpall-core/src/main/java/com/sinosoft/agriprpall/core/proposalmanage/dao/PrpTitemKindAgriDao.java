package com.sinosoft.agriprpall.core.proposalmanage.dao;

import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTitemKindAgri;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTitemKindAgriKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 03:10:49.566 
 * 农险标的信息表Dao数据操作对象
 */
@Repository
public interface PrpTitemKindAgriDao extends JpaBaseDao<PrpTitemKindAgri,PrpTitemKindAgriKey> {
    /**
     * 根据投保单号删除信息
     * @author: 田健
     * @date: 2018/4/12 15:27
     * @param proposalNo 投保单号
     */
    @Modifying
    @Transactional
    @Query(value = "delete from PrpTitemKindAgri p where p.proposalNo=:proposalNo")
    void deleteByProposalNo(@Param("proposalNo") String proposalNo);
}