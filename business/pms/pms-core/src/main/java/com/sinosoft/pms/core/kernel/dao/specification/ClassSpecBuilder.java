package com.sinosoft.pms.core.kernel.dao.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.pms.api.kernel.dto.ClassQueryConditionDto;
import com.sinosoft.pms.core.kernel.entity.PrpDclass;

public class ClassSpecBuilder {

	/**
	 * @description 险类查询Specification 
	 * @param classQueryConditionDto
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 下午5:40:43
	 */
	public static Specification<PrpDclass> classQuerySpecification(ClassQueryConditionDto classQueryConditionDto) {
		return Specifications.<PrpDclass>and().eq(StringUtils.isNotEmpty(classQueryConditionDto.getClassCode()), "classCode", classQueryConditionDto.getClassCode())
				.like(StringUtils.isNotEmpty(classQueryConditionDto.getClassName()), "className", classQueryConditionDto.getClassName() + "%")
				.eq(StringUtils.isNotEmpty(classQueryConditionDto.getValidStatus()), "validStatus", classQueryConditionDto.getValidStatus())
				.build();
	}

}
