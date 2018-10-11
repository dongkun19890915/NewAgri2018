package com.sinosoft.agriclaim.api.checkmanage.dto;

import java.util.List;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLPropDto;
import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLPropDtoExt;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfPathDtoExt;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
/**
 * @description: 类功能简述：查勘页面初始化返回对象
 * @author 安齐崇
 * @date 2017年11月22日下午9:43:43
 */
public class CheckPageResponseDto {
	/* 登录用户编码 */
	private String userCode;
	/* 登录用户名称 */
	private String userName;
	/* 0该险种不存在耳标号，1该险种存在耳标号 */
	private String earFlag;
	/* 登录用户所属机构名称 */
	private String comName;
	/* 登录用户所属机构 */
	private String comCode;
	/* 险种编码 */
	private String riskCode;
	/* 险种名称 */
	private String riskName;
	/* 险种类型H:种植 I:养殖 */
	private String riskType;
	/* 工作流程编号 */
	private String flowId;
	/* 工作流序号 */
	private String logNo;
	/* 模板号 ADD,EDIT 传，下同 */
	private String modelNo;
	/* 节点号 */
	private String nodeNo;
	private String nodeType;
	private String nodeName;
	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	/* 节点状态 */
	private String status;
	/* 报案号 */
	private String registNo;
	/* 编辑类型 */
	private String editType;
	/* 出险次数 */
	private int perilCount;
	private Double statQuantity;
	/*查勘摘要*/
	private String context;
	/* 工作流的配置信息 */
	private SwfPathDtoExt submitNode;
	/* 查勘扩展类 */
	private PrpLcheckDtoExt prpLcheckDto;
	/* 查勘性质下拉框 */
	private List<PrpDcodeDto> checkNatures;
	/* 核损信息扩展类 */
	private PrpLverifyLossDtoExt prpLverifyLossDto;
	/* 耳标号信息，养殖险有 */
	private List<PrpLCompensateEarDto> prpLCompensateEarDtoList;
    private List<PrpLPropDtoExt> prpLpropDtoList;
    private PrpLclaimStatusDto prpLclaimStatusDto;
	public Double getStatQuantity() {
		return statQuantity;
	}

	public void setStatQuantity(Double statQuantity) {
		this.statQuantity = statQuantity;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getLogNo() {
		return logNo;
	}

	public void setLogNo(String logNo) {
		this.logNo = logNo;
	}

	public PrpLclaimStatusDto getPrpLclaimStatusDto() {
		return prpLclaimStatusDto;
	}

	public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
		this.prpLclaimStatusDto = prpLclaimStatusDto;
	}

	public List<PrpLPropDtoExt> getPrpLpropDtoList() {
		return prpLpropDtoList;
	}

	public void setPrpLpropDtoList(List<PrpLPropDtoExt> prpLpropDtoList) {
		this.prpLpropDtoList = prpLpropDtoList;
	}

	public PrpLverifyLossDtoExt getPrpLverifyLossDto() {
		return prpLverifyLossDto;
	}

	public void setPrpLverifyLossDto(PrpLverifyLossDtoExt prpLverifyLossDto) {
		this.prpLverifyLossDto = prpLverifyLossDto;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public PrpLcheckDtoExt getPrpLcheckDto() {
		return prpLcheckDto;
	}

	public void setPrpLcheckDto(PrpLcheckDtoExt prpLcheckDto) {
		this.prpLcheckDto = prpLcheckDto;
	}

	public String getEarFlag() {
		return earFlag;
	}

	public void setEarFlag(String earFlag) {
		this.earFlag = earFlag;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public String getRiskType() {
		return riskType;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getNodeNo() {
		return nodeNo;
	}

	public void setNodeNo(String nodeNo) {
		this.nodeNo = nodeNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public String getEditType() {
		return editType;
	}

	public void setEditType(String editType) {
		this.editType = editType;
	}

	public int getPerilCount() {
		return perilCount;
	}

	public void setPerilCount(int perilCount) {
		this.perilCount = perilCount;
	}

	public SwfPathDtoExt getSubmitNode() {
		return submitNode;
	}

	public void setSubmitNode(SwfPathDtoExt submitNode) {
		this.submitNode = submitNode;
	}

	public List<PrpDcodeDto> getCheckNatures() {
		return checkNatures;
	}

	public void setCheckNatures(List<PrpDcodeDto> checkNatures) {
		this.checkNatures = checkNatures;
	}

	public List<PrpLCompensateEarDto> getPrpLCompensateEarDtoList() {
		return prpLCompensateEarDtoList;
	}

	public void setPrpLCompensateEarDtoList(List<PrpLCompensateEarDto> prpLCompensateEarDtoList) {
		this.prpLCompensateEarDtoList = prpLCompensateEarDtoList;
	}

}
