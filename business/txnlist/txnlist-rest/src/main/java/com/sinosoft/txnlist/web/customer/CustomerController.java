package com.sinosoft.txnlist.web.customer;


import com.sinosoft.txnlist.api.customer.CustomerApi;
import com.sinosoft.txnlist.api.customer.dto.PrpDcustomerDto;
import com.sinosoft.txnlist.core.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 客户信息controller
 * @author HSQ
 * @date 2017年8月29日 下午2:34:09
 */
@RestController
@RequestMapping(value = CustomerApi.PATH)
public class CustomerController implements CustomerApi {
	
	@Autowired
	private CustomerService customerService;


	/**
	 * @description 按主键查询prpDcustomer
	 * @param customerCode
	 * @return
	 * @author HSQ
	 * @throws Exception
	 * @date 2017年8月28日 下午2:58:42
	 */
	@Override
	public @ResponseBody
	PrpDcustomerDto queryCustomerByPK(String customerCode) throws Exception {
		return customerService.queryCustomerByPK(customerCode);
	}


}
