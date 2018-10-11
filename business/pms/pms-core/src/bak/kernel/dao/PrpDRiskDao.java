package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.kernel.entity.PrpDRisk;
import com.sinosoft.pms.core.kernel.entity.PrpDRiskKey;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail yinqingzhu
 * @time  2016-10-12 19:47:01.205 
 * 产品定义表-PrpDRisk  数据操作接口类
 */
@Repository
public interface PrpDRiskDao extends JpaBaseDao<PrpDRisk,PrpDRiskKey> {

}