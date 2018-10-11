package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.agriprpall.api.policymanage.dto.ItemKingAgriccDto;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

/**
* @Description:总返回Dto
* @Author: 陈道洋
* @Date: 2017/10/20 11:05
*/
public class ResponseInsuranceFormPrintDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/*险种中文名称 */
	private String riskCName;
	/*投保单号 */
	private String proposalNo;
	/*保险项目 */
	private InsuraneItemsDto insuraneItemDto;
	/*投保人信息 */
	private InsuredInfoDto insuredInfoDto;
	/*传值 */
	private String  faxNumber;
	/*客服电话 */
	private String  reportPhone;
	/*邮政编码 */
	private String  postCode;
	/*签单公司地址 */
	private String  addressCName;
	/*承保明细主险 */
	private List<ItemKingAgriDto> itemKindAgriList ;
	/*承保明细附加险 */
	private List<ItemKingAgriSubDto> itemKindAgriSubList ;
	/*综合偿付能力充足率 */
	private String code1;
	/*是否达到监管要求 */
	private String code2;
	/*风险综合评级 */
	private String code3;
	//制单人
	private String operateName;
	//经办人
	private String handlerName;
	//保险费构成
	private PremiumConDto premiumConDto;
	//诉讼解决方式
	private String argueSolution;
	//仲裁委员会名称
	private String arbitBoardName;
	//蔬菜茬次
	private List<ItemKingAgriccDto> itemKingAgriccDtoList;
	private ItemKingAgriccDto itemKingAgriccDto;
	//省份
	private String comName;
	//草莓信息
	private String cmStartDate;
	private String cmEndDate;
	private String daySum;
	//条款名称
	private String clauseName;
	//草莓3130 同投保人标志
	private String insureflag;

	public String getInsureflag() {
		return insureflag;
	}

	public void setInsureflag(String insureflag) {
		this.insureflag = insureflag;
	}

	public String getArgueSolution() {
		return argueSolution;
	}

	public void setArgueSolution(String argueSolution) {
		this.argueSolution = argueSolution;
	}

	public String getArbitBoardName() {
		return arbitBoardName;
	}

	public void setArbitBoardName(String arbitBoardName) {
		this.arbitBoardName = arbitBoardName;
	}

	public PremiumConDto getPremiumConDto() {
		return premiumConDto;
	}

	public void setPremiumConDto(PremiumConDto premiumConDto) {
		this.premiumConDto = premiumConDto;
	}

	public ResponseInsuranceFormPrintDto() {
	}

	public List<ItemKingAgriDto> getItemKindAgriList() {
		return itemKindAgriList;
	}

	public void setItemKindAgriList(List<ItemKingAgriDto> itemKindAgriList) {
		this.itemKindAgriList = itemKindAgriList;
	}

	public List<ItemKingAgriSubDto> getItemKindAgriSubList() {
		return itemKindAgriSubList;
	}

	public void setItemKindAgriSubList(List<ItemKingAgriSubDto> itemKindAgriSubList) {
		this.itemKindAgriSubList = itemKindAgriSubList;
	}

	public String getOperateName() {
		return operateName;
	}

	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}

	public String getHandlerName() {
		return handlerName;
	}

	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}

	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getCode3() {
		return code3;
	}

	public void setCode3(String code3) {
		this.code3 = code3;
	}



	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getReportPhone() {
		return reportPhone;
	}

	public void setReportPhone(String reportPhone) {
		this.reportPhone = reportPhone;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddressCName() {
		return addressCName;
	}

	public void setAddressCName(String addressCName) {
		this.addressCName = addressCName;
	}

	public String getRiskCName() {
		return riskCName;
	}

	public void setRiskCName(String riskCName) {
		this.riskCName = riskCName;
	}

	public String getProposalNo() {
		return proposalNo;
	}

	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}

	public InsuraneItemsDto getInsuraneItemDto() {
		return insuraneItemDto;
	}

	public void setInsuraneItemDto(InsuraneItemsDto insuraneItemDto) {
		this.insuraneItemDto = insuraneItemDto;
	}

	public InsuredInfoDto getInsuredInfoDto() {
		return insuredInfoDto;
	}

	public void setInsuredInfoDto(InsuredInfoDto insuredInfoDto) {
		this.insuredInfoDto = insuredInfoDto;
	}

	public List<ItemKingAgriccDto> getItemKingAgriccDtoList() {
		return itemKingAgriccDtoList;
	}

	public void setItemKingAgriccDtoList(List<ItemKingAgriccDto> itemKingAgriccDtoList) {
		this.itemKingAgriccDtoList = itemKingAgriccDtoList;
	}

	public ItemKingAgriccDto getItemKingAgriccDto() {
		return itemKingAgriccDto;
	}

	public void setItemKingAgriccDto(ItemKingAgriccDto itemKingAgriccDto) {
		this.itemKingAgriccDto = itemKingAgriccDto;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getCmStartDate() {
		return cmStartDate;
	}

	public void setCmStartDate(String cmStartDate) {
		this.cmStartDate = cmStartDate;
	}

	public String getCmEndDate() {
		return cmEndDate;
	}

	public void setCmEndDate(String cmEndDate) {
		this.cmEndDate = cmEndDate;
	}

	public String getDaySum() {
		return daySum;
	}

	public void setDaySum(String daySum) {
		this.daySum = daySum;
	}

	public String getClauseName() {
		return clauseName;
	}

	public void setClauseName(String clauseName) {
		this.clauseName = clauseName;
	}
}
