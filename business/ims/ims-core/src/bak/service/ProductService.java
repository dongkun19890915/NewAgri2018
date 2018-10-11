package com.sinosoft.ims.core.kernel.service;

import java.util.List;

import com.sinosoft.ims.api.kernel.dto.ProductQeuryConditionDto;
import com.sinosoft.ims.api.kernel.dto.SaaUserPermitRiskDto;


/**
* @description 业务允许产品 服务
* @author hzhongkai
* @date 2016年9月20日下午5:07:50
*/
public interface ProductService {
	
	
	
	/**
	* @description 产品获取服务
	* @param userPermitRiskConditionDto
	* @return ResponseDto
	* @author hzhongkai
	* @date 2016年9月20日下午5:24:30
	*/
    List<SaaUserPermitRiskDto> queryUserProductList(ProductQeuryConditionDto productQeuryConditionDto) ;
}
