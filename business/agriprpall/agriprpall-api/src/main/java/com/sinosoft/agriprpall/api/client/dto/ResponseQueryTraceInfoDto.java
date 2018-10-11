package com.sinosoft.agriprpall.api.client.dto;
/**
 * ��������"��ѯ�˱���Ϣ"������
 * @author Administrator
 *
 */
public class ResponseQueryTraceInfoDto {
	 /** ���Թ������� */
    private String flowID = "";
    /** ���Ե�ǰ�ڵ�����(��������) */
    private String nodeName = "";
    /** ���Դ����Ŵ��� */
    private String deptCode = "";
    /** ���Դ�����Ա���� */
    private String operatorName = "";
    /** ��������ʱ�� (�ύʱ��)*/
    private String flowInTime = "";
    /** �����ύʱ��(�������ʱ��) */
    private String submitTime = "";
    /** ��������״̬(����״̬) */
    private String nodeStatusName = "";
    /** ��������״̬(����) */
    private String flowStatusName = "";
    /** ������� */
    private String handleText = "";
	public String getFlowID() {
		return flowID;
	}
	public void setFlowID(String flowID) {
		this.flowID = flowID;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getFlowInTime() {
		return flowInTime;
	}
	public void setFlowInTime(String flowInTime) {
		this.flowInTime = flowInTime;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public String getNodeStatusName() {
		return nodeStatusName;
	}
	public void setNodeStatusName(String nodeStatusName) {
		this.nodeStatusName = nodeStatusName;
	}
	public String getFlowStatusName() {
		return flowStatusName;
	}
	public void setFlowStatusName(String flowStatusName) {
		this.flowStatusName = flowStatusName;
	}
	public String getHandleText() {
		return handleText;
	}
	public void setHandleText(String handleText) {
		this.handleText = handleText;
	}
	
}
