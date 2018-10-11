package com.sinosoft.dms.core.model.dao;

import com.sinosoft.dms.core.model.entity.PrpModelFeeSub;
import com.sinosoft.dms.core.model.entity.PrpModelFeeSubKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrpModelFeeSubDao extends JpaBaseDao<PrpModelFeeSub,PrpModelFeeSubKey>{

    @Query(value = "select p from PrpModelFeeSub p where p.modelCode=:modelCode")
    public List<PrpModelFeeSub> queryByModelCode(@Param("modelCode")String modelCode);
}
