package com.sinosoft.agriclaim.api.endcasemanage.dto;

import java.util.List;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLLTextDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto;
import com.sinosoft.agriclaim.api.recasemanage.dto.PrpLRecaseDto;

public class EndCaseDto {

	/** 赔案号表主信息 */
	private List<PrpLCaseNoDto> prpLcaseNoDtoList;
	/** 立案信息 */
	private PrpLClaimDto prpLClaimDto;
	/** 学平险住院医疗配置赔付比例 */
	//private PrplAcciStuHospitalClaimRateDto prplAcciStuHospitalClaimRateDto;
	
	private PrpLRecaseDto prpLrecaseDto;
	/** 赔款计算书信息 */
	private List<PrpLCompensateDto> prpLcompensateDtoList;
	/** 结案报告 */
	private List<PrpLLTextDto> prpLltextDtoList;
	/** 操作状态信息 */
	private PrpLclaimStatusDto prpLclaimStatusDto;
	// add by jiangbo 2011-06-29 修改结案部分，在最下方理算部分，要分出预赔的相关信息和理算书最后赔付的金额start
	/** 预赔信息 */
	private List<PrpLPrepayDto> prpLprepayDtoList;
	private String accidentType;
	private String claimCloseTime;
	private String claimAmount;
	private String otherFee;
	private List claimCloseCoverData;
	private List closeRecoveryOrPayData;
	//private ClaimDto claimDto;
	public List<PrpLCaseNoDto> getPrpLcaseNoDtoList() {
		return prpLcaseNoDtoList;
	}
	public void setPrpLcaseNoDtoList(List<PrpLCaseNoDto> prpLcaseNoDtoList) {
		this.prpLcaseNoDtoList = prpLcaseNoDtoList;
	}
	public PrpLClaimDto getPrpLClaimDto() {
		return prpLClaimDto;
	}
	public void setPrpLClaimDto(PrpLClaimDto prpLClaimDto) {
		this.prpLClaimDto = prpLClaimDto;
	}
	public PrpLRecaseDto getPrpLrecaseDto() {
		return prpLrecaseDto;
	}
	public void setPrpLrecaseDto(PrpLRecaseDto prpLrecaseDto) {
		this.prpLrecaseDto = prpLrecaseDto;
	}
	public List<PrpLCompensateDto> getPrpLcompensateDtoList() {
		return prpLcompensateDtoList;
	}
	public void setPrpLcompensateDtoList(List<PrpLCompensateDto> prpLcompensateDtoList) {
		this.prpLcompensateDtoList = prpLcompensateDtoList;
	}
	public List<PrpLLTextDto> getPrpLltextDtoList() {
		return prpLltextDtoList;
	}
	public void setPrpLltextDtoList(List<PrpLLTextDto> prpLltextDtoList) {
		this.prpLltextDtoList = prpLltextDtoList;
	}
	public PrpLclaimStatusDto getPrpLclaimStatusDto() {
		return prpLclaimStatusDto;
	}
	public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
		this.prpLclaimStatusDto = prpLclaimStatusDto;
	}
	public List<PrpLPrepayDto> getPrpLprepayDtoList() {
		return prpLprepayDtoList;
	}
	public void setPrpLprepayDtoList(List<PrpLPrepayDto> prpLprepayDtoList) {
		this.prpLprepayDtoList = prpLprepayDtoList;
	}
	public String getAccidentType() {
		return accidentType;
	}
	public void setAccidentType(String accidentType) {
		this.accidentType = accidentType;
	}
	public String getClaimCloseTime() {
		return claimCloseTime;
	}
	public void setClaimCloseTime(String claimCloseTime) {
		this.claimCloseTime = claimCloseTime;
	}
	public String getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(String claimAmount) {
		this.claimAmount = claimAmount;
	}
	public String getOtherFee() {
		return otherFee;
	}
	public void setOtherFee(String otherFee) {
		this.otherFee = otherFee;
	}
	public List getClaimCloseCoverData() {
		return claimCloseCoverData;
	}
	public void setClaimCloseCoverData(List claimCloseCoverData) {
		this.claimCloseCoverData = claimCloseCoverData;
	}
	public List getCloseRecoveryOrPayData() {
		return closeRecoveryOrPayData;
	}
	public void setCloseRecoveryOrPayData(List closeRecoveryOrPayData) {
		this.closeRecoveryOrPayData = closeRecoveryOrPayData;
	}
	
	
	
}
