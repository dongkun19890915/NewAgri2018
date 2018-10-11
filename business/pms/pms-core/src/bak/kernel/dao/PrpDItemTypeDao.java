package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.kernel.entity.PrpDItemTypeKey;
import com.sinosoft.pms.core.kernel.entity.PrpDItemType;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail yinqingzhu
 * @time  2016-10-13 19:23:10.296 
 * 标的分类表-PrpDItemType  数据操作接口类
 */
@Repository
public interface PrpDItemTypeDao extends JpaBaseDao<PrpDItemType,PrpDItemTypeKey> {

}