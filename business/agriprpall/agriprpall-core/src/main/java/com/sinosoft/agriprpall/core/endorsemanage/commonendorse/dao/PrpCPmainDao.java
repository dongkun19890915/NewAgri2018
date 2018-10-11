package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPmain;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPmainKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 03:06:48.016 
 * 保单基本信息表Dao数据操作对象
 */
@Repository
public interface PrpCPmainDao extends JpaBaseDao<PrpCPmain,PrpCPmainKey> {
    @Modifying
    @Transactional
    @Query(value = "delete from PrpCPmain p where p.policyNo=?1 ")
    public void deleteAllByCondition(String policyNo);
}