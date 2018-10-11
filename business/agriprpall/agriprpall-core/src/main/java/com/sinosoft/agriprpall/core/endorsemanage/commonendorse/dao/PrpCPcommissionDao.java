package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPcommission;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPcommissionKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:00:38.844 
 * 手续费表Dao数据操作对象
 */
@Repository
public interface PrpCPcommissionDao extends JpaBaseDao<PrpCPcommission,PrpCPcommissionKey> {
    /**
     * 根据保单号删除
     * @author: 王保良
     * @date: 2017/12/13 17:43
     * @param policyNo 批单号
     * @return void
     */
    @Modifying
    @Transactional
    @Query(value = "delete from PrpCPcommission p where p.policyNo=:policyNo")
    public void deleteByPolicyNo(@Param("policyNo")String policyNo);
}