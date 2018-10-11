package com.sinosoft.dms.core.model.dao;

import com.sinosoft.dms.core.model.entity.PrpModelSubsidy;
import com.sinosoft.dms.core.model.entity.PrpModelSubsidyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrpModelSubsidyDao extends JpaBaseDao<PrpModelSubsidy,PrpModelSubsidyKey> {

    @Query(value = "select p from PrpModelSubsidy p where  p.modelCode=:modelCode")
    public List<PrpModelSubsidy> queryByModelCode(@Param("modelCode") String modelCode);
}
