package com.sinosoft.dms.core.bill.service;

import com.sinosoft.dms.api.bill.dto.BillConditionDto;

/**
 * @description （单号生成接口服务）
 * @author dongyingchun
 * @date 2016年9月14日下午2:29:59
 */
public interface BillService {
	
	/**
	 * @description 获取以前缀为类型的单号
	 * @param billConditonDto
	 * @return
	 * @author zxp
	 * @date 2017年8月29日
	 */
	public String getBillNo(BillConditionDto billConditionDto) throws Exception;

	
	/**
	 * @description 获取投保单号
	 * @param billConditonDto
	 * @return
	 * @author dongyingchun
	 * @date 2016年9月16日下午6:27:23
	 */
	public String getProposalNo(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description 订单号生成
	 * @param billConditionDto
	 * @return
	 * @throws Exception
	 * @author zkr10
	 * @date 2016年9月28日下午7:01:59
	 */
	public String getOrderNo(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description 获取保单号
	 * @param billConditonDto
	 * @return
	 * @author dongyingchun
	 * @date 2016年9月16日下午6:27:39
	 */
	public String getPolicyNo(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description 获取批单号
	 * @param billConditonDto
	 * @return
	 * @author ThinkPad
	 * @date 2016年9月16日下午6:27:58
	 */
	public String getEndorseNo(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description 获取批单申请号
	 * @param billConditonDto
	 * @return
	 * @author ThinkPad
	 * @date 2016年9月16日下午6:28:08
	 */
	public String getApplyNo(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description 获取标的号
	 * @param billConditonDto
	 * @return
	 * @author ThinkPad
	 * @date 2016年9月16日下午6:28:27
	 */
	public String getItemNo(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description 客户编号生成
	 * 如果是个人客户，传值customerCode_1,加11位序号，
	 * 如果法人，则传值customerCode_2，加11位序号.进行截取处理，将_后面的截取
	 * @param billConditionDto
	 * @return
	 * @throws Exception
	 * @author zkr10
	 * @date 2016年9月27日下午8:07:45
	 */
	public String getCustomerCode(BillConditionDto billConditionDto) throws Exception;

	/**
	 * @description cif系统中编号生成
	 * @param billConditionDto
	 * @return
	 * @throws Exception
	 * @author zkr10
	 * @date 2016年9月27日下午8:08:02
	 */
	public String getSerialNo(BillConditionDto billConditionDto) throws Exception;

}