package com.sinosoft.agriprpall.core.proposalmanage.dao;

import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmainAgri;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmainAgriKey;
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
 * 农业险投保单信息表Dao数据操作对象
 */
@Repository
public interface PrpTmainAgriDao extends JpaBaseDao<PrpTmainAgri,PrpTmainAgriKey> {
    /**
     *  根据投保单号查询PrpTmainAgri
     * @author: 何伟东
     * @date: 2017/10/30 15:47
     * @param proposalNo 投保单号码
     * @return PrpTmainAgri信息
     */
    public List<PrpTmainAgri> findByProposalNo(String proposalNo);

    /**
     * 根据投保单号删除信息
     * @author: 田健
     * @date: 2018/4/12 15:14
     * @param proposalNo 投保单号
     */
    @Modifying
    @Transactional
    @Query(value = "delete from PrpTmainAgri p where p.proposalNo=:proposalNo")
    void deleteByProposalNo(@Param("proposalNo") String proposalNo);
}