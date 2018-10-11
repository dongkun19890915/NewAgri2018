package com.sinosoft.agriclaim.api.registmanage.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLAccIPersonDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLextDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistRPolicyDto;
import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleItemDto;
import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleMainWfDto;

/**
 * @description: 类功能简述：报案大对象
 * @author 安齐崇
 * @date 2017年12月17日下午4:19:27
 */
public class RegistDto implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 报案信息 */
	private PrpLRegistDto prpLRegistDto;
	/** 调度主表信息 */
	private PrpLScheduleMainWfDto prpLScheduleMainWfDto;
	private List<PrpLRegistExtDto> prpLRegistExtDtoList;
	/** 操作状态信息 */
	private PrpLclaimStatusDto prpLclaimStatusDto;
	private List<PrpLClaimDto> prpLClaimDtoList;
	/** 保单关联信息 */
	private List<PrpLRegistRPolicyDto> prpLRegistRPolicyDtoList = new ArrayList<>();;
	/** 耳标号信息 */
	private List<PrpLCompensateEarDto> prpLCompensateEarDtoList;
	/** 报案文本信息 */
	private List<PrpLRegistTextDto> prpLRegistTextDtoList;
	private List<PrpLRelatePersonDto> prpLRelatePersonDtoList;
	/** 调度详细信息 */
	private List<PrpLScheduleItemDto> prpLScheduleItemDtoList;
	private PrpLRegistDtoExt prpLRegistDtoExt;
	private List<PrpLAccIPersonDto> prpLAccIPersonDtoList;
	private PrpLScheduleMainWfDto prpLscheduleMainWFDto;
	private List PrpLregistExtDtoList;
	private List prpLclaimDtoList;

	public PrpLScheduleMainWfDto getPrpLscheduleMainWFDto() {
		return prpLscheduleMainWFDto;
	}

	public void setPrpLscheduleMainWFDto(PrpLScheduleMainWfDto prpLscheduleMainWFDto) {
		this.prpLscheduleMainWFDto = prpLscheduleMainWFDto;
	}

	public List getPrpLregistExtDtoList() {
		return PrpLregistExtDtoList;
	}

	public void setPrpLregistExtDtoList(List prpLregistExtDtoList) {
		PrpLregistExtDtoList = prpLregistExtDtoList;
	}

	public List getPrpLclaimDtoList() {
		return prpLclaimDtoList;
	}

	public void setPrpLclaimDtoList(List prpLclaimDtoList) {
		this.prpLclaimDtoList = prpLclaimDtoList;
	}

	public List getPrpLcompensateEarDtoList() {
		return prpLcompensateEarDtoList;
	}

	public void setPrpLcompensateEarDtoList(List prpLcompensateEarDtoList) {
		this.prpLcompensateEarDtoList = prpLcompensateEarDtoList;
	}

	public List getPrpLregistTextDtoList() {
		return prpLregistTextDtoList;
	}

	public void setPrpLregistTextDtoList(List prpLregistTextDtoList) {
		this.prpLregistTextDtoList = prpLregistTextDtoList;
	}

	public List getPrpLrelatePersonDtoList() {
		return prpLrelatePersonDtoList;
	}

	public void setPrpLrelatePersonDtoList(List prpLrelatePersonDtoList) {
		this.prpLrelatePersonDtoList = prpLrelatePersonDtoList;
	}

	public List getPrpLscheduleItemDtoList() {
		return prpLscheduleItemDtoList;
	}

	public void setPrpLscheduleItemDtoList(List prpLscheduleItemDtoList) {
		this.prpLscheduleItemDtoList = prpLscheduleItemDtoList;
	}

	public List getPrplacciBenPersonDtoList() {
		return PrplacciBenPersonDtoList;
	}

	public void setPrplacciBenPersonDtoList(List prplacciBenPersonDtoList) {
		PrplacciBenPersonDtoList = prplacciBenPersonDtoList;
	}

	public List getPrpCengageDtoList() {
		return prpCengageDtoList;
	}

	public void setPrpCengageDtoList(List prpCengageDtoList) {
		this.prpCengageDtoList = prpCengageDtoList;
	}

	public PrpLextDto getPrpLextDto() {
		return prpLextDto;
	}

	public void setPrpLextDto(PrpLextDto prpLextDto) {
		this.prpLextDto = prpLextDto;
	}

	//更改耳标号清单列表 为 prpLcompensateEarDtoList  20110810 by GYIC 李杨 End!
	private List prpLcompensateEarDtoList;

	private List prpLregistTextDtoList;
	private List prpLrelatePersonDtoList;
	private List prpLscheduleItemDtoList;
	private List PrplacciBenPersonDtoList;

	private List prpCengageDtoList;
	private PrpLextDto prpLextDto;
	
	public List<PrpLAccIPersonDto> getPrpLAccIPersonDtoList() {
		return prpLAccIPersonDtoList;
	}

	public void setPrpLAccIPersonDtoList(List<PrpLAccIPersonDto> prpLAccIPersonDtoList) {
		this.prpLAccIPersonDtoList = prpLAccIPersonDtoList;
	}

	public PrpLRegistDto getPrpLRegistDto() {
		return prpLRegistDto;
	}

	public void setPrpLRegistDto(PrpLRegistDto prpLRegistDto) {
		this.prpLRegistDto = prpLRegistDto;
	}

	public PrpLScheduleMainWfDto getPrpLScheduleMainWfDto() {
		return prpLScheduleMainWfDto;
	}

	public void setPrpLScheduleMainWfDto(PrpLScheduleMainWfDto prpLScheduleMainWfDto) {
		this.prpLScheduleMainWfDto = prpLScheduleMainWfDto;
	}

	public List<PrpLRegistExtDto> getPrpLRegistExtDtoList() {
		return prpLRegistExtDtoList;
	}

	public void setPrpLRegistExtDtoList(List<PrpLRegistExtDto> prpLRegistExtDtoList) {
		this.prpLRegistExtDtoList = prpLRegistExtDtoList;
	}

	public PrpLclaimStatusDto getPrpLclaimStatusDto() {
		return prpLclaimStatusDto;
	}

	public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
		this.prpLclaimStatusDto = prpLclaimStatusDto;
	}

	public List<PrpLClaimDto> getPrpLClaimDtoList() {
		return prpLClaimDtoList;
	}

	public void setPrpLClaimDtoList(List<PrpLClaimDto> prpLClaimDtoList) {
		this.prpLClaimDtoList = prpLClaimDtoList;
	}

	public List<PrpLRegistRPolicyDto> getPrpLRegistRPolicyDtoList() {
		return prpLRegistRPolicyDtoList;
	}

	public void setPrpLRegistRPolicyDtoList(List<PrpLRegistRPolicyDto> prpLRegistRPolicyDtoList) {
		this.prpLRegistRPolicyDtoList = prpLRegistRPolicyDtoList;
	}


	public List<PrpLCompensateEarDto> getPrpLCompensateEarDtoList() {
		return prpLCompensateEarDtoList;
	}

	public void setPrpLCompensateEarDtoList(List<PrpLCompensateEarDto> prpLCompensateEarDtoList) {
		this.prpLCompensateEarDtoList = prpLCompensateEarDtoList;
	}

	public List<PrpLRegistTextDto> getPrpLRegistTextDtoList() {
		return prpLRegistTextDtoList;
	}

	public void setPrpLRegistTextDtoList(List<PrpLRegistTextDto> prpLRegistTextDtoList) {
		this.prpLRegistTextDtoList = prpLRegistTextDtoList;
	}

	public List<PrpLRelatePersonDto> getPrpLRelatePersonDtoList() {
		return prpLRelatePersonDtoList;
	}

	public void setPrpLRelatePersonDtoList(List<PrpLRelatePersonDto> prpLRelatePersonDtoList) {
		this.prpLRelatePersonDtoList = prpLRelatePersonDtoList;
	}

	public List<PrpLScheduleItemDto> getPrpLScheduleItemDtoList() {
		return prpLScheduleItemDtoList;
	}

	public void setPrpLScheduleItemDtoList(List<PrpLScheduleItemDto> prpLScheduleItemDtoList) {
		this.prpLScheduleItemDtoList = prpLScheduleItemDtoList;
	}

	public PrpLRegistDtoExt getPrpLRegistDtoExt() {
		return prpLRegistDtoExt;
	}

	public void setPrpLRegistDtoExt(PrpLRegistDtoExt prpLRegistDtoExt) {
		this.prpLRegistDtoExt = prpLRegistDtoExt;
	}

	public PrpLRegistRPolicyDto getPrpLRegistRPolicyDtoOfCompel() {
		for (Iterator<PrpLRegistRPolicyDto> iter = prpLRegistRPolicyDtoList.iterator(); iter.hasNext();) {
			PrpLRegistRPolicyDto prpLRegistRPolicyDto = (PrpLRegistRPolicyDto) iter.next();
			if ("0".equals(prpLRegistRPolicyDto.getRegistFlag())) {
				return prpLRegistRPolicyDto;
			}
		}
		return null;
	}

}
