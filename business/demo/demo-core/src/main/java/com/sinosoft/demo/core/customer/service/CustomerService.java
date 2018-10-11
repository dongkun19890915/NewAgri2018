package com.sinosoft.demo.core.customer.service;

import com.sinosoft.demo.api.customer.dto.PrpDcustomerDto;
import com.sinosoft.demo.api.customer.dto.PrpDcustomerQueryConditionDto;
import com.sinosoft.demo.core.customer.entity.PrpDcustomer;
import com.sinosoft.framework.agri.core.utils.Str;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 *@Description:客户信息service类
 *@Author:周家伟
 *@Since:2017年9月29日
 */
public interface CustomerService {



	/**
	 * @description 依据主键查询客户信息
	 * @param customerCode 客户代码
	 * @return PrpDcustomerDto 客户信息对象
	 * @throws Exception
	 * @author 周家伟
	 * @date 2017年9月29日
	 */
	PrpDcustomerDto queryCustomerByPK(String customerCode) throws Exception;
	/**
	 * @description 依据条件查询客户信息
	 * @param prpDcustomerDto 客户信息查询入参封装对象
	 * @return List<PrpDcustomerDto> 客户信息列表
	 * @throws Exception
	 * @author 周家伟
	 * @date 2017年9月29日
	 */
	List<PrpDcustomerDto> queryCustomerByCondition(PrpDcustomerDto prpDcustomerDto) throws Exception;



	/**
	 * @description 分页查询
	 * @param List<PrpDcustomerDto>
	 * @return
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	Page<PrpDcustomerDto> queryCustomerPaging(Integer offset, Integer length)throws Exception;

	/**
	 *
	 * @description 依据条件查询客户信息
	 * @return
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月29日
	 */
	List<PrpDcustomerDto> queryAll() throws Exception;

	/**
	 *
	 * @description 分页带条件排序查询
	 * @return
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年10月8日
	 */
	PageInfo<PrpDcustomerDto> queryPaging(PrpDcustomerQueryConditionDto queryDto) throws Exception;

	/**
	 * @description 根据主键物理删除记录
	 * @param customerCode
	 * @return
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	boolean removeByPrimaryKey(String customerCode)throws Exception;

	/**
	 * @description 根据主键物理批量删除记录
	 * @param customerCode
	 * @return
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	boolean removeByPrimaryKeys(String[] customerCode)throws Exception;

	//逻辑删除
	void logicRemoveByPrimaryKey(String customerCode)throws Exception;

	/**
	 * @description 插入prpDcustomer对象
	 * @param prpDcustomerDto
	 * @return
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	boolean saveCustomer(PrpDcustomerDto prpDcustomerDto) throws Exception;

	/**
	 * @description 批量插入prpDcustomer对象
	 * @param prpDcustomerDtos
	 * @return
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	boolean saveCustomers(List<PrpDcustomerDto> prpDcustomerDtos)throws Exception;

	/**
	 * @description 修改customer记录
	 * @param prpDcustomerDto
	 * @return String
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	boolean modifyCustomer(PrpDcustomerDto prpDcustomerDto)throws Exception;

	/**
	 * @description 批量修改customer记录
	 * @param List<PrpDcustomer>
	 * @return String
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	boolean modifyCustomers(List<PrpDcustomer> prpDcustomers)throws Exception;

	/**
	 * @description 根据主键查找prpDcustomer对象
	 * @param customerCode
	 * @return PrpDcustomerDto
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	PrpDcustomerDto getByPrimaryKey(String customerCode)throws Exception;


	/**
	 * @description 根据用户名查找 jpql方法
	 * @param customerCName
	 * @return List<PrpDcustomer>
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	List<PrpDcustomerDto> findCustomerByName(String customerCName)throws Exception;


	/**
	 * @description 根据主键修改用户姓名
	 * @param customerCName
	 * @param customerCode
	 * @return boolean
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	boolean updateCustomerName(String customerCName, String customerCode)throws Exception;


	//使用entityManage自定查询 原生sql
	public PageInfo<PrpDcustomerDto> queryEntityManageNativeSql(PrpDcustomerQueryConditionDto queryDto)throws Exception;


	/**
	 * @description webservice接口调用验证
	 * @param name
	 * @return String
	 * @throws Exception
	 * @author 汪强
	 * @date 2017年9月30日
	 */
	public String testWebService(String name)throws Exception;

	void testSequence();
}
