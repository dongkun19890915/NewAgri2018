package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCaddress;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCaddressKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 09:56:41.944 
 * 保单保险地址表Dao数据操作对象
 */
@Repository
public interface PrpCaddressDao extends JpaBaseDao<PrpCaddress,PrpCaddressKey> {

     public List<PrpCaddress> findPrpCaddressByPolicyNo(String policyNo);

     @Modifying
     @Transactional
     @Query(value = "delete from PrpCaddress p where p.policyNo=:policyNo")
     public void deleteByPolicyNo(@Param("policyNo") String policyNo);
}