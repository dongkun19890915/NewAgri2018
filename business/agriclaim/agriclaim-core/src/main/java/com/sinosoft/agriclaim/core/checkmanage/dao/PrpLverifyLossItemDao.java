package com.sinosoft.agriclaim.core.checkmanage.dao;

import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLverifyLossItem;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLverifyLossItemKey;
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
 * @time  2017-11-17 08:28:31.346 
 * 核损明细表Dao数据操作对象
 */
@Repository
public interface PrpLverifyLossItemDao extends JpaBaseDao<PrpLverifyLossItem,PrpLverifyLossItemKey> {
}