package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPsubsidy;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPsubsidyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 03:06:48.016 
 * 政府补贴表Dao数据操作对象
 */
@Repository
public interface PrpCPsubsidyDao extends JpaBaseDao<PrpCPsubsidy,PrpCPsubsidyKey> {
    @Query(value = "select p from PrpCPsubsidy p " +
            "where p.policyNo=?1 " +
            "order by p.subsidyCode,p.subsidyType")
    public List<PrpCPsubsidy> queryAllByCondition(String policyNo);

    @Modifying
    @Transactional
    @Query(value = "delete from PrpCPsubsidy p where p.policyNo=?1 ")
    public void deleteAllByCondition(String policyNo);

}