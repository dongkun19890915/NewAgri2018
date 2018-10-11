package com.sinosoft.agriclaim.api.checkmanage.dto;

import java.util.List;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLPropDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarRegistDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistTextDto;
/**
 * 查勘定损暂存、提交大对象
 * @author 杨昆
 */
public class CheckLossDto {
	/** 查勘主信息 */
	private PrpLCheckDto prpLcheckDto;
	/** 查勘报告 */
	private String context;
	
	private List<PrpLRegistTextDto> prpLregistTextDtoList;
	/** 操作状态信息 */
	private PrpLclaimStatusDto prpLclaimStatusDto;
	 /** 定损主表*/
	private PrpLverifyLossDto prpLverifyLossDto;
	  /** 财产核定损明细清单表 */
	private List<PrpLPropDto> prpLpropDtoList;
	  /** 耳标号信息 */
	private List<PrpLCompensateEarRegistDto> prpLCompensateEarDtoList;
	/**工作流号*/
	private String flowId;
	/***/
	private String logNo;
	public PrpLCheckDto getPrpLcheckDto() {
		return prpLcheckDto;
	}
	public void setPrpLcheckDto(PrpLCheckDto prpLcheckDto) {
		this.prpLcheckDto = prpLcheckDto;
	}
	public List<PrpLRegistTextDto> getPrpLregistTextDtoList() {
		return prpLregistTextDtoList;
	}
	public void setPrpLregistTextDtoList(List<PrpLRegistTextDto> prpLregistTextDtoList) {
		this.prpLregistTextDtoList = prpLregistTextDtoList;
	}
	public PrpLclaimStatusDto getPrpLclaimStatusDto() {
		return prpLclaimStatusDto;
	}
	public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
		this.prpLclaimStatusDto = prpLclaimStatusDto;
	}
	public PrpLverifyLossDto getPrpLverifyLossDto() {
		return prpLverifyLossDto;
	}
	public void setPrpLverifyLossDto(PrpLverifyLossDto prpLverifyLossDto) {
		this.prpLverifyLossDto = prpLverifyLossDto;
	}
	public List<PrpLPropDto> getPrpLpropDtoList() {
		return prpLpropDtoList;
	}
	public void setPrpLpropDtoList(List<PrpLPropDto> prpLpropDtoList) {
		this.prpLpropDtoList = prpLpropDtoList;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getLogNo() {
		return logNo;
	}
	public void setLogNo(String logNo) {
		this.logNo = logNo;
	}
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public List<PrpLCompensateEarRegistDto> getPrpLCompensateEarDtoList() {
		return prpLCompensateEarDtoList;
	}
	public void setPrpLCompensateEarDtoList(List<PrpLCompensateEarRegistDto> prpLCompensateEarDtoList) {
		this.prpLCompensateEarDtoList = prpLCompensateEarDtoList;
	}
	
	
	
}
