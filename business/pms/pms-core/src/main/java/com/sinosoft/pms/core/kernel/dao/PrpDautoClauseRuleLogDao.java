package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.pms.core.kernel.entity.PrpDautoClauseRuleLog;
import com.sinosoft.pms.core.kernel.entity.PrpDautoClauseRuleLogKey;
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
 * @time  2017-09-13 02:29:04.419 
 * 自动生成特约校验规则表日志表Dao数据操作对象
 */
@Repository
public interface PrpDautoClauseRuleLogDao extends JpaBaseDao<PrpDautoClauseRuleLog,PrpDautoClauseRuleLogKey> {
}