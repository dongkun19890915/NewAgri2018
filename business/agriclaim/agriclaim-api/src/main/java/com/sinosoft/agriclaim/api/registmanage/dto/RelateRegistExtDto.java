package com.sinosoft.agriclaim.api.registmanage.dto;


import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
/**
 * @author 陈旭
 * @time  2017-11-14 15:38:49.324 
 * 保单关联信息Api操作对象
 */
public class RelateRegistExtDto extends PrpLRegistDto {

	private static final long serialVersionUID = 1L;

    private CompensateFeeDto compensateFeeDto;
    private String workFlowId;
	public CompensateFeeDto getCompensateFeeDto() {
		return compensateFeeDto;
	}
	public void setCompensateFeeDto(CompensateFeeDto compensateFeeDto) {
		this.compensateFeeDto = compensateFeeDto;
	}
	public String getWorkFlowId() {
		return workFlowId;
	}
	public void setWorkFlowId(String workFlowId) {
		this.workFlowId = workFlowId;
	}
    
}
