package com.sinosoft.agriclaim.core.businessutilmanage.dao;

import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLConfiguration;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLConfigurationKey;
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
 * @time  2017-12-25 10:18:44.285 
 * 条款公式配置表 Dao数据操作对象
 */
@Repository
public interface PrpLConfigurationDao extends JpaBaseDao<PrpLConfiguration,PrpLConfigurationKey> {
}