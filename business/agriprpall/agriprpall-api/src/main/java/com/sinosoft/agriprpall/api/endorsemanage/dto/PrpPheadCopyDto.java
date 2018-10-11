package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

public class PrpPheadCopyDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    /** 属性批单号码/批单号码 */
    private String endorseNo ;
    /** 属性保单号码/保单号码 */
    private String policyNo ;
    /** 属性批单印刷号/批单印刷号 */
    private String printNo ;
    /** 属性险类代码/险类代码 */
    private String classCode ;
    /** 属性险种代码/险种代码 */
    private String riskCode ;
    /** 属性保单批改次数/保单批改次数 */
    private Integer endorseTimes ;
    /** 属性出单机构代码/出单机构代码 */
    private String makeCom ;
    /** 属性赔款计算书号/赔款计算书号 */
    private String compensateNo ;
    /** 属性被保险人代码/被保险人代码 */
    private String insuredCode ;
    /** 属性被保险人名字/被保险人名字 */
    private String insuredName ;
    /** 属性中英文/中英文 */
    private String language ;
    /** 属性保单类型/保单类型 */
    private String policyType ;
    /** 属性批改类型/批改类型 */
    private String endorType ;
    /** 属性批改日期/批改日期 */
    private Date endorDate ;
    /** 属性生效日期/生效日期 */
    private Date validDate ;
    /** 属性生效小时/生效小时 */
    private Integer validHour ;
    /** 属性经办人代码/经办人代码 */
    private String handlerCode ;
    /** 属性归属业务员代码/归属业务员代码 */
    private String handler1Code ;
    /** 属性复核人代码/复核人代码 */
    private String approverCode ;
    /** 属性最终核批人代码/最终核批人代码 */
    private String underwriteCode ;
    /** 属性最终核批人名称/最终核批人名称 */
    private String underwriteName ;
    /** 属性操作员代码/操作员代码 */
    private String operatorCode;
    /** 属性计算机输单日期/计算机输单日期 */
    private Date inputDate ;
    /** 属性计算机输单小时/计算机输单小时 */
    private Integer inputHour ;
    /** 属性业务归属机构代码/业务归属机构代码 */
    private String comCode ;
    /** 属性代理人代码/代理人代码 */
    private String agentCode ;
    /** 属性批单统计年月/批单统计年月 */
    private Date statisticSym ;
    /** 属性核批完成日期/核批完成日期 */
    private Date underwriteEndDate ;
    /** 属性核批标志/核批标志 */
    private String underwriteFlag ;
    /** 属性标志字段/标志字段 */
    private String flag ;
    /** 属性updaterCode/updaterCode */
    private String updaterCode ;
    /** 属性updateDate/updateDate */
    private Date updateDate ;
    /** 属性updateHour/updateHour */
    private String updateHour ;
    /** 属性批单打印日期/批单打印日期 */
    private Date printDate ;
    /** 属性批单收费日期/批单收费日期 */
    private Date payDate ;
    /** 属性批改申请人/批改申请人 */
    private String appliName ;
    /** 属性车险车主变更类型/车险车主变更类型 */
    private String ownerChgType ;
    /** 属性批改原因/批改原因 */
    private String endorseType ;
    /** 属性批改原因描述/批改原因描述 */
    private String endorseMessage ;
    /** 属性见费出单标志/见费出单标志 */
    private String isSeeFeeFlag ;
    /** 属性统计日期/统计日期 */
    private Date validCountDate ;
    /** 属性版本号/版本号 */
    private String versionNo ;
    /** 属性生效分钟/生效分钟 */
    private Integer validMinute ;
    /** 属性是否收取手续费/是否收取手续费 */
    private String isCommission ;
    /** 属性是否全程批改/是否全程批改 */
    private String isFullEndor ;
    /** 属性agentFlag/agentFlag */
    private String agentFlag ;
    /** 属性批改类型组/批改类型组 */
    private String arrayEndorType ;
    /** 属性clFlag/clFlag */
    private String clFlag ;
    /** 属性endorReason/endorReason */
    private String endorReason ;
    /** 属性归属业务员姓名/归属业务员姓名 */
    private String handler1Name ;
    /** 属性经办人姓名/经办人姓名 */
    private String handlerName ;
    /** 属性期限平移保单终期/期限平移保单终期 */
    private Date moveEndDate ;
    /** 属性保险期限平移标识/保险期限平移标识 */
    private String moveFlag ;
    /** 属性期限平移保单起期/期限平移保单起期 */
    private Date moveStartDate ;
    /** 属性业务类交强险及时生效 生效日期型/业务类交强险及时生效 生效日期型 */
    private Date newValidDate ;
    /** 属性业务实收确认人代码单号/业务实收确认人代码单号 */
    private String payrefCode ;
    /** 属性payrefName/payrefName */
    private String payrefName ;
    /** 属性预审核时间/预审核时间 */
    private Date precheckDate ;
    /** 属性signDate/signDate */
    private Date signDate ;
    /** 属性备用/备用 */
    private String subBusinessNature ;
    /** 属性单证号码/单证号码 */
    private String visaCode ;
    /** 属性validTime/validTime */
    private String validTime ;
    /** 属性jFeeFlag/jFeeFlag */
    private String jFeeFlag ;
    /** 属性修改人/修改人 */
    private String update_By ;
    /** 属性修改时间/修改时间 */
    private Date update_Date ;
    /** 属性cancelReasonDate/cancelReasonDate */
    private Date cancelReasonDate ;
    private String batchNo;

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getPrintNo() {
        return printNo;
    }

    public void setPrintNo(String printNo) {
        this.printNo = printNo;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public Integer getEndorseTimes() {
        return endorseTimes;
    }

    public void setEndorseTimes(Integer endorseTimes) {
        this.endorseTimes = endorseTimes;
    }

    public String getMakeCom() {
        return makeCom;
    }

    public void setMakeCom(String makeCom) {
        this.makeCom = makeCom;
    }

    public String getCompensateNo() {
        return compensateNo;
    }

    public void setCompensateNo(String compensateNo) {
        this.compensateNo = compensateNo;
    }

    public String getInsuredCode() {
        return insuredCode;
    }

    public void setInsuredCode(String insuredCode) {
        this.insuredCode = insuredCode;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getEndorType() {
        return endorType;
    }

    public void setEndorType(String endorType) {
        this.endorType = endorType;
    }

    public Date getEndorDate() {
        return endorDate;
    }

    public void setEndorDate(Date endorDate) {
        this.endorDate = endorDate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Integer getValidHour() {
        return validHour;
    }

    public void setValidHour(Integer validHour) {
        this.validHour = validHour;
    }

    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String getHandler1Code() {
        return handler1Code;
    }

    public void setHandler1Code(String handler1Code) {
        this.handler1Code = handler1Code;
    }

    public String getApproverCode() {
        return approverCode;
    }

    public void setApproverCode(String approverCode) {
        this.approverCode = approverCode;
    }

    public String getUnderwriteCode() {
        return underwriteCode;
    }

    public void setUnderwriteCode(String underwriteCode) {
        this.underwriteCode = underwriteCode;
    }

    public String getUnderwriteName() {
        return underwriteName;
    }

    public void setUnderwriteName(String underwriteName) {
        this.underwriteName = underwriteName;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Integer getInputHour() {
        return inputHour;
    }

    public void setInputHour(Integer inputHour) {
        this.inputHour = inputHour;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public Date getStatisticSym() {
        return statisticSym;
    }

    public void setStatisticSym(Date statisticSym) {
        this.statisticSym = statisticSym;
    }

    public Date getUnderwriteEndDate() {
        return underwriteEndDate;
    }

    public void setUnderwriteEndDate(Date underwriteEndDate) {
        this.underwriteEndDate = underwriteEndDate;
    }

    public String getUnderwriteFlag() {
        return underwriteFlag;
    }

    public void setUnderwriteFlag(String underwriteFlag) {
        this.underwriteFlag = underwriteFlag;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getUpdaterCode() {
        return updaterCode;
    }

    public void setUpdaterCode(String updaterCode) {
        this.updaterCode = updaterCode;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateHour() {
        return updateHour;
    }

    public void setUpdateHour(String updateHour) {
        this.updateHour = updateHour;
    }

    public Date getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getAppliName() {
        return appliName;
    }

    public void setAppliName(String appliName) {
        this.appliName = appliName;
    }

    public String getOwnerChgType() {
        return ownerChgType;
    }

    public void setOwnerChgType(String ownerChgType) {
        this.ownerChgType = ownerChgType;
    }

    public String getEndorseType() {
        return endorseType;
    }

    public void setEndorseType(String endorseType) {
        this.endorseType = endorseType;
    }

    public String getEndorseMessage() {
        return endorseMessage;
    }

    public void setEndorseMessage(String endorseMessage) {
        this.endorseMessage = endorseMessage;
    }

    public String getIsSeeFeeFlag() {
        return isSeeFeeFlag;
    }

    public void setIsSeeFeeFlag(String isSeeFeeFlag) {
        this.isSeeFeeFlag = isSeeFeeFlag;
    }

    public Date getValidCountDate() {
        return validCountDate;
    }

    public void setValidCountDate(Date validCountDate) {
        this.validCountDate = validCountDate;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public Integer getValidMinute() {
        return validMinute;
    }

    public void setValidMinute(Integer validMinute) {
        this.validMinute = validMinute;
    }

    public String getIsCommission() {
        return isCommission;
    }

    public void setIsCommission(String isCommission) {
        this.isCommission = isCommission;
    }

    public String getIsFullEndor() {
        return isFullEndor;
    }

    public void setIsFullEndor(String isFullEndor) {
        this.isFullEndor = isFullEndor;
    }

    public String getAgentFlag() {
        return agentFlag;
    }

    public void setAgentFlag(String agentFlag) {
        this.agentFlag = agentFlag;
    }

    public String getArrayEndorType() {
        return arrayEndorType;
    }

    public void setArrayEndorType(String arrayEndorType) {
        this.arrayEndorType = arrayEndorType;
    }

    public String getClFlag() {
        return clFlag;
    }

    public void setClFlag(String clFlag) {
        this.clFlag = clFlag;
    }

    public String getEndorReason() {
        return endorReason;
    }

    public void setEndorReason(String endorReason) {
        this.endorReason = endorReason;
    }

    public String getHandler1Name() {
        return handler1Name;
    }

    public void setHandler1Name(String handler1Name) {
        this.handler1Name = handler1Name;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public Date getMoveEndDate() {
        return moveEndDate;
    }

    public void setMoveEndDate(Date moveEndDate) {
        this.moveEndDate = moveEndDate;
    }

    public String getMoveFlag() {
        return moveFlag;
    }

    public void setMoveFlag(String moveFlag) {
        this.moveFlag = moveFlag;
    }

    public Date getMoveStartDate() {
        return moveStartDate;
    }

    public void setMoveStartDate(Date moveStartDate) {
        this.moveStartDate = moveStartDate;
    }

    public Date getNewValidDate() {
        return newValidDate;
    }

    public void setNewValidDate(Date newValidDate) {
        this.newValidDate = newValidDate;
    }

    public String getPayrefCode() {
        return payrefCode;
    }

    public void setPayrefCode(String payrefCode) {
        this.payrefCode = payrefCode;
    }

    public String getPayrefName() {
        return payrefName;
    }

    public void setPayrefName(String payrefName) {
        this.payrefName = payrefName;
    }

    public Date getPrecheckDate() {
        return precheckDate;
    }

    public void setPrecheckDate(Date precheckDate) {
        this.precheckDate = precheckDate;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getSubBusinessNature() {
        return subBusinessNature;
    }

    public void setSubBusinessNature(String subBusinessNature) {
        this.subBusinessNature = subBusinessNature;
    }

    public String getVisaCode() {
        return visaCode;
    }

    public void setVisaCode(String visaCode) {
        this.visaCode = visaCode;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    public String getjFeeFlag() {
        return jFeeFlag;
    }

    public void setjFeeFlag(String jFeeFlag) {
        this.jFeeFlag = jFeeFlag;
    }

    public String getUpdate_By() {
        return update_By;
    }

    public void setUpdate_By(String update_By) {
        this.update_By = update_By;
    }

    public Date getUpdate_Date() {
        return update_Date;
    }

    public void setUpdate_Date(Date update_Date) {
        this.update_Date = update_Date;
    }

    public Date getCancelReasonDate() {
        return cancelReasonDate;
    }

    public void setCancelReasonDate(Date cancelReasonDate) {
        this.cancelReasonDate = cancelReasonDate;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }
}
