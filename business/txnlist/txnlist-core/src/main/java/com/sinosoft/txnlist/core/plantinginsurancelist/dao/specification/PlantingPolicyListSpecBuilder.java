package com.sinosoft.txnlist.core.plantinginsurancelist.dao.specification;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingPolicyList;
import org.springframework.data.jpa.domain.Specification;

public class PlantingPolicyListSpecBuilder {
    public static Specification<PlantingPolicyList> Specification(String policyNo){
        return Specifications.<PlantingPolicyList>and().eq(StringUtils.isNotEmpty(policyNo),"policyNo",policyNo).build();
    }
}
