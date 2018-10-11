package com.sinosoft.pms.core.kernel.dao.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.pms.api.kernel.dto.RiskQueryConditionDto;
import com.sinosoft.pms.core.kernel.entity.PrpDclause;
import com.sinosoft.pms.core.kernel.entity.PrpDrisk;

public class RiskSpecBuilder {

	/**
	 * @description 险种查询Specification
	 * @param clauseCode
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 下午5:05:19
	 */
	public static Specification<PrpDrisk> riskQuerySpecification(RiskQueryConditionDto riskQueryConditionDto) {
		return Specifications.<PrpDrisk>and().eq(StringUtils.isNotEmpty(riskQueryConditionDto.getRiskCode()), "riskCode", riskQueryConditionDto.getRiskCode())
				.eq(StringUtils.isNotEmpty(riskQueryConditionDto.getClassCode()), "classCode", riskQueryConditionDto.getClassCode())
				.like(StringUtils.isNotEmpty(riskQueryConditionDto.getRiskCName()), "riskCName", riskQueryConditionDto.getRiskCName() + "%")
				.eq(StringUtils.isNotEmpty(riskQueryConditionDto.getValidStatus()), "validStatus", riskQueryConditionDto.getValidStatus())
				.build();
	}

}
