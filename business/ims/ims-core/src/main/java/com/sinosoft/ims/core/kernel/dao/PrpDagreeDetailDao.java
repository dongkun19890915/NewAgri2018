package com.sinosoft.ims.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.ims.core.kernel.entity.PrpDagreeDetail;
import com.sinosoft.ims.core.kernel.entity.PrpDagreeDetailKey;
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
 * @time  2017-11-05 01:10:12.703 
 * PrpDagreeDetailDao数据操作对象
 */
@Repository
public interface PrpDagreeDetailDao extends JpaBaseDao<PrpDagreeDetail,PrpDagreeDetailKey> {
}