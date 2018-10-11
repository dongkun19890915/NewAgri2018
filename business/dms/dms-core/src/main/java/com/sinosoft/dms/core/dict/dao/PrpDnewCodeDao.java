package com.sinosoft.dms.core.dict.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sinosoft.dms.core.dict.entity.PrpDnewCode;
import com.sinosoft.dms.core.dict.entity.PrpDnewCodeKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:01.505 
 * 通用代码表Dao数据操作对象
 */
@Repository
public interface PrpDnewCodeDao extends JpaBaseDao<PrpDnewCode,PrpDnewCodeKey> {
//	@Query(value="select o from PrpDnewCode o where o.codeType = :codeType and o.validStatus = '1' and "
//			+ " exists(select 1 from PrpDnewCodeRisk t where o.codeType = t.codeType and o.codeCode = t.codeCode"
//			+ " and (t.riskCode = :riskCode or t.riskCode = '0000') )")
//	public List<PrpDnewCode> queryNewCodeListByRiskCode(@Param("codeType") String codeType, @Param("riskCode") String riskCode);

	@Query(value="select o from PrpDnewCode o")
	public List<PrpDnewCode> queryNewCodeListByRiskCode();
}