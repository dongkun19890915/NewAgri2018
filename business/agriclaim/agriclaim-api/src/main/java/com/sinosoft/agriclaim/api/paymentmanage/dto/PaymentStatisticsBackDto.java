package com.sinosoft.agriclaim.api.paymentmanage.dto;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;

/***（支付统计情况列表查询返回参数dto）
 * @Author: 王志文
 * @Date: 2018/1/4 15:54
 */
public class PaymentStatisticsBackDto {
	/** 报案号 */
	@ExportConfig(value = "报案号",width = 80)
	private String registNo;
	/** 赔款计算书号 */
	@ExportConfig(value = "赔款计算书号",width = 80)
	private String compensateNo;
	/** 被保险人名称 */
	@ExportConfig(value = "被保险人名称",width = 80)
	private String insuredName;
	/** 核赔通过日期 */
	@ExportConfig(value = "核赔通过日期",width = 80)
	private String underWriteEndDate;
	/** 赔款类型 */
	@ExportConfig(value = "赔款类型",width = 80)
	private String paymentType;
	/** 赔款类型名称 */
	//@ExportConfig(value = "赔款类型",width = 80)
	private String paymentTypeName;
	/** 总赔款 */
	@ExportConfig(value = "总赔款",width = 80)
	private String totalPayAmount;
	/** 未录入金额 */
	@ExportConfig(value = "未录入金额",width = 80)
	private String noEnterAmount;
	/** 在途金额 */
	@ExportConfig(value = "在途金额",width = 80)
	private String onTheWayAmount;
	/** 已支付金额 */
	@ExportConfig(value = "已支付金额",width = 80)
	private String payedAmount;

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public String getCompensateNo() {
		return compensateNo;
	}

	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getUnderWriteEndDate() {
		return underWriteEndDate;
	}

	public void setUnderWriteEndDate(String underWriteEndDate) {
		this.underWriteEndDate = underWriteEndDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getTotalPayAmount() {
		return totalPayAmount;
	}

	public void setTotalPayAmount(String totalPayAmount) {
		this.totalPayAmount = totalPayAmount;
	}

	public String getNoEnterAmount() {
		return noEnterAmount;
	}

	public void setNoEnterAmount(String noEnterAmount) {
		this.noEnterAmount = noEnterAmount;
	}

	public String getOnTheWayAmount() {
		return onTheWayAmount;
	}

	public void setOnTheWayAmount(String onTheWayAmount) {
		this.onTheWayAmount = onTheWayAmount;
	}

	public String getPayedAmount() {
		return payedAmount;
	}

	public void setPayedAmount(String payedAmount) {
		this.payedAmount = payedAmount;
	}

	public String getPaymentTypeName() {
		return paymentTypeName;
	}

	public void setPaymentTypeName(String paymentTypeName) {
		this.paymentTypeName = paymentTypeName;
	}
}
