package com.sinosoft.pms.api.rate.dto;

import java.util.Date;

/**
 * @description 获取折旧率参数
 * @author HSQ
 * @date 2017年8月23日 下午4:54:54
 */
public class DeprecateRateDto {
	
	/** 条款类型 */
	private String clauseType;
	
	/** 险种代码 */
	private String riskCode;
	
	/** 座位数 */
	private int seatCount;
	
	/** 吨位数 */
	private double tonCount;
	
	/** 车辆种类 */
	private String carKind;
	
	/** 使用性质 */
	private String useNature;
	
	/** 签单日期 */
	private Date operateDate;

	public String getClauseType() {
		return clauseType;
	}

	public void setClauseType(String clauseType) {
		this.clauseType = clauseType;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public double getTonCount() {
		return tonCount;
	}

	public void setTonCount(double tonCount) {
		this.tonCount = tonCount;
	}

	public String getCarKind() {
		return carKind;
	}

	public void setCarKind(String carKind) {
		this.carKind = carKind;
	}

	public String getUseNature() {
		return useNature;
	}

	public void setUseNature(String useNature) {
		this.useNature = useNature;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

}
