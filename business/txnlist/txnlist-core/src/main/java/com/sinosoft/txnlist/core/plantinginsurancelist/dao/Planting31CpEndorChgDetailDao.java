package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.txnlist.core.plantinginsurancelist.entity.Planting31CpEndorChgDetail;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.Planting31CpEndorChgDetailKey;
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
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * planting31cpendorchgdetailDao数据操作对象
 */
@Repository
public interface Planting31CpEndorChgDetailDao extends JpaBaseDao<Planting31CpEndorChgDetail,Planting31CpEndorChgDetailKey> {
    @Modifying
    @Transactional
    @Query(value = " DELETE FROM Planting31CpEndorChgDetail p WHERE p.inusreListCode=:inusreListCode")
    public void deletePlanting31CpEndorChgDetail(@Param("inusreListCode") String inusreListCode);

    @Query(value = "select p from Planting31CpEndorChgDetail p where p.inusreListCode=?1")
    public List<Planting31CpEndorChgDetail> queryAllByInusreListCode(String insureListCode)throws Exception;
}