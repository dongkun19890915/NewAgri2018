package com.sinosoft.dms.core.dict.dao.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sinosoft.dms.core.dict.entity.PrpDnewCode;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;

public class PrpDnewCodeSpecBuilder {
	/**
	 * 拼接个性查询的查询条件
	 * @param condition codecodelike(true为codecode模糊查询)
	 * @return
	 * @throws Exception
	 */
	public static Specification<PrpDnewCode> genCondition(PrpDnewCode condition,boolean codecodelike) throws Exception {
		if(!codecodelike){
			return Specifications.<PrpDnewCode>and()
	                .eq(StringUtils.isNotEmpty(condition.getCodeCode()),"codeCode", condition.getCodeCode())
	                .eq(StringUtils.isNotEmpty(condition.getCodeType()),"codeType",condition.getCodeType())
	                .eq(StringUtils.isNotEmpty(condition.getUpperCode()),"upperCode",condition.getUpperCode())
	                .eq(StringUtils.isNotEmpty(condition.getCodeCName()),"codeCName",condition.getCodeCName())
	                .eq(true,"validStatus","1")
	                .build();
		}else{
			return Specifications.<PrpDnewCode>and()
	                .like(StringUtils.isNotEmpty(condition.getCodeCode()),"codeCode", condition.getCodeCode()+"%")
	                .eq(StringUtils.isNotEmpty(condition.getCodeType()),"codeType",condition.getCodeType())
	                .eq(StringUtils.isNotEmpty(condition.getUpperCode()),"upperCode",condition.getUpperCode())
	                .like(StringUtils.isNotEmpty(condition.getCodeCName()),"codeCName",condition.getCodeCName()+"%")
	                .eq(true,"validStatus","1")
	                .build();
		}
	}
}
