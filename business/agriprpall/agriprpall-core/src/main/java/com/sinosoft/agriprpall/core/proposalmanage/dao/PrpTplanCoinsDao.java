package com.sinosoft.agriprpall.core.proposalmanage.dao;

import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTplanCoins;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTplanCoinsKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * 共保方收费计划表Dao数据操作对象
 */
@Repository
public interface PrpTplanCoinsDao extends JpaBaseDao<PrpTplanCoins,PrpTplanCoinsKey> {
    /**
     *  根据投保单号删除信息
     * @author: 田健
     * @date: 2018/4/12 15:21
     * @param proposalNo 投保单号
     */
    @Modifying
    @Transactional
    @Query(value = "delete from PrpTplanCoins p where p.proposalNo=:proposalNo")
    void deleteByProposalNo(@Param("proposalNo") String proposalNo);
}