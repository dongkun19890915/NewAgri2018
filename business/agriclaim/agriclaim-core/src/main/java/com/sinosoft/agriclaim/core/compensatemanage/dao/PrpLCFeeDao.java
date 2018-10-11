package com.sinosoft.agriclaim.core.compensatemanage.dao;

import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCFee;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCFeeKey;
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
 * @time  2017-11-08 05:40:44.225 
 * 赔款计算金额表Dao数据操作对象
 */
@Repository
public interface PrpLCFeeDao extends JpaBaseDao<PrpLCFee,PrpLCFeeKey> {
}