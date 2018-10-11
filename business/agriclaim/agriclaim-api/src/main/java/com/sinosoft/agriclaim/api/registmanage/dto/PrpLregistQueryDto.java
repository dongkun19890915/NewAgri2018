package com.sinosoft.agriclaim.api.registmanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;
import com.sinosoft.ims.api.auth.dto.PowerConditionDto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-11 09:09:58.263 
 * 报案主表Api操作对象
 */
public class PrpLregistQueryDto extends BasePageableRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	private String editType ;
	/** 保单号 */
	private String policyNo ;
	/** 报案号 */
	private String registNo ;
	/** 机构代码 */
	private String comCode ;
	/** 机构代码 */
    private String status ;
	/** 被保人名称 */
	private String insuredName ;
	/** 耳标号 */
	private String earLabel ;
	/** 农户姓名 （养殖险）*/
	private String fname ;
	/** 农户姓名 （种植险专用）*/
	private String fname1 ;
	/** 农户身份证（种植险） */
	private String fCardID ;
	/**  权限查询对象 */
	private PowerConditionDto powerConditionDto ;
	/** 保险起期 */
	private Date startDate ;
	/** 保险止期 */
	private Date endDate ;
	private Date startEndDate;

	private Date endEndDate;
	/** 险种大类 */
	private String riskCategory ;
	/** 出险日期 */
	private String damageDate;
	/** 出险日期起期 */
	private String damageStartDate;
	/** 出险日期止期 */
	private String damageEndDate;
	/** 出险小时 */
	private String damageHour;
	/** 身份证号 */
	private String identifyNumber;

	private String damageStartHour;

	private String damageEndHour;
	/*用户登录机构代码*/
	private String loginComCode;
	/*用户代码*/
	private String userCode;
	/*用户登录岗位代码*/
	private String loginGradeCodes;
	/*表名*/
	private String tableName;
	/*userCode字段*/
	private String userCodeFields;
	/*comCode字段*/
	private String comCodeFields;

	public String getDamageStartHour() {
		return damageStartHour;
	}

	public void setDamageStartHour(String damageStartHour) {
		this.damageStartHour = damageStartHour;
	}

	public String getDamageEndHour() {
		return damageEndHour;
	}

	public void setDamageEndHour(String damageEndHour) {
		this.damageEndHour = damageEndHour;
	}

	public String getDamageStartDate() {
		return damageStartDate;
	}

	public void setDamageStartDate(String damageStartDate) {
		this.damageStartDate = damageStartDate;
	}

	public String getDamageEndDate() {
		return damageEndDate;
	}

	public void setDamageEndDate(String damageEndDate) {
		this.damageEndDate = damageEndDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartEndDate() {
		return startEndDate;
	}

	public void setStartEndDate(Date startEndDate) {
		this.startEndDate = startEndDate;
	}

	public Date getEndEndDate() {
		return endEndDate;
	}

	public void setEndEndDate(Date endEndDate) {
		this.endEndDate = endEndDate;
	}

	public String getIdentifyNumber() {
		return identifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
	public String getEditType() {
		return editType;
	}
	public void setEditType(String editType) {
		this.editType = editType;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getEarLabel() {
		return earLabel;
	}
	public void setEarLabel(String earLabel) {
		this.earLabel = earLabel;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFname1() {
		return fname1;
	}
	public void setFname1(String fname1) {
		this.fname1 = fname1;
	}
	public String getfCardID() {
		return fCardID;
	}
	public void setfCardID(String fCardID) {
		this.fCardID = fCardID;
	}
	public String getRiskCategory() {
        return riskCategory;
    }
    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }
    public PowerConditionDto getPowerConditionDto() {
		return powerConditionDto;
	}
	public void setPowerConditionDto(PowerConditionDto powerConditionDto) {
		this.powerConditionDto = powerConditionDto;
	}
	public String getDamageDate() {
        return damageDate;
    }
    public void setDamageDate(String damageDate) {
        this.damageDate = damageDate;
    }
    public String getDamageHour() {
        return damageHour;
    }
    public void setDamageHour(String damageHour) {
        this.damageHour = damageHour;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

	public String getLoginComCode() {
		return loginComCode;
	}

	public void setLoginComCode(String loginComCode) {
		this.loginComCode = loginComCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getLoginGradeCodes() {
		return loginGradeCodes;
	}

	public void setLoginGradeCodes(String loginGradeCodes) {
		this.loginGradeCodes = loginGradeCodes;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getUserCodeFields() {
		return userCodeFields;
	}

	public void setUserCodeFields(String userCodeFields) {
		this.userCodeFields = userCodeFields;
	}

	public String getComCodeFields() {
		return comCodeFields;
	}

	public void setComCodeFields(String comCodeFields) {
		this.comCodeFields = comCodeFields;
	}
}
