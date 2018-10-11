package com.sinosoft.agriclaim.api.combinemanage.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLextDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLLTextDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-25 08:10:12.537 
 * 合并查看定损页面初始化Api操作对象
 */
public class ComClaimDetailQueryDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性报案号码/报案号码 */
	private String registNo ;		
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性事故号码/事故号码 */
	private String combineNo;		
	/** 属性修改人/修改人 */
	private String updateBy ;		
	/** 属性修改日期/修改日期 */
	private java.util.Date updateDate ;	
	/** 登录人员  */
	private String userCode ;	
	/** 操作类型*/
	private String editType ;		

	/** 操作类型*/
	private String riskCode ;		
	
	/** 节点类型*/
	private String nodeType ;	
	

	/** 新操作类型*/
	private String nowEditType ;
	

	/** 工作流id*/
	private String swfLogFlowID ;		

	/**工作流节点代码*/
	private String swfLogLogNo ;	
	
	/**立案号*/
	private String claimNo ;
	
	/**险种类型*/
	private String riskType ;	
	
	private List<PrpLCompensateEarDto> prpLCompensates;
	
	private   PrpLClaimDtoExt prpLClaimDtoExt;
	
	private  List<PrpLLTextDto> prpLltextDtoList;

	private  List<PrpLClaimLossDtoExt> prpLclaimLossDtoList;
	
	private  PrpLextDto prpLextDto;
	
	private   Date  registDate ;
	
	private  List<PrpDcodeDto> units;
	
	private  PrpLRegistDto  prpLRegistDto;
	
	private    List<Map<String,String>>  replevyFlag;
	
	private     List<Map<String,String>>   thirdComFlag;  
	private String context;
	
 	
	public List<Map<String,String>> getReplevyFlag() {
		return replevyFlag;
	}
	public void setReplevyFlag(List<Map<String,String>> replevyFlag) {
		this.replevyFlag = replevyFlag;
	}
	public List<Map<String,String>> getThirdComFlag() {
		return thirdComFlag;
	}
	public void setThirdComFlag(List<Map<String,String>> thirdComFlag) {
		this.thirdComFlag = thirdComFlag;
	}
	private  int intRecentCount;

	public int getIntRecentCount() {
		return intRecentCount;
	}
	public void setIntRecentCount(int intRecentCount) {
		this.intRecentCount = intRecentCount;
	}
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
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getNowEditType() {
		return nowEditType;
	}
	public void setNowEditType(String nowEditType) {
		this.nowEditType = nowEditType;
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
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getRiskType() {
		return riskType;
	}
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}
	public List<PrpLCompensateEarDto> getPrpLCompensates() {
		return prpLCompensates;
	}
	public void setPrpLCompensates(List<PrpLCompensateEarDto> prpLCompensates) {
		this.prpLCompensates = prpLCompensates;
	}
	public PrpLClaimDtoExt getPrpLClaimDtoExt() {
		return prpLClaimDtoExt;
	}
	public void setPrpLClaimDtoExt(PrpLClaimDtoExt prpLClaimDtoExt) {
		this.prpLClaimDtoExt = prpLClaimDtoExt;
	}
	public List<PrpLLTextDto> getPrpLltextDtoList() {
		return prpLltextDtoList;
	}
	public void setPrpLltextDtoList(List<PrpLLTextDto> prpLltextDtoList) {
		this.prpLltextDtoList = prpLltextDtoList;
	}
	public List<PrpLClaimLossDtoExt> getPrpLclaimLossDtoList() {
		return prpLclaimLossDtoList;
	}
	public void setPrpLclaimLossDtoList(List<PrpLClaimLossDtoExt> prpLclaimLossDtoList) {
		this.prpLclaimLossDtoList = prpLclaimLossDtoList;
	}
	public PrpLextDto getPrpLextDto() {
		return prpLextDto;
	}
	public void setPrpLextDto(PrpLextDto prpLextDto) {
		this.prpLextDto = prpLextDto;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public List<PrpDcodeDto> getUnits() {
		return units;
	}
	public void setUnits(List<PrpDcodeDto> units) {
		this.units = units;
	}
	public PrpLRegistDto getPrpLRegistDto() {
		return prpLRegistDto;
	}
	public void setPrpLRegistDto(PrpLRegistDto prpLRegistDto) {
		this.prpLRegistDto = prpLRegistDto;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
}
