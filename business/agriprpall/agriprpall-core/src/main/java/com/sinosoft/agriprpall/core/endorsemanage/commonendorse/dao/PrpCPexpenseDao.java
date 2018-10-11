package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPexpense;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPexpenseKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 03:06:48.016 
 * 保单费用信息表Dao数据操作对象
 */
@Repository
public interface PrpCPexpenseDao extends JpaBaseDao<PrpCPexpense,PrpCPexpenseKey> {
    @Query(value = "select p from PrpCPexpense p where p.policyNo= ?1")
    public PrpCPexpense queryAllByCondition(String policyNo);

    @Modifying
    @Transactional
    @Query(value = "delete from PrpCPexpense p where p.policyNo=?1")
    public void deleteAllByCondition(String policyNo);
}