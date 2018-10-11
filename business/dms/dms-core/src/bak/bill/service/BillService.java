package com.sinosoft.dms.core.bill.service;

import com.sinosoft.dms.api.bill.dto.BillConditionDto;
import com.sinosoft.dms.api.bill.dto.BillDto;

/**
 * @description （单号生成接口服务）
 * @author dongyingchun
 * @date 2016年9月14日下午2:29:59
 */
public interface BillService {

	/**
	 * @description （获取投保单号）
	 * @param billConditonDto
	 * @return
	 * @author dongyingchun
	 * @date 2016年9月16日下午6:27:23
	 */
	public BillDto getProposalNo(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description 订单号生成
	 * @param billConditionDto
	 * @return
	 * @throws Exception
	 * @author zkr10
	 * @date 2016年9月28日下午7:01:59
	 */
	public BillDto getOrderNo(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description （获取保单号）
	 * @param billConditonDto
	 * @return
	 * @author dongyingchun
	 * @date 2016年9月16日下午6:27:39
	 */
	public BillDto getPolicyNo(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description （ 获取批单号）
	 * @param billConditonDto
	 * @return
	 * @author ThinkPad
	 * @date 2016年9月16日下午6:27:58
	 */
	public BillDto getEndorseNo(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description （获取批单申请号）
	 * @param billConditonDto
	 * @return
	 * @author ThinkPad
	 * @date 2016年9月16日下午6:28:08
	 */
	public BillDto getApplyNo(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description (获取标的号)
	 * @param billConditonDto
	 * @return
	 * @author ThinkPad
	 * @date 2016年9月16日下午6:28:27
	 */
	public BillDto getItemNo(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description 客户编号生成
	 * @param billConditionDto
	 * @return
	 * @throws Exception
	 * @author zkr10
	 * @date 2016年9月27日下午8:07:45
	 */
	public BillDto getCustomerCode(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description cif系统中编号生成
	 * @param billConditionDto
	 * @return
	 * @throws Exception
	 * @author zkr10
	 * @date 2016年9月27日下午8:08:02
	 */
	public BillDto getSerialNo(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description iNuo编号生成
	 * @param billConditionDto
	 * @return
	 * @throws Exception
	 */
	BillDto getInuoCode(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description uNuo编号生成
	 * @param billConditionDto
	 * @return
	 * @throws Exception
	 */
	BillDto getUnuoCode(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description subNuo编号生成
	 * @param billConditionDto
	 * @return
	 * @throws Exception
	 */
	BillDto getSubNuoCode(BillConditionDto billConditionDto) throws Exception;

}