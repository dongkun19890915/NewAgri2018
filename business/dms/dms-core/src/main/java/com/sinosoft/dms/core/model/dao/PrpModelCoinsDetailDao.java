package com.sinosoft.dms.core.model.dao;

import com.sinosoft.dms.core.model.entity.PrpModelCoinsDetail;
import com.sinosoft.dms.core.model.entity.PrpModelCoinsDetailKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrpModelCoinsDetailDao extends JpaBaseDao<PrpModelCoinsDetail,PrpModelCoinsDetailKey>{

    @Query(value = "select p from PrpModelCoinsDetail p where p.modelCode=:modelCode")
    public List<PrpModelCoinsDetail> queryByModelCode(@Param("modelCode") String modelCode);
}
