package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCdangerUnit;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCdangerUnitKey;
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
 * @time  2017-11-04 09:53:57.649 
 * 保单的危险单位划分表Dao数据操作对象
 */
@Repository
public interface PrpCdangerUnitDao extends JpaBaseDao<PrpCdangerUnit,PrpCdangerUnitKey> {
}