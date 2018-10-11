package com.sinosoft.agriclaim.core.individuation.dao;


import com.sinosoft.agriclaim.core.individuation.entity.PrpLsumpay;
import com.sinosoft.agriclaim.core.individuation.entity.PrpLsumpayKey;
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
 * @time  2017-11-22 07:48:26.564 
 * 账户信息表Dao数据操作对象
 */
@Repository
public interface PrpLsumpayDao extends JpaBaseDao<PrpLsumpay,PrpLsumpayKey> {

}