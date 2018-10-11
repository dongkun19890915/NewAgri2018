package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;


import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemAgri;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemAgriKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-26 00:32:45.064 
 * PrpCitemAgriDao数据操作对象
 */
@Repository
public interface PrpCitemAgriDao extends JpaBaseDao<PrpCitemAgri,PrpCitemAgriKey> {
    @Modifying
    @Transactional
    @Query(value = "delete from PrpCitemAgri p " +
            "where p.policyNo=?1 ")
    public void deleteAllByCondition(String policyNo);
}