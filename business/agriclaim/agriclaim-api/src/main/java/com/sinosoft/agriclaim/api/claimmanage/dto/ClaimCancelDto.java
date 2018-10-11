package com.sinosoft.agriclaim.api.claimmanage.dto;

import java.io.Serializable;
import java.util.List;

import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistRPolicyDto;
import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.ims.api.kernel.dto.UserDto;

/**
 * @description 申请注销／拒赔查询对象
 * @author 马俊玲
 * @Date 2017/11/6 14:08 
 */
public class ClaimCancelDto  extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    //编辑类型
    private String editType;
  //赔案号
    private String prpLclaimCancelClaimNo;
  //报案号
    private String registNo;
  //节点类型
    private String nodeType;
  //非车险是否已经注销/拒赔标志
    private String BZFlag;
    //立案Dto
    private PrpLClaimDto prpLClaimDto;
  //工作流ID
    private String swfLogFlowID;
  //工作流LogNo
    private String swfLogLogNo;
//    //报案Dto
//    private PrpLRegistDto prpLRegistDto;
//    //回访信息Dto
//    private PrpLRegistRPolicyDto prpLregistRPolicyDto;
  //被保险人
    private String insuredName;
  //出险地点
    private String damageAddress;
  //出险时间
    private String damageDate;
    
    
    public String getEditType() {
        return editType;
    }
    public void setEditType(String editType) {
        this.editType = editType;
    }
    public String getPrpLclaimCancelClaimNo() {
        return prpLclaimCancelClaimNo;
    }
    public void setPrpLclaimCancelClaimNo(String prpLclaimCancelClaimNo) {
        this.prpLclaimCancelClaimNo = prpLclaimCancelClaimNo;
    }
    public String getRegistNo() {
        return registNo;
    }
    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }
    public String getNodeType() {
        return nodeType;
    }
    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }
    public String getBZFlag() {
        return BZFlag;
    }
    public void setBZFlag(String bZFlag) {
        BZFlag = bZFlag;
    }
    public String getInsuredName() {
        return insuredName;
    }
    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }
    public String getDamageAddress() {
        return damageAddress;
    }
    public void setDamageAddress(String damageAddress) {
        this.damageAddress = damageAddress;
    }
    public String getDamageDate() {
        return damageDate;
    }
    public void setDamageDate(String damageDate) {
        this.damageDate = damageDate;
    }
    public PrpLClaimDto getPrpLClaimDto() {
        return prpLClaimDto;
    }
    public void setPrpLClaimDto(PrpLClaimDto prpLClaimDto) {
        this.prpLClaimDto = prpLClaimDto;
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
    
    
}
