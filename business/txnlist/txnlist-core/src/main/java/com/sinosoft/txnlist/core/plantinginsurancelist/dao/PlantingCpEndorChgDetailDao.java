package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingCpEndorChgDetail;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingCpEndorChgDetailKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/**
*清单批改持久化接口
* @Author: 陈道洋
* @Date: 2017/11/17 10:26
*/
@Repository
public interface PlantingCpEndorChgDetailDao extends JpaBaseDao<PlantingCpEndorChgDetail,PlantingCpEndorChgDetailKey> {


    @Modifying
    @Transactional
    @Query(value = " DELETE FROM PlantingCpEndorChgDetail p WHERE p.inusreListCode=:inusreListCode")
    public void deletePlantingCpEndorChgDetail(@Param("inusreListCode") String inusreListCode);

    public List<PlantingCpEndorChgDetail> queryAllByInusreListCode(String inusreListCode);

//    @Query(value = "select p from PlantingCpEndorChgDetail p where p.inusreListCode=?1")
//    public List<PlantingCpEndorChgDetail> queryAllByInsureListCode(String insureListCode)throws Exception;
}