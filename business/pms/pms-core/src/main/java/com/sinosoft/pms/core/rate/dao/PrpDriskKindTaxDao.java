package com.sinosoft.pms.core.rate.dao;

import com.sinosoft.pms.core.rate.entity.PrpDriskKindTax;
import com.sinosoft.pms.core.rate.entity.PrpDriskKindTaxKey;
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
 * @time  2017-08-29 07:14:25.063 
 * 险种险别增值税基础税率配置表Dao数据操作对象
 */
@Repository
public interface PrpDriskKindTaxDao extends JpaBaseDao<PrpDriskKindTax,PrpDriskKindTaxKey> {
}