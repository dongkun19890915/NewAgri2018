package com.sinosoft.agriclaim.core.individuation.dao;


import com.sinosoft.agriclaim.core.individuation.entity.PrpLsumpayLog;
import com.sinosoft.agriclaim.core.individuation.entity.PrpLsumpayLogKey;
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
 * @time  2017-11-22 08:23:52.676 
 * 支付信息轨迹表Dao数据操作对象
 */
@Repository
public interface PrpLsumpayLogDao extends JpaBaseDao<PrpLsumpayLog,PrpLsumpayLogKey> {
}