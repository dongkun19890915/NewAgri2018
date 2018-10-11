package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.io.Serializable;

@Entity
@Table(name = "prpdnewcode")
@IdClass(PrpDNewCodeKey.class)
public class PrpDNewCode implements BaseEntity, Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "codeCode")
    private String codeCode;

	@Id
    @Column(name = "codeType")
    private String codeType;

	private String codeCName;

    private String codeEName;

    private String upperCode;

    private String oldCodeType;

    private String oldCodeCode;

    private String newCodeCode;

    private String commonFlag;

    private Date validDate;

    private Date inValidDate;

    private String validStatus;

    private String flag;

    public String getCodeCode()
    {
        return codeCode;
    }

    public void setCodeCode(String codeCode)
    {
        this.codeCode = codeCode;
    }

    public String getCodeType()
    {
        return codeType;
    }

    public void setCodeType(String codeType)
    {
        this.codeType = codeType;
    }

    public String getCodeCName() {
        return codeCName;
    }

    public void setCodeCName(String codeCName) {
        this.codeCName = codeCName == null ? null : codeCName.trim();
    }

    public String getCodeEName() {
        return codeEName;
    }

    public void setCodeEName(String codeEName) {
        this.codeEName = codeEName == null ? null : codeEName.trim();
    }

    public String getUpperCode() {
        return upperCode;
    }

    public void setUpperCode(String upperCode) {
        this.upperCode = upperCode == null ? null : upperCode.trim();
    }

    public String getOldCodeType() {
        return oldCodeType;
    }

    public void setOldCodeType(String oldCodeType) {
        this.oldCodeType = oldCodeType == null ? null : oldCodeType.trim();
    }

    public String getOldCodeCode() {
        return oldCodeCode;
    }

    public void setOldCodeCode(String oldCodeCode) {
        this.oldCodeCode = oldCodeCode == null ? null : oldCodeCode.trim();
    }

    public String getNewCodeCode() {
        return newCodeCode;
    }

    public void setNewCodeCode(String newCodeCode) {
        this.newCodeCode = newCodeCode == null ? null : newCodeCode.trim();
    }

    public String getCommonFlag() {
        return commonFlag;
    }

    public void setCommonFlag(String commonFlag) {
        this.commonFlag = commonFlag == null ? null : commonFlag.trim();
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Date getInValidDate() {
        return inValidDate;
    }

    public void setInValidDate(Date inValidDate) {
        this.inValidDate = inValidDate;
    }

    public String getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus == null ? null : validStatus.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }
}