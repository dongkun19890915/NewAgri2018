package com.sinosoft.pms.core.config.dao.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.pms.core.config.entity.UtiPlatConfigRule;

public class UtiPlatConfigRuleSpecBuilder {
	/**
	 * 拼接个性查询的查询条件
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public static Specification<UtiPlatConfigRule> genCondition(UtiPlatConfigRule condition) throws Exception {
		return Specifications.<UtiPlatConfigRule>and()
                .eq(StringUtils.isNotEmpty(condition.getParamCode()),"paramCode", condition.getParamCode())
                .eq(StringUtils.isNotEmpty(condition.getSystemCode()),"systemCode",condition.getSystemCode())
                .build();
	}
}
