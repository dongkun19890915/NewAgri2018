package com.sinosoft.dms.core.customer.dao;

import com.sinosoft.dms.core.customer.entity.PrpDcustomLevelTrace;
import com.sinosoft.dms.core.customer.entity.PrpDcustomLevelTraceKey;
import com.sinosoft.dms.core.customer.entity.PrpDcustomerIdv;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 02:23:45.341 
 * 客户风险等级轨迹表Dao数据操作对象
 */
@Repository
public interface PrpDcustomLevelTraceDao extends JpaBaseDao<PrpDcustomLevelTrace,PrpDcustomLevelTraceKey> {

    /**
     * @description 按照insuredCode查询最后一条客户风险等级
     * @param customerCode
     * @return
     * @author 王心洋
     * @date 2017年10月30日 12:00
     */
    @Query(value ="select d from PrpDcustomLevelTrace d where d.customerCode=:customerCode " +
            "and d.lineNo=(select max(t.lineNo) from PrpDcustomLevelTrace t where t.customerCode=:customerCode)")
    public PrpDcustomLevelTrace findRiskLevelByCode(@Param("customerCode") String customerCode);

    /**
     * @description: 客户风险等级轨迹表实体操作对象
     * @author: 宋振振
     * @date: 2017/11/3 14:13
     * @param customerCode\
     * @return PrpDcustomLevelTrace
     */
    @Query(value ="select d from PrpDcustomLevelTrace d where d.customerCode=:customerCode ")
    public PrpDcustomLevelTrace findPrpDcustomerIdvById(@Param("customerCode") String customerCode);
}