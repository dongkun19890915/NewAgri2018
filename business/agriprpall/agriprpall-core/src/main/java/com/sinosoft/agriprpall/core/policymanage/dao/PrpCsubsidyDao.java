package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCsubsidy;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCsubsidyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * 补贴表Dao数据操作对象
 */
@Repository
public interface PrpCsubsidyDao extends JpaBaseDao<PrpCsubsidy,PrpCsubsidyKey> {
    @Modifying
    @Transactional

    @Query(value = "delete from PrpCsubsidy p " +
            "where p.policyNo=?1 ")
    public void deleteAllByCondition(String policyNo);
}