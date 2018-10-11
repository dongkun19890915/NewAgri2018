package com.sinosoft.txnlist.core.customer.service;


import com.sinosoft.txnlist.api.customer.dto.PrpDcustomerDto;

/**
 * @description 客户信息接口
 * @author HSQ
 * @date 2017年8月28日 下午3:24:43
 */
public interface CustomerService {
	


	/**
	 * @description 按主键查询prpDcustomer
	 * @param customerCode
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:42
	 */
	public PrpDcustomerDto queryCustomerByPK(String customerCode) throws Exception;
	public PrpDcustomerDto queryCustomerByCondition(String customerCode) throws Exception;
}
