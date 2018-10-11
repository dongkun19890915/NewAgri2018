package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPaddress;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPaddressKey;
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
 * @time  2017-10-24 03:06:48.016 
 * 地址信息表Dao数据操作对象
 */
@Repository
public interface PrpCPaddressDao extends JpaBaseDao<PrpCPaddress,PrpCPaddressKey> {

    @Query(value = "select p from PrpCPaddress p where p.policyNo=:policyNo")
    public List<PrpCPaddress> findPrpCPaddressByPolicyNo(@Param("policyNo") String policyNo);

    @Modifying
    @Transactional
    @Query(value = "delete from PrpCPaddress p where p.policyNo=?1 ")
    public void deleteAllByCondition(String policyNo);
}