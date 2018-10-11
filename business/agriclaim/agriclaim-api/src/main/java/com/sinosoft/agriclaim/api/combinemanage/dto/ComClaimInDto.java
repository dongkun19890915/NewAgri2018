package com.sinosoft.agriclaim.api.combinemanage.dto;

import java.io.Serializable;
import java.util.List;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLAccIPersonDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimLossDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLLTextDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistExtDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistRPolicyDto;
import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.ims.api.kernel.dto.UserDto;

public class ComClaimInDto extends ComClaimDetailQueryDto implements Serializable{
	private static final long SerialVersionUID = 1L;
	/**索赔申请人信息 */
	private List<PrpLAccIPersonDto> prpLAccIPersonDtoList;
	/**理赔节点状态信息 */
	private PrpLclaimStatusDto prpLclaimStatusDto;
	/**报案信息补充说明信息 */
	private List<PrpLRegistExtDto> prpLRegistExtDtoList;
	/**赔案保单关联信息 */
	private PrpLRegistRPolicyDto prpLRegistRPolicyDto;
	

	public static long getSerialversionuid() {
		return SerialVersionUID;
	}


	public List<PrpLAccIPersonDto> getPrpLAccIPersonDtoList() {
		return prpLAccIPersonDtoList;
	}

	public void setPrpLAccIPersonDtoList(
			List<PrpLAccIPersonDto> prpLAccIPersonDtoList) {
		this.prpLAccIPersonDtoList = prpLAccIPersonDtoList;
	}

	public PrpLRegistRPolicyDto getPrpLRegistRPolicyDto() {
		return prpLRegistRPolicyDto;
	}

	public void setPrpLRegistRPolicyDto(PrpLRegistRPolicyDto prpLRegistRPolicyDto) {
		this.prpLRegistRPolicyDto = prpLRegistRPolicyDto;
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

}
