package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "prpdnewcoderisk")
@IdClass(PrpDNewCodeRiskKey.class)
public class PrpDNewCodeRisk implements BaseEntity,Serializable{
	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codeCode")
    private String codeCode;

    @Id
    @Column(name = "codeType")
    private String codeType;

    @Id
    @Column(name = "riskCode")
    private String riskCode;

	public String getCodeCode() {
		return codeCode;
	}

	public void setCodeCode(String codeCode) {
		this.codeCode = codeCode;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	
    
}
