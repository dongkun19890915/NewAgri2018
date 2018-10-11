package com.sinosoft.agriclaim.core.individuation.entity;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.recasemanage.dto.PrpLRecaseDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.PrplReturnVisitSwflogDto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EndCaseDto implements Serializable{

	/**
	 * jiaoyuzhen 2018年1月5日16:47:05
	 */
	private static final long serialVersionUID = 1L;
	
	/** 赔案号表主信息*/
	  private ArrayList prpLcaseNoDtoList;
	  /** 立案信息*/
	  private PrpLClaimDto prpLclaimDto;
	  	  
	  private PrpLRecaseDto prpLrecaseDto;
	  /** 赔款计算书信息*/
	  private List prpLcompensateDtoList;
	  /** 结案报告*/
	  private List prpLltextDtoList;
	  /** 操作状态信息*/
	  private PrpLclaimStatusDto prpLclaimStatusDto;
	  /**出险原因详细信息*/
	  private List prpLltextDtoList3;
	  
	  /** 回访主表 */
		private PrplReturnVisitSwflogDto prplreturnvisitswflogDto;
		
	  public List getPrpLltextDtoList3() {
		return prpLltextDtoList3;
	  }

	  public void setPrpLltextDtoList3(ArrayList prpLltextDtoList3) {
		this.prpLltextDtoList3 = prpLltextDtoList3;
	  }

	/**得到赔款计算书主信息
	   * @return 赔款计算书主信息
	   */
	  public List getPrpLcompensateDtoList() {
	    return prpLcompensateDtoList;
	  }

	  /**得到结案文本信息
	   * @return  结案文本信息
	   */
	  public List getPrpLltextDtoList() {
	    return prpLltextDtoList;
	  }

	  /**得到立案主表信息
	   * @return 立案主表信息
	   */
	  public PrpLClaimDto getPrpLclaimDto() {
	    return prpLclaimDto;
	  }
	  
	  public PrpLRecaseDto getPrpLrecaseDto() {
	    return prpLrecaseDto;
	  }
	  /**得到结案主表信息
	   * @return 结案主表信息
	   */
	  public ArrayList getPrpLcaseNoDtoList() {
	    return prpLcaseNoDtoList;
	  }
	  
	  /**设置操作状态信息
	   * @param prpLclaimStatusDto 操作状态信息
	   */
	  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
	    this.prpLclaimStatusDto = prpLclaimStatusDto;
	  }
	    
	  /**设置赔款计算书主信息
	   * @param setPrpLcompensateDtoList 赔款计算书主信息
	   */
	  public void setPrpLcompensateDtoList(List prpLcompensateDtoList) {
	    this.prpLcompensateDtoList = prpLcompensateDtoList;
	  }

	  /**设置结案文本信息
	   * @param prpLltextDtoList 结案文本信息
	   */
	  public void setPrpLltextDtoList(ArrayList prpLltextDtoList) {
	    this.prpLltextDtoList = prpLltextDtoList;
	  }
	  
	  /**设置立案主表信息
	   * @param prpLclaimDto 立案主表信息
	   */
	  public void setPrpLclaimDto(PrpLClaimDto prpLclaimDto) {
	    this.prpLclaimDto = prpLclaimDto;
	  }
	  
	  public void setPrpLrecaseDto(PrpLRecaseDto prpLrecaseDto) {
	    this.prpLrecaseDto = prpLrecaseDto;
	  }

	  /**设置结案主表信息
	   * @param prpLperpayDto 结案主表信息
	   */
	  public void setPrpLcaseNoDtoList(ArrayList prpLcaseNoDtoList) {
	    this.prpLcaseNoDtoList = prpLcaseNoDtoList;
	  }
	  
	  /**得到操作状态信息
	   * @return  操作状态信息
	   */   
	  public PrpLclaimStatusDto getPrpLclaimStatusDto() {
	    return prpLclaimStatusDto;
	  }

	  public PrplReturnVisitSwflogDto getPrplreturnvisitswflogDto() {
		return prplreturnvisitswflogDto;
	  }

	  public void setPrplreturnvisitswflogDto(
			  PrplReturnVisitSwflogDto prplreturnvisitswflogDto) {
		this.prplreturnvisitswflogDto = prplreturnvisitswflogDto;
	  }

	  public EndCaseDto()
	  {
	  }
}
