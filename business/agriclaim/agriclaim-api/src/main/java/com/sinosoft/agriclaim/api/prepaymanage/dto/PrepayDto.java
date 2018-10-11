package com.sinosoft.agriclaim.api.prepaymanage.dto;

import java.io.Serializable;
import java.util.List;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.framework.dto.BaseRequest;

public class PrepayDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
    /**更新prpclaim表的sumpaid*/
	private String sumPaid;
	 /**报案号*/
	private String claimNo;
	/**工作流id*/	
	private String flowId;
	/**工作流logNo*/
	private String 	logNo;
	/**预赔文本*/
	private String context;
	/**预赔主表prpLprepay*/
	private PrpLPrepayExtDto prpLPrepayDto;
	/**预赔费用PrpLpreChargeDto*/
	private List<PrpLPreChargeDto> prpLpreChargeDtoList;
	/**预赔文本表*/
	private List<PrpLPtextDto> prpLptextDtoList;
	/**立案操作状态内容*/
	private PrpLclaimStatusDto prpLclaimStatusDto;
	/** 清单号 add by wxy 2018/4/9 */
	private String listNo;

	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public List<PrpLPreChargeDto> getPrpLpreChargeDtoList() {
		return prpLpreChargeDtoList;
	}
	public void setPrpLpreChargeDtoList(List<PrpLPreChargeDto> prpLpreChargeDtoList) {
		this.prpLpreChargeDtoList = prpLpreChargeDtoList;
	}
	public List<PrpLPtextDto> getPrpLptextDtoList() {
		return prpLptextDtoList;
	}
	public void setPrpLptextDtoList(List<PrpLPtextDto> prpLptextDtoList) {
		this.prpLptextDtoList = prpLptextDtoList;
	}
	public PrpLclaimStatusDto getPrpLclaimStatusDto() {
		return prpLclaimStatusDto;
	}
	public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
		this.prpLclaimStatusDto = prpLclaimStatusDto;
	}
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getLogNo() {
		return logNo;
	}
	public void setLogNo(String logNo) {
		this.logNo = logNo;
	}
	public String getSumPaid() {
		return sumPaid;
	}
	public void setSumPaid(String sumPaid) {
		this.sumPaid = sumPaid;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public PrpLPrepayExtDto getPrpLPrepayDto() {
		return prpLPrepayDto;
	}
	public void setPrpLPrepayDto(PrpLPrepayExtDto prpLPrepayDto) {
		this.prpLPrepayDto = prpLPrepayDto;
	}

	public String getListNo() {
		return listNo;
	}

	public void setListNo(String listNo) {
		this.listNo = listNo;
	}
}
