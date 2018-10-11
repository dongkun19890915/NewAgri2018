package com.sinosoft.pms.core.filesmodel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.filesmodel.entity.PrpDfilesModel;
import com.sinosoft.pms.core.filesmodel.entity.PrpDfilesModelKey;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail handongwei@sinosoft.com.cn
 * @time  2016-09-19 10:53:22.125 
 * PrpDexcelModel  数据操作接口类
 */
@Repository
public interface PrpDfilesModelDao extends JpaBaseDao<PrpDfilesModel,PrpDfilesModelKey>{
    
}