package com.sinosoft.agriprpall.api.undwrtsubmit.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-17 01:16:19.335 
 * UwNotionApi操作对象
 */
public class UwNotionDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性flowId/flowId */
	private String flowId ;		
	/** 属性logNo/logNo */
	private Integer logNo ;
	/** 属性lineNo/lineNo */
	private Integer lineNo ;
	/** 属性handleText/handleText */
	private String handleText ;		
	/** 属性flag/flag */
	private String flag ;
	/** 属性createDBy/createDBy */
	private String createDBy ;
	/** 属性createDTime/createDTime */
	private java.util.Date createDTime ;
	/** 属性updateDBy/updateDBy */
	private String updateDBy ;
	/** 属性updateDTime/updateDTime */
	private java.util.Date updateDTime ;

	public String getCreateDBy() {
		return createDBy;
	}

	public void setCreateDBy(String createDBy) {
		this.createDBy = createDBy;
	}

	public Date getCreateDTime() {
		return createDTime;
	}

	public void setCreateDTime(Date createDTime) {
		this.createDTime = createDTime;
	}

	public String getUpdateDBy() {
		return updateDBy;
	}

	public void setUpdateDBy(String updateDBy) {
		this.updateDBy = updateDBy;
	}

	public Date getUpdateDTime() {
		return updateDTime;
	}

	public void setUpdateDTime(Date updateDTime) {
		this.updateDTime = updateDTime;
	}

	/**
	 * 属性flowId/flowId的getter方法
	 */
	public String getFlowId() {
		return flowId;
	}
	/**
	 * 属性flowId/flowId的setter方法
	 */
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}	
	/**
	 * 属性logNo/logNo的getter方法
	 */
	public Integer getLogNo() {
		return logNo;
	}
	/**
	 * 属性logNo/logNo的setter方法
	 */
	public void setLogNo(Integer logNo) {
		this.logNo = logNo;
	}	
	/**
	 * 属性lineNo/lineNo的getter方法
	 */
	public Integer getLineNo() {
		return lineNo;
	}
	/**
	 * 属性lineNo/lineNo的setter方法
	 */
	public void setLineNo(Integer lineNo) {
		this.lineNo = lineNo;
	}	
	/**
	 * 属性handleText/handleText的getter方法
	 */
	public String getHandleText() {
		return handleText;
	}
	/**
	 * 属性handleText/handleText的setter方法
	 */
	public void setHandleText(String handleText) {
		this.handleText = handleText;
	}	
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
}
