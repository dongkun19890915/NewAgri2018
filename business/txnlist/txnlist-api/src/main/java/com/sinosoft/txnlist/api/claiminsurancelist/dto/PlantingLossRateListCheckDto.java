package com.sinosoft.txnlist.api.claiminsurancelist.dto;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 01:34:50.838 
 * 定损清单校验dto
 */
public class PlantingLossRateListCheckDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性农户代码/农户代码 */
	private String fCode ;
	/** 属性农户姓名/农户姓名 */
	private String fName ;
	/** 属性承保面积/承保面积 */
	private Double insureArea ;
	/** 属性损失面积/损失面积 */
	private Double lossArea ;
	/** 属性损失率/损失率 */
	private Double lossRate ;
	/** 属性标的*/
	private String itemCode;
	/** 属性 序号*/
	private String serialNo;
	public String getfCode() {
		return fCode;
	}

	public void setfCode(String fCode) {
		this.fCode = fCode;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public Double getInsureArea() {
		return insureArea;
	}

	public void setInsureArea(Double insureArea) {
		this.insureArea = insureArea;
	}

	public Double getLossArea() {
		return lossArea;
	}

	public void setLossArea(Double lossArea) {
		this.lossArea = lossArea;
	}

	public Double getLossRate() {
		return lossRate;
	}

	public void setLossRate(Double lossRate) {
		this.lossRate = lossRate;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
}
