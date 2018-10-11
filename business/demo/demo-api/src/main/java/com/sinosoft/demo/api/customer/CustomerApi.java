package com.sinosoft.demo.api.customer;

import com.sinosoft.demo.api.DemoConstant;
import com.sinosoft.demo.api.customer.dto.PrpDcustomerDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


import java.util.*;

/**
 *@Description:客户信息的api接口
 *@Author:周家伟
 *@Since:2017年9月29日
 */
@FeignClient(name = DemoConstant.DEMO_SERVICE_NAME, path = CustomerApi.PATH)
public interface CustomerApi {

	String PATH = "customer";


	/**
	 * @description 分页查询
	 * @param offset 当前页
	 * @param length 每页大小
	 * @return Page<PrpDcustomerDto>
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月29日
	 */
	@RequestMapping(value="queryCustomerPaging",method = RequestMethod.POST)
	@ResponseBody List<PrpDcustomerDto> queryCustomerPaging(@RequestParam("offset") Integer offset,@RequestParam("length") Integer length)throws Exception;


	/**
	 * @description 依据customerCode主键查询符合条件的客户信息
	 * @param customerCode 客户代码
	 * @return PrpDcustomerDto 客户信息对象
	 * @throws Exception
	 * @author 周家伟
	 * @date 2017年9月29日
	 */
	@RequestMapping(value = "queryCustomerByPK", method = RequestMethod.GET)
	@ResponseBody PrpDcustomerDto queryCustomerByPK(@RequestParam(value = "customerCode") String customerCode) throws Exception;
	/**
	 * @description 依据条件查询符合条件的客户信息
	 * @param prpDcustomerDto 客户对象查询条件封装dto
	 * @return List<PrpDcustomerDto> 客户信息对象集合
	 * @throws Exception
	 * @author 周家伟
	 * @date 2017年9月29日
	 */
	@RequestMapping(value = "queryCustomerByCondition", method = RequestMethod.POST)
	@ResponseBody List<PrpDcustomerDto>  queryCustomerByCondition(@RequestBody PrpDcustomerDto prpDcustomerDto) throws Exception;


	/**
	 * @description 查询全部数据	 验证通过
	 * @return List<PrpDcustomerDto> 客户对象查询条件封装dto
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月29日
	 */
	@RequestMapping(value="queryAll",method ={RequestMethod.POST})
	@ResponseBody List<PrpDcustomerDto> queryAll() throws Exception;


	/**
	 *
	 * @description 分页带条件排序查询
	 * @return
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年10月8日
	 */
	@RequestMapping(value="queryPaging",method ={RequestMethod.POST})
	@ResponseBody PageInfo<PrpDcustomerDto> queryPaging(@RequestParam("offset") Integer offset, @RequestParam("length") Integer length,@RequestParam("customerName") String customerName) throws Exception;

	/**
	 * @description 根据主键物理删除记录	 验证通过
	 * @param customerCode
	 * @return
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@RequestMapping(value="removeByPrimaryKey",method={RequestMethod.POST})
	@ResponseBody String removeByPrimaryKey(@RequestParam("customerCode") String customerCode)throws Exception;

	/**
	 * @description 根据主键物理批量删除记录
	 * @param customers
	 * @return string
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@RequestMapping(value="removeByPrimaryKeys",method={RequestMethod.POST})
	@ResponseBody String removeByPrimaryKeys(@RequestParam("customers") String[] customers)throws Exception;


	/**
	 * @description 插入prpDcustomer对象	验证通过
	 * @param prpDcustomerDto
	 * @return
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@RequestMapping(value="saveCustomer",method={RequestMethod.POST})
	@ResponseBody String saveCustomer(@RequestBody PrpDcustomerDto prpDcustomerDto)throws Exception;

	/**
	 * @description 批量插入prpDcustomer对象
	 * @param prpDcustomerDtos
	 * @return
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@RequestMapping(value="saveCustomers",method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody String saveCustomers(@RequestBody List<PrpDcustomerDto> prpDcustomerDtos)throws Exception;

	/**
	 * @description 根据主键查找prpDcustomer对象 验证通过
	 * @param customerCode
	 * @return PrpDcustomerDto
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@RequestMapping(value="getByPrimaryKey",method={RequestMethod.POST})
	@ResponseBody PrpDcustomerDto getByPrimaryKey(@RequestParam("customerCode") String customerCode)throws Exception;

	/**
	 * @description 修改customer记录
	 * @param prpDcustomerDto
	 * @return String
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@RequestMapping(value="modifyCustomer",method=RequestMethod.POST,consumes="application/json")
	@ResponseBody String modifyCustomer(@RequestBody PrpDcustomerDto prpDcustomerDto)throws Exception;

	/**
	 * @description 根据用户名查找 jpql方法
	 * @param customerCName
	 * @return List<PrpDcustomer>
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@RequestMapping(value="findCustomerByName",method={RequestMethod.POST},consumes="application/json")
	List<PrpDcustomerDto> findCustomerByName(@RequestParam("customerCName") String customerCName)throws Exception;

	/**
	 * @description 根据主键修改用户姓名
	 * @param customerCName
	 * @param customerCode
	 * @return boolean
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@RequestMapping(value="updateCustomerName",method=RequestMethod.POST)
	boolean updateCustomerName(@RequestParam("customerCName") String customerCName,@RequestParam("customerCode")  String customerCode)throws Exception;


	/**
	 * @description sm2数据加密验证
	 * @param value
	 * @return boolean
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@RequestMapping(value = "sm2Encrypt",method = RequestMethod.GET)
	@ResponseBody String sm2Encrypt(@RequestParam("value") String value)throws Exception;


	/**
	 * @description sm2数据解密验证
	 * @param value
	 * @return boolean
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@RequestMapping(value = "sm2Decrypt",method = RequestMethod.GET)
	@ResponseBody String sm2Decrypt(@RequestParam("value") String value)throws Exception;

	//查询测试接方法
	@RequestMapping(value = "queryTest",method ={RequestMethod.POST})
	PageInfo<PrpDcustomerDto> queryTest(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize")  Integer pageSize,@RequestParam("customerName") String customerName,@RequestParam("fffffff") String customerCode)throws Exception;


	/**
	 * @description webservice接口调用验证
	 * @param name
	 * @return String
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@RequestMapping(value = "testWebService",method ={RequestMethod.GET})
	@ResponseBody public String testWebService(@RequestParam("name") String name)throws Exception;

	/**
	 * 主键 序列自增测试样例代码
	 * @author: 周家伟
	 * @date: 2017/12/12 下午3:53
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "testSequence",method ={RequestMethod.GET})
	@ResponseBody public String testSequence()throws Exception;

}