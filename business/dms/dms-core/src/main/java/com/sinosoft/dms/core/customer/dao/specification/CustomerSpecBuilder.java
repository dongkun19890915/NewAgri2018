package com.sinosoft.dms.core.customer.dao.specification;

import com.sinosoft.dms.core.customer.entity.PrpDcustomLevelTrace;
import com.sinosoft.dms.core.customer.entity.PrpDcustomerIdv;
import com.sinosoft.dms.core.customer.entity.PrpDcustomerUnit;
import org.springframework.data.jpa.domain.Specification;

import com.sinosoft.dms.api.customer.dto.CustomerReqDto;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;

/**
 * @description CustomerSpecBuilder
 * @author HSQ
 * @date 2017年8月28日 下午4:06:33
 */
public class CustomerSpecBuilder {

	/**
	 * @description 组装idvSpecification TODO 组装条件待定
	 * @param customerReqDto
	 * @return
	 * @author HSQ
	 * @date 2017年8月28日 下午4:07:42
	 */
    public static Specification<PrpDcustomerIdv> idvSpecification(CustomerReqDto customerReqDto){
        return Specifications.<PrpDcustomerIdv>and().eq(StringUtils.isNotEmpty(customerReqDto.getIdentifyType()), "identifyType", customerReqDto.getIdentifyType())
        		.eq(StringUtils.isNotEmpty(customerReqDto.getIdentifyNumber()), "identifyNumber", customerReqDto.getIdentifyNumber())
                .build();
    }
    
    /**
     * @description 组装unitSpecification TODO 组装条件待定
     * @param customerReqDto
     * @return
     * @author HSQ
     * @date 2017年8月28日 下午4:07:46
     */
    public static Specification<PrpDcustomerUnit> unitSpecification(CustomerReqDto customerReqDto){
    	return Specifications.<PrpDcustomerUnit>and().eq(StringUtils.isNotEmpty(customerReqDto.getOrganizeCode()), "organizeCode", customerReqDto.getOrganizeCode())
    			.build();
    }

}
