package com.sinosoft.dms.core.customer.service;

import java.util.List;

import com.sinosoft.dms.api.customer.dto.*;
import com.sinosoft.framework.dto.ResponseDto;

/**
 * @description 客户信息接口
 * @author HSQ
 * @date 2017年8月28日 下午3:24:43
 */
public interface CustomerService {
	
	/**
	 * @description 删除prpDcustomer
	 * @param customerCode
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:59:13
	 */
	public String removeCustomer(String customerCode) throws Exception;

	/**
	 * @description 按主键查询prpDcustomer
	 * @param customerCode
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:42
	 */
	public PrpDcustomerDto queryCustomerByPK(String customerCode) throws Exception;
	
	/**
	 * @description 新增prpDcustomerIdv
	 * @param prpDcustomerIdvDto
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:59:34
	 */
	public String saveCustomerIdv(PrpDcustomerIdvDto prpDcustomerIdvDto) throws Exception;
	
	/**
	 * @description 修改prpDcustomerIdv
	 * @param prpDcustomerIdvDto
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:58
	 */
	public String modifyCustomerIdv(PrpDcustomerIdvDto prpDcustomerIdvDto) throws Exception;
	
	/**
	 * @description 按主键查询prpDcustomerIdv
	 * @param customerCode
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:42
	 */
	public PrpDcustomerIdvDto queryCustomerIdvByPK(String customerCode) throws Exception;
	
	/**
	 * @description 新增prpDcustomerUnit
	 * @param prpDcustomerUnitDto
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:59:34
	 */
	public String saveCustomerUnit(PrpDcustomerUnitDto prpDcustomerUnitDto) throws Exception;
	
	/**
	 * @description 修改prpDcustomerUnit
	 * @param prpDcustomerUnitDto
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:58
	 */
	public String modifyCustomerUnit(PrpDcustomerUnitDto prpDcustomerUnitDto) throws Exception;
	
	/**
	 * @description 按主键查询prpDcustomerUnit
	 * @param customerCode
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:42
	 */
	public PrpDcustomerUnitDto queryCustomerUnitByPK(String customerCode) throws Exception;


	/**
	 * @description 根据条件查询个人客户信息
	 * @param customerReqDto
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:15
	 */
	public List<PrpDcustomerIdvDto> findPrpDcustomerIdvByCondition(CustomerReqDto customerReqDto) throws Exception;
	
	/**
	 * @description 根据条件查询团体客户信息
	 * @param customerReqDto
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:15
	 */
	public List<PrpDcustomerUnitDto> findPrpDcustomerUnitByCondition(CustomerReqDto customerReqDto) throws Exception;
	/**
	 *保存客户信息，自动生成客户号
	 *@param iPrpDcustomerSchema 客户记录
	 *@param comCode  机构代码
	 *@throws Exception
	 */
	public String addCustomer(PrpDcustomerDto iPrpDcustomerSchema, String comCode)throws Exception;
	/**
	 *@description 新增
	 *@param
	 */
	void save(PrpDcustomLevelTraceDto prpDcustomLevelTraceDto);

	/**
	 * @description:根据customerCode查询
	 * @author: 钱浩
	 * @date: 2017/10/21 14:10
	 * @param customerCode
	 * @return
	 */
	public PrpDcustomLevelTraceDto queryPrpDcustomLevelTraceByConnection(String  customerCode)throws  Exception;

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
	public ResponseDto queryPrpDcustomerIdvByCondition( String identifyNumber,Integer pageNo,Integer pageSize)throws Exception;
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
	public ResponseDto queryPrpDcustomerUnitByCondition( String socialCode,Integer pageNo,Integer pageSize)throws Exception;
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
	public ResponseDto saveCustomerInfo(PrpDcustomerSaveDto prpDcustomerSaveDto) throws  Exception;

}
