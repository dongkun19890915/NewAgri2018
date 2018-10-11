package com.sinosoft.agriclaim.api.docmanage.dto;

import com.sinosoft.framework.datatype.DateTime;

import java.io.Serializable;
import java.util.List;

/**
 * 这是PrpLcertifyCollect的数据传输对象类<br>
 * 创建于 2004-07-05 17:15:52.378<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcertifyCollectDtoExt extends PrpLCertifyCollectDto implements Serializable{
	private static final long serialVersionUID = 1L;
    /** 集合 **/
    List<PrpLCertifyCollectDto> certifyCollectList;
    /** 编辑类型 */
    private String editType = "";
    /** 此立案的操作状态 1。未处理 2。正在处理 3。已完成 4。已提交 5。 撤消 */
    private String status ="";  // Modify By Sunhao,2004-08-24
    /**属性此案件的操作时间*/
    private DateTime operateDate = new DateTime(); // Modify By Sunhao,2004-08-24
    /**先别险别*/
    private String riskCode = "";
    /** 属性出险次数 */
    private int perilCount = 0;
    /**不能够提交的提示信息,如果为'',可以提交单证节点*/
    private String noSubmitMsg = "";
    

	public List<PrpLCertifyCollectDto> getCertifyCollectList() {
		return certifyCollectList;
	}

	public void setCertifyCollectList(List<PrpLCertifyCollectDto> certifyCollectList) {
		this.certifyCollectList = certifyCollectList;
	}

	public String getEditType() {
		return editType;
	}

	public void setEditType(String editType) {
		this.editType = editType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public DateTime getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(DateTime operateDate) {
		this.operateDate = operateDate;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public int getPerilCount() {
		return perilCount;
	}

	public void setPerilCount(int perilCount) {
		this.perilCount = perilCount;
	}

	public String getNoSubmitMsg() {
		return noSubmitMsg;
	}

	public void setNoSubmitMsg(String noSubmitMsg) {
		this.noSubmitMsg = noSubmitMsg;
	}


	
}
