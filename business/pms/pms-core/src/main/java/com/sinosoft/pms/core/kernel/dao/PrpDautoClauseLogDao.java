package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.pms.core.kernel.entity.PrpDautoClauseLog;
import com.sinosoft.pms.core.kernel.entity.PrpDautoClauseLogKey;
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
 * @time  2017-09-12 12:28:59.683 
 * 自动生成特约主表日志表Dao数据操作对象
 */
@Repository
public interface PrpDautoClauseLogDao extends JpaBaseDao<PrpDautoClauseLog,PrpDautoClauseLogKey> {
}