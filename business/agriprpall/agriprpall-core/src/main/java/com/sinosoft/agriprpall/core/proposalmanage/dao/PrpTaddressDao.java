package com.sinosoft.agriprpall.core.proposalmanage.dao;

import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTaddress;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTaddressKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * 投保单地址信息表Dao数据操作对象
 */
@Repository
public interface PrpTaddressDao extends JpaBaseDao<PrpTaddress,PrpTaddressKey> {
    /**
     * 根据投保单号删除信息
     * @author: 田健
     * @date: 2018/4/12 15:37
     * @param proposalNo 投保单号
     */
    @Modifying
    @Transactional
    @Query(value = "delete from PrpTaddress p where p.proposalNo=:proposalNo")
    void deleteByProposalNo(@Param("proposalNo") String proposalNo);
}