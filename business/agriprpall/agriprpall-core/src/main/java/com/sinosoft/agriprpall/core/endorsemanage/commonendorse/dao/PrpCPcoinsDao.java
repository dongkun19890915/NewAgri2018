package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPcoins;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPcoinsKey;
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
 * 共保信息Dao数据操作对象
 */
@Repository
public interface PrpCPcoinsDao extends JpaBaseDao<PrpCPcoins,PrpCPcoinsKey> {
    @Query(value = "select p from PrpCPcoins p " +
            "where p.policyNo= ?1 " +
            "order by p.serialNo")
    public List<PrpCPcoins> queryAllByCondition(String policyNo);

    @Modifying
    @Transactional
    @Query(value = "delete from PrpCPcoins p where p.policyNo=?1 ")
    public void deleteAllByCondition(String policyNo);
}