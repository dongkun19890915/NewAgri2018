package com.sinosoft.dms.core.dict.dao;

import com.sinosoft.dms.core.dict.entity.PrpDcertifycheck;
import com.sinosoft.dms.core.dict.entity.PrpDcertifycheckKey;
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
 * @time  2017-12-04 09:05:54.250 
 * 单证校验信息表Dao数据操作对象
 */
@Repository
public interface PrpDcertifycheckDao extends JpaBaseDao<PrpDcertifycheck,PrpDcertifycheckKey> {
}