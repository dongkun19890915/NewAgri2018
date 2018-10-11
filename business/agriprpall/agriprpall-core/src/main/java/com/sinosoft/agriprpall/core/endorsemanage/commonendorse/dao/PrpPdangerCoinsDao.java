package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPdangerCoins;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPdangerCoinsKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:07:09.217 
 * 共保危险单位表Dao数据操作对象
 */
@Repository
public interface PrpPdangerCoinsDao extends JpaBaseDao<PrpPdangerCoins,PrpPdangerCoinsKey> {
}