package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.pms.core.kernel.entity.PrpDautoClause;
import com.sinosoft.pms.core.kernel.entity.PrpDautoClauseKey;
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
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-09-12 12:27:57.599 
 * 自动生成特约主表Dao数据操作对象
 */
@Repository
public interface PrpDautoClauseDao extends JpaBaseDao<PrpDautoClause,PrpDautoClauseKey> {

}