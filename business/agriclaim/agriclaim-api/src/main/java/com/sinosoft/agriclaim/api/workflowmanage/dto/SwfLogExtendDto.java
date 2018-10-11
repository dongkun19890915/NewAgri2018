package com.sinosoft.agriclaim.api.workflowmanage.dto;

import java.io.Serializable;
import java.util.List;

import com.sinosoft.framework.dto.BasePageableRequest;

/**
 * @author 闫磊
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-24 05:47:03.090 
 * 工作流日志拓展表API操作对象
 */
public class SwfLogExtendDto extends BasePageableRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 属性工作流节点/工作流节点 */
	private SwfLogDto swfLogDto;
	/** 属性立案号/立案号 */
	private String claimNo ;
	/** 属性计算书号/计算书号 */
	private String compensateNo ;
	/** 属性险种名称/险种名称*/
	private String riskName ;
	/** 属性出险标的/出险标的  */
	private String lossName ;
	/** 是否已注销0注销*/
	private String flag;
	/**
	 * 属性工作流节点/工作流节点的getter方法
	 */
	public SwfLogDto getSwfLogDto() {
		return swfLogDto;
	}
	/**
	 * 属性工作流节点/工作流节点的setter方法
	 */
	public void setSwfLogDto(SwfLogDto swfLogDto) {
		this.swfLogDto = swfLogDto;
	}
	/**
	 * 属性立案号/立案号的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号/立案号的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	/**
	 * 属性计算书号/计算书号的getter方法
	 */
	public String getCompensateNo() {
		return compensateNo;
	}
	/**
	 * 属性计算书号/计算书号的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}
	/**
	 * 属性险种名称/险种名称的getter方法
	 */
	public String getRiskName() {
		return riskName;
	}
	/**
	 * 属性险种名称/险种名称的setter方法
	 */
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
	/**
	 * 属性出险标的/出险标的的getter方法
	 */
	public String getLossName() {
		return lossName;
	}
	/**
	 * 属性出险标的/出险标的的setter方法
	 */
	public void setLossName(String lossName) {
		this.lossName = lossName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
