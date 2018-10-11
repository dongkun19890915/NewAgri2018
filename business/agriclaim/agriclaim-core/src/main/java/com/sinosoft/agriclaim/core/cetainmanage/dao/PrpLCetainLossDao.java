package com.sinosoft.agriclaim.core.cetainmanage.dao;

import com.sinosoft.agriclaim.core.cetainmanage.entity.PrpLCetainLoss;
import com.sinosoft.agriclaim.core.cetainmanage.entity.PrpLCetainLossKey;
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
 * @time  2017-11-08 05:36:28.690 
 * 确定损失表（无表名）Dao数据操作对象
 */
@Repository
public interface PrpLCetainLossDao extends JpaBaseDao<PrpLCetainLoss,PrpLCetainLossKey> {
}