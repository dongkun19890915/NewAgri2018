package com.sinosoft.agriclaim.api.combinemanage.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLextDto;
import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLPropDto;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLCheckDto;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLverifyLossDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLLTextDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistTextDto;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-25 08:10:12.537 
 * 合并查看定损页面初始化Api操作对象
 */
public class ComCheckDetailQueryDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性报案号码/报案号码 */
	private String registNo ;		
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性事故号码/事故号码 */
	private String combineNo ;		
	/** 属性修改人/修改人 */
	private String updateBy ;		
	/** 属性修改日期/修改日期 */
	private java.util.Date updateDate ;	
	/** 登录人员  */
	private String userCode ;	
	/** 操作类型*/
	private String editType ;		

	/** 险种代码*/
	private String riskCode ;		

	/** 工作流id*/
	private String swfLogFlowID ;		

	/**工作流节点代码*/
	private String swfLogLogNo ;		
	/** 承保数量*/
	private Double statQuantity;
	/**查勘定损*/
	private String checkNo;
	
	private  int intRecentCount;
	private List<PrpLCompensateEarDto> prpLCompensates;
	
	private   Date  registDate ;
	
	private PrpLverifyLossDto prpLverifyLossDto;
	
	private List<PrpLPropDtoExt> prpLPropDtoList;
	
	private  PrpLRegistDto  prpLRegistDto;
	
	private  PrpLCheckDtoExt  prpLcheckDtoExt;
	private   List<PrpDcodeDto>  checkNatures ;
	
	private  List<PrpLRegistTextDto> prpLregistTextDtos;
	/** 查勘定损或者出险摘要*/
	private String context;
	/**
	 * 属性报案号码/报案号码的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号码/报案号码的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}	
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
	/**
	 * 属性事故号码/事故号码的getter方法
	 */
	public String getCombineNo() {
		return combineNo;
	}
	/**
	 * 属性事故号码/事故号码的setter方法
	 */
	public void setCombineNo(String combineNo) {
		this.combineNo = combineNo;
	}	
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}	
	/**
	 * 属性修改日期/修改日期的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性修改日期/修改日期的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}	
	
	
	/**
	 * 属性 登录人员 的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性 登录人员 的setter方法
	 */
	public void setUserCode(String  userCode) {
		this.userCode = userCode;
	}
	
	/**
	 * 属性 操作类型的getter方法
	 */
	public String getEditType() {
		return editType;
	}
	/**
	 * 属性 操作类型 的setter方法
	 */
	public void setEditType(String editType) {
		this.editType = editType;
	}
	
	/**
	 * 属性 险种代码 的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性 险种代码 的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getSwfLogFlowID() {
		return swfLogFlowID;
	}
	public void setSwfLogFlowID(String swfLogFlowID) {
		this.swfLogFlowID = swfLogFlowID;
	}
	public String getSwfLogLogNo() {
		return swfLogLogNo;
	}
	public void setSwfLogLogNo(String swfLogLogNo) {
		this.swfLogLogNo = swfLogLogNo;
	}
	public String getCheckNo() {
		return checkNo;
	}
	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}
	public List<PrpLCompensateEarDto> getPrpLCompensates() {
		return prpLCompensates;
	}
	public void setPrpLCompensates(List<PrpLCompensateEarDto> prpLCompensates) {
		this.prpLCompensates = prpLCompensates;
	}

	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public PrpLRegistDto getPrpLRegistDto() {
		return prpLRegistDto;
	}
	public void setPrpLRegistDto(PrpLRegistDto prpLRegistDto) {
		this.prpLRegistDto = prpLRegistDto;
	}
	public List<PrpDcodeDto> getCheckNatures() {
		return checkNatures;
	}
	public void setCheckNatures(List<PrpDcodeDto> checkNatures) {
		this.checkNatures = checkNatures;
	}
	public int getIntRecentCount() {
		return intRecentCount;
	}
	public void setIntRecentCount(int intRecentCount) {
		this.intRecentCount = intRecentCount;
	}
	public PrpLCheckDtoExt getPrpLcheckDtoExt() {
		return prpLcheckDtoExt;
	}
	public void setPrpLcheckDtoExt(PrpLCheckDtoExt prpLcheckDto) {
		this.prpLcheckDtoExt = prpLcheckDto;
	}
	public List<PrpLRegistTextDto> getPrpLregistTextDtos() {
		return prpLregistTextDtos;
	}
	public void setPrpLregistTextDtos(List<PrpLRegistTextDto> prpLregistTextDtos) {
		this.prpLregistTextDtos = prpLregistTextDtos;
	}

	
	public PrpLverifyLossDto getPrpLverifyLossDto() {
		return prpLverifyLossDto;
	}
	public void setPrpLverifyLossDto(PrpLverifyLossDto prpLverifyLossDto) {
		this.prpLverifyLossDto = prpLverifyLossDto;
	}
	public List<PrpLPropDtoExt> getPrpLPropDtoList() {
		return prpLPropDtoList;
	}
	public void setPrpLPropDtoList(List<PrpLPropDtoExt> prpLPropDtoList) {
		this.prpLPropDtoList = prpLPropDtoList;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Double getStatQuantity() {
		return statQuantity;
	}

	public void setStatQuantity(Double statQuantity) {
		this.statQuantity = statQuantity;
	}
}
