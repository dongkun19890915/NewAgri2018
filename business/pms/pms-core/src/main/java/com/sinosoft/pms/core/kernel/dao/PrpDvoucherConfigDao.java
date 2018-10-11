package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.kernel.entity.PrpDvoucherConfig;
import com.sinosoft.pms.core.kernel.entity.PrpDvoucherConfigKey;
import org.springframework.stereotype.Repository;

@Repository
public interface PrpDvoucherConfigDao extends JpaBaseDao<PrpDvoucherConfig,PrpDvoucherConfigKey>{
}
