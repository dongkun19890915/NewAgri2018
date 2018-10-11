package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.agriprpall.api.proposalmanage.dto.ItemKingAgriSubDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PremiumConDto;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:总返回Dto
 * @Author: 潘峰
 * @Date: 2017/10/20 11:05
 */
public class ResponsePolicyPrintDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String clauseName;
    /*险种中文名称 */
    private String riskCName;
    /*投保单号 */
    private String policyNo;
    /*保险项目 */
    private InsuraneItemsDto insuraneitems;
    /*投保人信息 */
    private InsuredInfoDto insuredInfo;
    /*传值 */
    private String faxNumber;
    /*客服电话 */
    private String reportPhone;
    /*邮政编码 */
    private String postCode;
    /*签单公司地址 */
    private String addressCName;
    /*承保明细主险 */
    private List<ItemKingAgriDto> itemKindAgriList;
    /*承保明细附加险 */
    private List<ItemKingAgriSubDto> itemKindAgriSubList;
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
    private String ArbitBoardName;
    private String oneFlag;
    private String twoFlag;
    private String threeFlag;
    private String fourFlag;
    private String fiveFlag;
    private String sixFlag;
    private String insureAddress;
    private String date;
    private String text;
    private String text1;
    private String textFlag;
    private String text1Flag;
    //蔬菜茬次
    private List<ItemKingAgriccDto> itemKingAgriccDtoList;
    private ItemKingAgriccDto itemKingAgriccDto;
    //省份
    private String comName;
    //草莓信息
    private String cmStartDate;
    private String cmEndDate;
    private String daySum;
    //国元logo
    private String gylogo;

    public String getGylogo() {
        return gylogo;
    }

    public void setGylogo(String gylogo) {
        this.gylogo = gylogo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getTextFlag() {
        return textFlag;
    }

    public void setTextFlag(String textFlag) {
        this.textFlag = textFlag;
    }

    public String getText1Flag() {
        return text1Flag;
    }

    public void setText1Flag(String text1Flag) {
        this.text1Flag = text1Flag;
    }

    public String getInsureAddress() {
        return insureAddress;
    }

    public void setInsureAddress(String insureAddress) {
        this.insureAddress = insureAddress;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOneFlag() {
        return oneFlag;
    }

    public void setOneFlag(String oneFlag) {
        this.oneFlag = oneFlag;
    }

    public String getTwoFlag() {
        return twoFlag;
    }

    public void setTwoFlag(String twoFlag) {
        this.twoFlag = twoFlag;
    }

    public String getThreeFlag() {
        return threeFlag;
    }

    public void setThreeFlag(String threeFlag) {
        this.threeFlag = threeFlag;
    }

    public String getFourFlag() {
        return fourFlag;
    }

    public void setFourFlag(String fourFlag) {
        this.fourFlag = fourFlag;
    }

    public String getFiveFlag() {
        return fiveFlag;
    }

    public void setFiveFlag(String fiveFlag) {
        this.fiveFlag = fiveFlag;
    }

    public String getSixFlag() {
        return sixFlag;
    }

    public void setSixFlag(String sixFlag) {
        this.sixFlag = sixFlag;
    }

    public String getRiskCName() {
        return riskCName;
    }

    public void setRiskCName(String riskCName) {
        this.riskCName = riskCName;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public InsuraneItemsDto getInsuraneitems() {
        return insuraneitems;
    }

    public void setInsuraneitems(InsuraneItemsDto insuraneitems) {
        this.insuraneitems = insuraneitems;
    }

    public InsuredInfoDto getInsuredInfo() {
        return insuredInfo;
    }

    public void setInsuredInfo(InsuredInfoDto insuredInfo) {
        this.insuredInfo = insuredInfo;
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

    public PremiumConDto getPremiumConDto() {
        return premiumConDto;
    }

    public void setPremiumConDto(PremiumConDto premiumConDto) {
        this.premiumConDto = premiumConDto;
    }

    public String getArgueSolution() {
        return argueSolution;
    }

    public void setArgueSolution(String argueSolution) {
        this.argueSolution = argueSolution;
    }

    public String getArbitBoardName() {
        return ArbitBoardName;
    }

    public void setArbitBoardName(String arbitBoardName) {
        ArbitBoardName = arbitBoardName;
    }

    public String getClauseName() {
        return clauseName;
    }

    public void setClauseName(String clauseName) {
        this.clauseName = clauseName;
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
}
