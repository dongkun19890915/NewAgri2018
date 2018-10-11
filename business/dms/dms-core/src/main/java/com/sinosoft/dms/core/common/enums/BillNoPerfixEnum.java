package com.sinosoft.dms.core.common.enums;

public enum BillNoPerfixEnum {
	PROPOSALNO("proposalNo", "T"), 
	POLICYNO("policyNo", "P"),
	ORDERNO("orderNo", "Q"),
	ENDORSENO("endorseNo", "E"),
	APPLYNO("applyNo", "A");

	public String getType() {
		return type;
	}

	public String getPerfix() {
		return perfix;
	}

	// 成员变量
	private String type;
	private String perfix;

	// 构造方法
	private BillNoPerfixEnum(String type, String perfix) {
		this.type = type;
		this.perfix = perfix;
	}
}
