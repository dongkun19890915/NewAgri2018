package com.sinosoft.dms.core.dict.dao.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sinosoft.dms.core.dict.entity.PrpDnewType;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;

public class PrpDnewTypeSpecBuilder {
	/**
	 * 拼接个性查询的查询条件
	 * 
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public static Specification<PrpDnewType> genCondition(PrpDnewType condition)
			throws Exception {
		return Specifications.<PrpDnewType>and()
				.eq(StringUtils.isNotEmpty(condition.getCodeType()), "codeType", condition.getCodeType())
				.eq(StringUtils.isNotEmpty(condition.getNewCodeType()), "newCodeType", condition.getNewCodeType()).build();
	}
}
