package com.sinosoft.agriclaim.api.businessutilmanage.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * @description: 类功能简述：页面下拉框复选框初始化参数接收类
 * @author 安齐崇
 * @date 2017年12月9日下午3:57:58
 *
 */
public class ClaimBoxInitRequestVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/*主要的查询条件，codeType和riskCode*/
	private List<InitVo> initlist;
	/*额外的查询条件*/
	private List<ConditionVo> casecadeConditionList = new ArrayList<ConditionVo>(0);
	public List<InitVo> getInitlist() {
		return initlist;
	}
	public void setInitlist(List<InitVo> initlist) {
		this.initlist = initlist;
	}
	public List<ConditionVo> getCasecadeConditionList() {
		return casecadeConditionList;
	}
	public void setCasecadeConditionList(List<ConditionVo> casecadeConditionList) {
		this.casecadeConditionList = casecadeConditionList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
