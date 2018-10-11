package com.sinosoft.dms.web.customer;

import java.util.List;

import com.sinosoft.dms.api.customer.dto.*;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.dms.api.customer.CustomerApi;
import com.sinosoft.dms.core.customer.service.CustomerService;

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
	 * @description 删除prpDcustomer
	 * @param customerCode
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:59:13
	 */
	@Override
	public String removeCustomer(String customerCode) throws Exception {
		return customerService.removeCustomer(customerCode);
	}

	/**
	 * @description 按主键查询prpDcustomer
	 * @param customerCode
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:42
	 */
	@Override
	public @ResponseBody PrpDcustomerDto queryCustomerByPK(String customerCode) throws Exception {
		return customerService.queryCustomerByPK(customerCode);
	}

	/**
	 * @description 新增prpDcustomerIdv
	 * @param prpDcustomerIdvDto
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:59:34
	 */
	@Override
	public String saveCustomerIdv(@RequestBody PrpDcustomerIdvDto prpDcustomerIdvDto) throws Exception {
		return customerService.saveCustomerIdv(prpDcustomerIdvDto);
	}

	/**
	 * @description 修改prpDcustomerIdv
	 * @param prpDcustomerIdvDto
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:58
	 */
	@Override
	public String modifyCustomerIdv(@RequestBody PrpDcustomerIdvDto prpDcustomerIdvDto) throws Exception {
		return customerService.modifyCustomerIdv(prpDcustomerIdvDto);
	}

	/**
	 * @description 按主键查询prpDcustomerIdv
	 * @param customerCode
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:42
	 */
	@Override
	public @ResponseBody PrpDcustomerIdvDto queryCustomerIdvByPK(String customerCode) throws Exception {
		return customerService.queryCustomerIdvByPK(customerCode);
	}

	/**
	 * @description 新增prpDcustomerUnit
	 * @param prpDcustomerUnitDto
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:59:34
	 */
	public String saveCustomerUnit(@RequestBody PrpDcustomerUnitDto prpDcustomerUnitDto) throws Exception {
		return customerService.saveCustomerUnit(prpDcustomerUnitDto);
	}

	/**
	 * @description 修改prpDcustomerUnit
	 * @param prpDcustomerUnitDto
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:58
	 */
	@Override
	public String modifyCustomerUnit(@RequestBody PrpDcustomerUnitDto prpDcustomerUnitDto) throws Exception {
		return customerService.modifyCustomerUnit(prpDcustomerUnitDto);
	}

	/**
	 * @description 按主键查询prpDcustomerUnit
	 * @param customerCode
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:42
	 */
	@Override
	public @ResponseBody PrpDcustomerUnitDto queryCustomerUnitByPK(String customerCode) throws Exception {
		return customerService.queryCustomerUnitByPK(customerCode);
	}

	/**
	 * @description 根据条件查询个人客户信息
	 * @param customerReqDto
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:15
	 */
	@Override
	public @ResponseBody List<PrpDcustomerIdvDto> findPrpDcustomerIdvByCondition(@RequestBody CustomerReqDto customerReqDto) throws Exception {
		return customerService.findPrpDcustomerIdvByCondition(customerReqDto);
	}

	/**
	 * @description 根据条件查询团体客户信息
	 * @param customerReqDto
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:15
	 */
	@Override
	public @ResponseBody List<PrpDcustomerUnitDto> findPrpDcustomerUnitByCondition(@RequestBody CustomerReqDto customerReqDto) throws Exception {
		return customerService.findPrpDcustomerUnitByCondition(customerReqDto);
	}
	/**
	 *保存客户信息，自动生成客户号
	 *@param iPrpDcustomerSchema 客户记录
	 *@param comCode  机构代码
	 *@throws Exception
	 */
	public String addCustomer(@RequestBody PrpDcustomerDto iPrpDcustomerSchema, String comCode)throws Exception{
		return customerService.addCustomer(iPrpDcustomerSchema,comCode);
	}
	/**
	 *@description 新增
	 *@param
	 */
	public void save(@RequestBody PrpDcustomLevelTraceDto prpDcustomLevelTraceDto) {
		customerService.save(prpDcustomLevelTraceDto);
	}


	public PrpDcustomLevelTraceDto queryPrpDcustomLevelTraceByConnection(String  customerCode)throws  Exception
	{
		return customerService.queryPrpDcustomLevelTraceByConnection(customerCode);
	}
	/**
	 *  个体客户根据证件号查询
	 * @author: 钱浩
	 * @date: 2017/10/13 18:39
	 * @param identifyNumber 证件号码
	 * @param pageNo     页码
	 * @param pageSize   条数
	 * @return ResponseDto ：PageInfo<PrpDcustomerIdvDto>  大对象
	 * @throws Exception
	 */
	public @ResponseBody ResponseDto queryPrpDcustomerIdvByCondition(@RequestParam("identifyNumber") String identifyNumber,@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize)throws Exception{
		return customerService.queryPrpDcustomerIdvByCondition(identifyNumber, pageNo, pageSize);
	}

	/**
	 *   集体客户根据号查询
	 * @author: 钱浩
	 * @date: 2017/11/1 15:29
	 * @param socialCode 机构代码
	 * @param pageNo     页码
	 * @param pageSize   条数
	 * @return ResponseDto ： PageInfo<PrpDcustomerUnitDto>对象
	 * @throws Exception
	 */
	public @ResponseBody ResponseDto queryPrpDcustomerUnitByCondition(@RequestParam("socialCode") String socialCode,@RequestParam("pageNo")  Integer pageNo,@RequestParam("pageSize")  Integer pageSize)throws Exception{
		return customerService.queryPrpDcustomerUnitByCondition(socialCode, pageNo, pageSize);
	}
	/**
	 *  1.判断customerType为1走个体客户，否则集体客户
	 * 2.风险轨迹表PrpDcustomLevelTrace保存
	 * 3.客户纳税人信息表 prpDCustomerTaxPayInfo保存
	 * @author: 钱浩
	 * @date: 2017/10/21 15:00
	 * @param prpDcustomerSaveDto 增加或者修改客户封装dto
	 * @return ResponseDto： 成功或失败
	 * @throws Exception
	 */
	public @ResponseBody ResponseDto saveCustomerInfo(@RequestBody PrpDcustomerSaveDto prpDcustomerSaveDto) throws  Exception{
		return customerService.saveCustomerInfo(prpDcustomerSaveDto);
	}
}
