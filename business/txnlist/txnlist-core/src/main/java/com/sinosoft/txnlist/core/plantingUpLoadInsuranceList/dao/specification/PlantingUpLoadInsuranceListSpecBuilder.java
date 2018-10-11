package com.sinosoft.txnlist.core.plantingUpLoadInsuranceList.dao.specification;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.txnlist.core.plantingUpLoadInsuranceList.entity.PlantingUpLoadInsuranceList;
import org.springframework.data.jpa.domain.Specification;

public class PlantingUpLoadInsuranceListSpecBuilder {
    public static Specification<PlantingUpLoadInsuranceList> Specification(String inusreListCode){
        return Specifications.<PlantingUpLoadInsuranceList>and().eq(StringUtils.isNotEmpty(inusreListCode),"inusrelistcode",inusreListCode).build();

    }
}
