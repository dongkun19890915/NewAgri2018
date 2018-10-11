package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingPolicyList_Old;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingPolicyList_OldKey;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlantingPolicyList_OldDao extends JpaBaseDao<PlantingPolicyList_Old, PlantingPolicyList_OldKey> {
    @Query(value="select u from PlantingPolicyList_Old u where u.inusreListCode=:inusreListCode")
    List<PlantingPolicyList_Old> findOLDByInusreListCode(String inusreListCode);
}
