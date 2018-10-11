package com.sinosoft.dms.api.dict.dto;


public class NewCodeQueryConditionDto extends PrpDNewCodeRequestDto implements java.io.Serializable {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private String codeType ;
	
	private String codeCode ;
	
	private String upperCode;
	
	private String riskCode ;
	
	private String codeCName;
	

	public String getCodeCName() {
		return codeCName;
	}

	public void setCodeCName(String codeCName) {
		this.codeCName = codeCName;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getCodeCode() {
		return codeCode;
	}

	public void setCodeCode(String codeCode) {
		this.codeCode = codeCode;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

    public String getUpperCode()
    {
        return upperCode;
    }

    public void setUpperCode(String upperCode)
    {
        this.upperCode = upperCode;
    }

	
}
