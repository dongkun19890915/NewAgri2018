package com.sinosoft.agriclaim.core.prepaymanage.dao;

import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPreCharge;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPreChargeKey;
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
 * @time  2017-11-08 05:44:02.119 
 * 预赔费用信息表Dao数据操作对象
 */
@Repository
public interface PrpLPreChargeDao extends JpaBaseDao<PrpLPreCharge,PrpLPreChargeKey> {
    /**
     * 根据预赔号查询赔付费用信息
     * @param precompensateNo
     * @return
     */
    @Query(value = "select p from PrpLPreCharge p where p.precompensateNo=:precompensateNo")
    List<PrpLPreCharge> findAllByPrecompensateNo(@Param("precompensateNo")String precompensateNo);
    /**
     * 根据预赔号查询赔付费用信息
     * @param precompensateNo
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "delete from PrpLPreCharge p where p.precompensateNo=:precompensateNo")
    List<PrpLPreCharge> deleteByPrecompensateNo(@Param("precompensateNo")String precompensateNo);
}