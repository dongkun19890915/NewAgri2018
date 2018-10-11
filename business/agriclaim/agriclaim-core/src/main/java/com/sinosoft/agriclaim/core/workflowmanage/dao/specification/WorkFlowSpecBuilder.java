package com.sinosoft.agriclaim.core.workflowmanage.dao.specification;


import org.springframework.data.jpa.domain.Specification;

import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfFlowMain;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfModelUse;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;

/**
 * @description 工作流拼装查询条件
 * @author yanghang
 * @date 2017年10月20日riskCode
 */
public class WorkFlowSpecBuilder {
	public static Specification<SwfModelUse> modelSpecification(String riskCode, String comCode) {
		return Specifications.<SwfModelUse>and().eq(StringUtils.isNotEmpty(riskCode), "riskCode", riskCode)
				.eq(StringUtils.isNotEmpty(comCode), "comCode", comCode)
				.eq("modelType", "01").build();
	}
	public static Specification<SwfFlowMain> checkFlowCloseSpecification(String flowID) {
		return Specifications.<SwfFlowMain>and().eq(StringUtils.isNotEmpty(flowID), "flowId", flowID)
				.eq("flowStatus", "0").build();
	}
}
