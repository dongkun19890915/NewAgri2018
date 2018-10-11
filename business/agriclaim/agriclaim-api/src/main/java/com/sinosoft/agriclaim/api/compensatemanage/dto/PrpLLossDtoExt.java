package com.sinosoft.agriclaim.api.compensatemanage.dto;
/**
 * @description: 类功能简述：赔付标的信息扩展类
 * @author 安齐崇
 * @date 2017年12月2日下午4:25:58
 *
 */
public class PrpLLossDtoExt extends PrpLLossDto {
	
	private static final long serialVersionUID = 1L;
	/*险别名称*/
    private String kindName;
    private String currency1Name;
    private String currency2Name;
    private String currency3Name;
    private String currency4Name;
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	public String getCurrency1Name() {
		return currency1Name;
	}
	public void setCurrency1Name(String currency1Name) {
		this.currency1Name = currency1Name;
	}
	public String getCurrency2Name() {
		return currency2Name;
	}
	public void setCurrency2Name(String currency2Name) {
		this.currency2Name = currency2Name;
	}
	public String getCurrency3Name() {
		return currency3Name;
	}
	public void setCurrency3Name(String currency3Name) {
		this.currency3Name = currency3Name;
	}
	public String getCurrency4Name() {
		return currency4Name;
	}
	public void setCurrency4Name(String currency4Name) {
		this.currency4Name = currency4Name;
	}
    
	
    
}
