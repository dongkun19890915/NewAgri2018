package com.sinosoft.demo.core.customer.dao.specification;

import com.sinosoft.demo.api.customer.dto.PrpDcustomerDto;
import com.sinosoft.demo.core.customer.entity.PrpDcustomer;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import org.springframework.data.jpa.domain.Specification;

/**
 *@Description:客户信息查询条件封装
 *@Author:周家伟
 *@Since:2017年9月29日
 */
public class CustomerSpecBuilder {

	/**
	 * @description 依据customerCode主键查询符合条件的客户信息
	 * @param prpDcustomerDto 客户信息查询入参Dto
	 * @return Specification 封装后的查询对象
	 * @throws Exception
	 * @author 周家伟
	 * @date 2017年9月29日
	 */
    public static Specification<PrpDcustomer> customerSpecification(PrpDcustomerDto prpDcustomerDto){
        return Specifications.<PrpDcustomer>and()
				.like(StringUtils.isNotEmpty(prpDcustomerDto.getCustomerCode()),"customerCode",prpDcustomerDto.getCustomerCode()+"%")
				.like(StringUtils.isNotEmpty(prpDcustomerDto.getCustomerCName()),"customerCName",prpDcustomerDto.getCustomerCName()+"%")
				.eq(StringUtils.isNotEmpty(prpDcustomerDto.getCustomerType()),"customerType",prpDcustomerDto.getCustomerType())
				.build();
    }

}
