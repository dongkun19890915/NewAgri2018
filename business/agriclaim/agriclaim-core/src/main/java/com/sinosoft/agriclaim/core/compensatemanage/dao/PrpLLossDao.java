package com.sinosoft.agriclaim.core.compensatemanage.dao;

import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLLoss;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLLossKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * 赔付标的信息表Dao数据操作对象
 */
@Repository
public interface PrpLLossDao extends JpaBaseDao<PrpLLoss,PrpLLossKey> {

    /**
     *
     * @description 根据业务号查询PrpLLoss表
     * @author 周柯宇
     * @date 2018年1月26日 下午3:49:27
     * @param businessNo
     * @return List<PrpLLoss>
     * @Throws Exception
     */
    @Query("select p from PrpLLoss p where p.compensateNo=:businessNo ")
    List<PrpLLoss> findByCompensateNo(@Param("businessNo") String businessNo);
}