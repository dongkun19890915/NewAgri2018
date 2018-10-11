package com.sinosoft.txnlist.core.customer.dao.specification;

import com.sinosoft.txnlist.core.customer.entity.PrpDcustomer;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import org.springframework.data.jpa.domain.Specification;

/**
 * @description CustomerSpecBuilder
 * @author HSQ
 * @date 2017年8月28日 下午4:06:33
 */
public class CustomerSpecBuilder {

//	/**
//	 * @description 组装idvSpecification TODO 组装条件待定
//	 * @param prpDcustomerIdv
//	 * @return
//	 * @author HSQ
//	 * @date 2017年8月28日 下午4:07:42
//	 */
//    public static Specification<PrpDcustomerIdv> idvSpecification(CustomerReqDto customerReqDto){
//        return Specifications.<PrpDcustomerIdv>and().eq(StringUtils.isNotEmpty(customerReqDto.getIdentifyType()), "identifyType", customerReqDto.getIdentifyType())
//        		.eq(StringUtils.isNotEmpty(customerReqDto.getIdentifyNumber()), "identifyNumber", customerReqDto.getIdentifyNumber())
//                .build();
//    }
//
//    /**
//     * @description 组装unitSpecification TODO 组装条件待定
//     * @param prpDcustomerUnit
//     * @return
//     * @author HSQ
//     * @date 2017年8月28日 下午4:07:46
//     */
//    public static Specification<PrpDcustomerUnit> unitSpecification(CustomerReqDto customerReqDto){
//    	return Specifications.<PrpDcustomerUnit>and().eq(StringUtils.isNotEmpty(customerReqDto.getOrganizeCode()), "organizeCode", customerReqDto.getOrganizeCode())
//    			.build();
//    }


    public static Specification<PrpDcustomer> Specification(String usercode){
        return Specifications.<PrpDcustomer>and().eq(StringUtils.isNotEmpty(usercode),"organizeCode",usercode).build();
    }

}
