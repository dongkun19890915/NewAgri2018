package com.sinosoft.dms.core.dict.dao.specification;

import com.sinosoft.dms.core.dict.entity.PrpDNewCode;
import com.sinosoft.framework.core.dao.support.Specifications;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by Jason on 2017/7/26.
 */
public class NewCodeSpecBuilder {

    public static Specification<PrpDNewCode> exampleQuery(PrpDNewCode newCode){
        return Specifications.<PrpDNewCode>and().eq("codeCode",newCode.getCodeCode())
                .build();
    }


}
