package com.sinosoft.demo.web.customer;

import com.sinosoft.demo.api.customer.CustomerApi;
import com.sinosoft.demo.api.customer.dto.PrpDcustomerDto;
import com.sinosoft.demo.api.customer.dto.PrpDcustomerQueryConditionDto;
import com.sinosoft.demo.core.customer.service.CustomerService;
import com.sinosoft.framework.agri.core.utils.sm2.SM2Utils;
import com.sinosoft.framework.agri.core.utils.sm2.Util;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//	@Autowired
//	private YmlConfig ymlConfig;

	@Value("${spring.datasource.driver-class-name}")
	private String datasourceclassName;

	//SM2公钥
	@Value("${sm2.pubk}")
	private String sm2Pubk;

	//SM2私钥
	@Value("${sm2.prik}")
	private String sm2Prik;


	/**
	 * @description 分页查询
	 * @param offset 当前页
	 * @param length 每页大小
	 * @return Page<PrpDcustomerDto>
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月29日
	 */
	@Override
	public @ResponseBody List<PrpDcustomerDto> queryCustomerPaging(Integer offset,Integer length)throws Exception{
		customerService.queryCustomerPaging(offset,length);
		return null;
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
	 *
	 * @param prpDcustomerDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PrpDcustomerDto> queryCustomerByCondition(@RequestBody PrpDcustomerDto prpDcustomerDto) throws Exception {
		return customerService.queryCustomerByCondition(prpDcustomerDto);
	}

	/**
	 * @description 查询全部表信息
	 * @return List<PrpDcustomerDto>
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@Override
	public List<PrpDcustomerDto> queryAll() throws Exception {
		System.out.println(datasourceclassName+"----------");
		return customerService.queryAll();
	}

	/**
	 *
	 * @description 分页带条件排序查询
	 * @return
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年10月8日
	 */
	@Override
	public PageInfo<PrpDcustomerDto> queryPaging(Integer offset, Integer length,String customerName)throws Exception{

		PrpDcustomerQueryConditionDto queryDto=new PrpDcustomerQueryConditionDto();
		queryDto.setPageNo(offset);
		queryDto.setPageSize(length);
		queryDto.setCustomerCName(customerName);

		return customerService.queryPaging(queryDto);
	}


	/**
	 * @description 根据主键删除rpDcustomer
	 * @param customerCode
	 * @return String
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@Override
	public String removeByPrimaryKey(String customerCode) throws Exception {
		customerService.removeByPrimaryKey(customerCode);
		return "success";
	}

	/**
	 * @description 根据主键物理批量删除记录
	 * @param customers
	 * @return string
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@Override
	public @ResponseBody String removeByPrimaryKeys(String[] customers)throws Exception{
		customerService.removeByPrimaryKeys(customers);
		return "success";
	}

	/**
	 * @description 保存prpDcustomer对象
	 * @param prpDcustomerDto
	 * @return String
	 * @author 汪强
	 * @throws Exception
	 * @date 2017年9月30日 下午2:58:42
	 */
	@Override
	public String saveCustomer(@RequestBody PrpDcustomerDto prpDcustomerDto) throws Exception {
		customerService.saveCustomer(prpDcustomerDto);
		return "success";
	}

	/**
	 * @description 批量插入prpDcustomer对象
	 * @param prpDcustomerDtos
	 * @return String
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@Override
	@Transactional
	public @ResponseBody String saveCustomers(@RequestBody List<PrpDcustomerDto> prpDcustomerDtos)throws Exception{
		customerService.saveCustomers(prpDcustomerDtos);
		return "success";
	}

	/**
	 * @description 根据主键查找prpDcustomer对象
	 * @param customerCode
	 * @return PrpDcustomerDto
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@Override
	public PrpDcustomerDto getByPrimaryKey(String customerCode) throws Exception{
		if(customerCode.isEmpty()){
			return null;
		}
		return customerService.getByPrimaryKey(customerCode);
	}

	/**
	 * @description 修改customer记录
	 * @param prpDcustomerDto
	 * @return String
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@Override
	public String modifyCustomer(@RequestBody PrpDcustomerDto prpDcustomerDto) throws Exception {
		customerService.modifyCustomer(prpDcustomerDto);
		return "success";
	}


	/**
	 * @description 根据用户名查找 jpql方法
	 * @param customerCName
	 * @return List<PrpDcustomer>
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	public List<PrpDcustomerDto> findCustomerByName(String customerCName)throws Exception{
		return customerService.findCustomerByName(customerCName);
	}

	/**
	 * @description 根据主键修改用户姓名
	 * @param customerCName
	 * @param customerCode
	 * @return boolean
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@Override
	public boolean updateCustomerName(String customerCName,String customerCode)throws Exception{
		return customerService.updateCustomerName(customerCName,customerCode);
	}


	/**
	 * @description sm2数据加密验证
	 * @param value
	 * @return boolean
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@Override
	public String sm2Encrypt(@RequestParam("value") String value)throws Exception{
		byte[] sourceData = value.getBytes();
		byte[] sourcePk= Util.hexToByte(sm2Pubk);
		return SM2Utils.encrypt(sourcePk,sourceData);
	}


	/**
	 * @description sm2数据解密验证
	 * @param value
	 * @return boolean
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@Override
	public String sm2Decrypt(@RequestParam("value") String value)throws Exception{
//		byte[] sourceData = value.getBytes();
		byte[] sourcePk= Util.hexToByte(sm2Prik);
		return new String(SM2Utils.decrypt(sourcePk,Util.hexToByte(value)));

	}

	//查询测试方法
	@Override
	public PageInfo<PrpDcustomerDto> queryTest(Integer pageNo, Integer pageSize,String customerName,String customerCode) throws Exception {

//		System.out.println(ymlConfig.getTest()+"-------------------------------------");


		PrpDcustomerQueryConditionDto queryDto=new PrpDcustomerQueryConditionDto();
		queryDto.setPageNo(pageNo);
		queryDto.setPageSize(pageSize);
		queryDto.setCustomerCName(customerName);
		queryDto.setCustomerCode(customerCode);
		return customerService.queryEntityManageNativeSql(queryDto);
	}


	/**
	 * @description webservice接口调用验证
	 * @param name
	 * @return String
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	@Override
	public String testWebService(@RequestParam("name") String name)throws Exception{
		return customerService.testWebService(name);
	}

	@Override
	public String testSequence() throws Exception {
		customerService.testSequence();
		return "123";
	}
}
