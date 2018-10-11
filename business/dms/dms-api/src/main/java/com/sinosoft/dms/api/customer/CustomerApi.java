package com.sinosoft.dms.api.customer;

import java.util.List;

import com.sinosoft.dms.api.customer.dto.*;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.dms.api.DMSConstant;

/**
 * @description 客户信息接口服务
 * @author HSQ
 * @date 2017年8月28日 下午3:21:00
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = CustomerApi.PATH)
public interface CustomerApi {

	public static final String PATH = "customer";

	/**
	 * @description 删除prpDcustomer/prpDcustomerIdv/prpDcustomerUnit
	 * @param customerCode
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:59:13
	 */
	@RequestMapping(value = "removeCustomer", method = RequestMethod.POST)
	public String removeCustomer(@RequestParam(value = "customerCode") String customerCode) throws Exception;

	/**
	 * @description 按主键查询prpDcustomer
	 * @param customerCode
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:42
	 */
	@RequestMapping(value = "queryCustomerByPK", method = RequestMethod.POST)
	public @ResponseBody PrpDcustomerDto queryCustomerByPK(@RequestParam(value = "customerCode") String customerCode) throws Exception;
	
	/**
	 * @description 新增prpDcustomerIdv
	 * @param prpDcustomerIdvDto
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:59:34
	 */
	@RequestMapping(value = "saveCustomerIdv", method = RequestMethod.POST)
	public String saveCustomerIdv(@RequestBody PrpDcustomerIdvDto prpDcustomerIdvDto) throws Exception;
	
	/**
	 * @description 修改prpDcustomerIdv
	 * @param prpDcustomerIdvDto
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:58
	 */
	@RequestMapping(value = "modifyCustomerIdv", method = RequestMethod.POST)
	public String modifyCustomerIdv(@RequestBody PrpDcustomerIdvDto prpDcustomerIdvDto) throws Exception;
	
	/**
	 * @description 按主键查询prpDcustomerIdv
	 * @param customerCode
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:42
	 */
	@RequestMapping(value = "queryCustomerIdvByPK", method = RequestMethod.POST)
	public @ResponseBody PrpDcustomerIdvDto queryCustomerIdvByPK(@RequestParam(value = "customerCode") String customerCode) throws Exception;
	
	/**
	 * @description 新增prpDcustomerUnit
	 * @param prpDcustomerUnitDto
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:59:34
	 */
	@RequestMapping(value = "saveCustomerUnit", method = RequestMethod.POST)
	public String saveCustomerUnit(@RequestBody PrpDcustomerUnitDto prpDcustomerUnitDto) throws Exception;
	
	/**
	 * @description 修改prpDcustomerUnit
	 * @param prpDcustomerUnitDto
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:58
	 */
	@RequestMapping(value = "modifyCustomerUnit", method = RequestMethod.POST)
	public String modifyCustomerUnit(@RequestBody PrpDcustomerUnitDto prpDcustomerUnitDto) throws Exception;
	
	/**
	 * @description 按主键查询prpDcustomerUnit
	 * @param customerCode
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:42
	 */
	@RequestMapping(value = "queryCustomerUnitByPK", method = RequestMethod.POST)
	public @ResponseBody PrpDcustomerUnitDto queryCustomerUnitByPK(@RequestParam(value = "customerCode") String customerCode) throws Exception;

	/**
	 * @description 根据条件查询个人客户信息
	 * @param customerReqDto
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:15
	 */
	@RequestMapping(value = "findPrpDcustomerIdvByCondition", method = RequestMethod.POST)
	public @ResponseBody List<PrpDcustomerIdvDto> findPrpDcustomerIdvByCondition(@RequestBody CustomerReqDto customerReqDto) throws Exception;
	
	/**
	 * @description 根据条件查询团体客户信息
	 * @param customerReqDto
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:15
	 */
	@RequestMapping(value = "findPrpDcustomerUnitByCondition", method = RequestMethod.POST)
	public @ResponseBody List<PrpDcustomerUnitDto> findPrpDcustomerUnitByCondition(@RequestBody CustomerReqDto customerReqDto) throws Exception;
	/**
	 *保存客户信息，自动生成客户号
	 *@param iPrpDcustomerSchema 客户记录
	 *@param comCode  机构代码
	 *@throws Exception
	 */
	@RequestMapping(value = "addCustomer", method = RequestMethod.POST)
	public String addCustomer(@RequestBody PrpDcustomerDto iPrpDcustomerSchema,@RequestParam(value = "comCode") String comCode)throws Exception;
	/**
	 *@description 新增
	 *@param
	 */
	@RequestMapping(value = "save",method = {RequestMethod.POST})
	void save(PrpDcustomLevelTraceDto prpDcustomLevelTraceDto);

	/**
	 * @description:根据customerCode查询
	 * @author: 钱浩
	 * @date: 2017/10/21 14:10
	 * @param customerCode
	 * @return
	 */
	@RequestMapping(value ="queryPrpDcustomLevelTraceByConnection",method = {RequestMethod.POST})
	public @ResponseBody PrpDcustomLevelTraceDto queryPrpDcustomLevelTraceByConnection(@RequestParam("customerCode") String  customerCode)throws  Exception;

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
	@RequestMapping(value = "queryPrpDcustomerIdvByCondition",method = {RequestMethod.POST})
	public @ResponseBody ResponseDto queryPrpDcustomerIdvByCondition(@RequestParam("identifyNumber") String identifyNumber,@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize)throws Exception;

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
	@RequestMapping(value = "queryPrpDcustomerUnitByCondition",method = {RequestMethod.POST})
	public @ResponseBody ResponseDto queryPrpDcustomerUnitByCondition(@RequestParam("socialCode") String socialCode,@RequestParam("pageNo")  Integer pageNo,@RequestParam("pageSize")  Integer pageSize)throws Exception;
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
	@RequestMapping(value = "saveCustomerInfo", method = RequestMethod.POST)
	public @ResponseBody ResponseDto saveCustomerInfo(@RequestBody PrpDcustomerSaveDto prpDcustomerSaveDto) throws  Exception;

}