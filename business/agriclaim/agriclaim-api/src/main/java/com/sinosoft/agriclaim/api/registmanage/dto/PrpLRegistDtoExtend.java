package com.sinosoft.agriclaim.api.registmanage.dto;

import java.util.List;

public class PrpLRegistDtoExtend extends PrpLRegistDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 属性理赔类型/理赔类型 */
	private String llflag ;		
	/** 出险摘要 */
	private String context;
	/** 属性文本类型 */
	private String StrDamageMessage;
	/**具体的出险原因*/
	private List<String> damageMessage;
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getStrDamageMessage() {
		return StrDamageMessage;
	}
	public void setStrDamageMessage(String strDamageMessage) {
		StrDamageMessage = strDamageMessage;
	}
	public List<String> getDamageMessage() {
		return damageMessage;
	}
	public void setDamageMessage(List<String> damageMessage) {
		this.damageMessage = damageMessage;
	}
	public String getLlflag() {
		return llflag;
	}
	public void setLlflag(String llflag) {
		this.llflag = llflag;
	}
	
}
