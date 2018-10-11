package com.sinosoft.txnlist.api.customer;


import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.customer.dto.PrpDcustomerDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description 客户信息接口服务
 * @author HSQ
 * @date 2017年8月28日 下午3:21:00
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = CustomerApi.PATH)
public interface CustomerApi {

	public static final String PATH = "customer";

	/**
	 * @description 按主键查询prpDcustomer
	 * @param customerCode
	 * @return
	 * @author HSQ
	 * @throws Exception
	 * @date 2017年8月28日 下午2:58:42
	 */
	@RequestMapping(value = "queryCustomerByPK", method = RequestMethod.GET)
	public @ResponseBody PrpDcustomerDto queryCustomerByPK(@RequestParam(value = "customerCode") String customerCode) throws Exception;

}