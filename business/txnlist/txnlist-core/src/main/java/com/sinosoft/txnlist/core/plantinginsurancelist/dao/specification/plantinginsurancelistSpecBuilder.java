package com.sinosoft.txnlist.core.plantinginsurancelist.dao.specification;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingInsuranceList;
import org.springframework.data.jpa.domain.Specification;

public class plantinginsurancelistSpecBuilder {

    public static Specification<PlantingInsuranceList> Specification(String inusreListCode){
        return Specifications.<PlantingInsuranceList>and().eq(StringUtils.isNotEmpty(inusreListCode),"inusreListCode",inusreListCode).build();
    }
}
