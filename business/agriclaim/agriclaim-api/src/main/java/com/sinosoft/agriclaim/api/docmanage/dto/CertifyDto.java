package com.sinosoft.agriclaim.api.docmanage.dto;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.PrplReturnVisitSwflogDto;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义单证数据传输对象
 * <p>Title: 车险理赔单证DTO</p>
 * <p>Description: 车险理赔单证样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class CertifyDto implements Serializable
{
  /** 单证收集主信息*/
  private List prpLcertifyCollectDtoList;
  /** 单证收集主信息*/
  private PrpLcertifyCollectDtoExt prpLcertifyCollectDtoExt;
  /** 单证及影像信息 */
  private List prpLcertifyImgDtoList;
  /** 索赔指引信息 */
  private List prpLcertifyDirectDtoList;
  /** 质量评审内容*/
  private List prpLqualityCheckDtoList; 
  /** 操作状态信息*/
  private PrpLclaimStatusDto prpLclaimStatusDto;
  /** 操作状态信息(并案)*/
  private List prpLclaimStatusDtoList;
  /** 报案信息补充说明*/
  private List prpLregistExtDtoList;
  /** 节点名称*/
  private String nodeType;
  /**回访主表**/
 private PrplReturnVisitSwflogDto prplreturnvisitswflogDto;
 
public PrplReturnVisitSwflogDto getPrplreturnvisitswflogDto() {
	return prplreturnvisitswflogDto;
}
public void setPrplreturnvisitswflogDto(PrplReturnVisitSwflogDto prplreturnvisitswflogDto) {
	this.prplreturnvisitswflogDto = prplreturnvisitswflogDto;
}
public List getPrpLcertifyCollectDtoList() {
	return prpLcertifyCollectDtoList;
}
public void setPrpLcertifyCollectDtoList(List prpLcertifyCollectDtoList) {
	this.prpLcertifyCollectDtoList = prpLcertifyCollectDtoList;
}
public PrpLcertifyCollectDtoExt getPrpLcertifyCollectDtoExt() {
	return prpLcertifyCollectDtoExt;
}
public void setPrpLcertifyCollectDtoExt(PrpLcertifyCollectDtoExt prpLcertifyCollectDtoExt) {
	this.prpLcertifyCollectDtoExt = prpLcertifyCollectDtoExt;
}
public List getPrpLcertifyImgDtoList() {
	return prpLcertifyImgDtoList;
}
public void setPrpLcertifyImgDtoList(List prpLcertifyImgDtoList) {
	this.prpLcertifyImgDtoList = prpLcertifyImgDtoList;
}
public List getPrpLcertifyDirectDtoList() {
	return prpLcertifyDirectDtoList;
}
public void setPrpLcertifyDirectDtoList(List prpLcertifyDirectDtoList) {
	this.prpLcertifyDirectDtoList = prpLcertifyDirectDtoList;
}
public List getPrpLqualityCheckDtoList() {
	return prpLqualityCheckDtoList;
}
public void setPrpLqualityCheckDtoList(List prpLqualityCheckDtoList) {
	this.prpLqualityCheckDtoList = prpLqualityCheckDtoList;
}
public PrpLclaimStatusDto getPrpLclaimStatusDto() {
	return prpLclaimStatusDto;
}
public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
	this.prpLclaimStatusDto = prpLclaimStatusDto;
}
public List getPrpLclaimStatusDtoList() {
	return prpLclaimStatusDtoList;
}
public void setPrpLclaimStatusDtoList(List prpLclaimStatusDtoList) {
	this.prpLclaimStatusDtoList = prpLclaimStatusDtoList;
}
public List getPrpLregistExtDtoList() {
	
	return prpLregistExtDtoList;
}
public void setPrpLregistExtDtoList(List prpLregistExtDtoList) {
	this.prpLregistExtDtoList = prpLregistExtDtoList;
}
public String getNodeType() {
	return nodeType;
}
public void setNodeType(String nodeType) {
	this.nodeType = nodeType;
}

}
