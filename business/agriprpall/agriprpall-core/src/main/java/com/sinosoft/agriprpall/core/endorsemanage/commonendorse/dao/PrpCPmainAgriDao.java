package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPmainAgri;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPmainAgriKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-26 08:12:17.248 
 * 农业险保单信息Dao数据操作对象
 */
@Repository
public interface PrpCPmainAgriDao extends JpaBaseDao<PrpCPmainAgri,PrpCPmainAgriKey> {
    @Modifying
    @Transactional
    @Query(value = "delete from PrpCPmainAgri p where p.policyNo=?1 ")
    public void deleteAllByCondition(String policyNo);
}