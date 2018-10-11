package com.sinosoft.dms.core.model.dao;

import com.sinosoft.dms.core.model.entity.PrpModelPlanSub;
import com.sinosoft.dms.core.model.entity.PrpModelPlanSubKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrpModelPlanSubDao extends JpaBaseDao<PrpModelPlanSub,PrpModelPlanSubKey> {

    @Query(value ="select p from PrpModelPlanSub p where p.modelCode=:modelCode")
    public List<PrpModelPlanSub> queryByModelCode(@Param("modelCode") String modelCode);
}
