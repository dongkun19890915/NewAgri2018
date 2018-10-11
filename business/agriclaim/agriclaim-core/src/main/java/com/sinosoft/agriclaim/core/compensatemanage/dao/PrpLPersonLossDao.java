package com.sinosoft.agriclaim.core.compensatemanage.dao;

import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLPersonLoss;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLPersonLossKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * 赔款计算金额表Dao数据操作对象
 */
@Repository
public interface PrpLPersonLossDao extends JpaBaseDao<PrpLPersonLoss,PrpLPersonLossKey> {

    @Query("select p from PrpLPersonLoss p where p.compensateNo=:compensateNo")
    List<PrpLPersonLoss> queryAllByCompensateNo(@Param("compensateNo") String compensateNo);
}