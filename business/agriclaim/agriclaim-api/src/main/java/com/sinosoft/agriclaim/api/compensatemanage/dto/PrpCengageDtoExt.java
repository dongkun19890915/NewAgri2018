package com.sinosoft.agriclaim.api.compensatemanage.dto;

import com.sinosoft.agriprpall.api.policymanage.dto.PrpCengageDto;
/**
 * @description: 类功能简述：特别约定扩展类
 * @author 安齐崇
 * @date 2017年12月22日下午4:53:41
 *
 */
public class PrpCengageDtoExt extends PrpCengageDto {
	
	private static final long serialVersionUID = 1L;
	/*特别约定文本信息*/
    private String context;
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
    
}
