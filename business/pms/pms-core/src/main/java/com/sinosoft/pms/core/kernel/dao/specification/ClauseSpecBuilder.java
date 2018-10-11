package com.sinosoft.pms.core.kernel.dao.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.pms.api.kernel.dto.ClauseQueryConditionDto;
import com.sinosoft.pms.core.kernel.entity.PrpDclause;
import com.sinosoft.pms.core.kernel.entity.PrpDrisk;

public class ClauseSpecBuilder {

	/**
	 * @description clauseCode查询Specification
	 * @param clauseCode
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 下午5:05:19
	 */
	public static Specification<PrpDclause> clauseCodeSpecification(String clauseCode) {
		return Specifications.<PrpDclause>and().eq(StringUtils.isNotEmpty(clauseCode), "clauseCode", clauseCode)
				.build();
	}
	
	/**
	 * @description 条款查询Specification
	 * @param clauseQueryConditionDto
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 下午5:05:19
	 */
	public static Specification<PrpDclause> clauseQuerySpecification(ClauseQueryConditionDto clauseQueryConditionDto) {
		return Specifications.<PrpDclause>and().eq(StringUtils.isNotEmpty(clauseQueryConditionDto.getClauseCode()), "clauseCode", clauseQueryConditionDto.getClauseCode())
				.eq(StringUtils.isNotEmpty(clauseQueryConditionDto.getClassCode()), "classCode", clauseQueryConditionDto.getClassCode())
				.like(StringUtils.isNotEmpty(clauseQueryConditionDto.getClauseCName()), "clauseCName", clauseQueryConditionDto.getClauseCName() + "%")
				.like(StringUtils.isNotEmpty(clauseQueryConditionDto.getConText()), "conText", clauseQueryConditionDto.getConText() + "%")
				.eq(StringUtils.isNotEmpty(clauseQueryConditionDto.getValidStatus()), "validStatus", clauseQueryConditionDto.getValidStatus())
				.build();
	}

}
