package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCdangerCoins;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCdangerCoinsKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 09:53:57.649 
 * 共保危险单位表Dao数据操作对象
 */
@Repository
public interface PrpCdangerCoinsDao extends JpaBaseDao<PrpCdangerCoins,PrpCdangerCoinsKey> {

    @Query(value = "select p from PrpCdangerCoins p where p.policyNo=:policyNo ")
    public List<PrpCdangerCoins> queryByPolicyNos(@Param("policyNo") String policyNo);
}