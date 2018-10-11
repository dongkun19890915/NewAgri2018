package com.sinosoft.dms.core.model.dao;

import com.sinosoft.dms.core.model.entity.PrpModelPlanCoins;
import com.sinosoft.dms.core.model.entity.PrpModelPlanCoinsKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrpModelPlanCoinsDao extends JpaBaseDao<PrpModelPlanCoins,PrpModelPlanCoinsKey>{

    @Query(value = "select p from PrpModelPlanCoins p where p.modelCode=:modelCode")
    public List<PrpModelPlanCoins> queryByModelCode(@Param("modelCode") String modelCode);
}
