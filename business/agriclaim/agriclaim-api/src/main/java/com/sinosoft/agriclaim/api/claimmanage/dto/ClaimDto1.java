package com.sinosoft.agriclaim.api.claimmanage.dto;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLAccIPersonDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLextDto;
import com.sinosoft.agriclaim.api.docmanage.dto.PrpLDocDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistExtDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistRPolicyDto;

import java.util.List;

public class ClaimDto1 {
	
	/**是否自动立案*/ 
	private String ifAuto;
	/**报案号*/ 
	private String claimNo;
	/**立案文本表prpLltext*/ 
	private String context;
	/**工作流id*/ 
	private String flowId;
	/**工作流的logNo*/ 
	private String logNo;
	/** 立案主信息 */
	private PrpLClaimDtoExt prpLClaimDto;
	/** 险别估损金额 */
	private List<PrpLClaimLossDto> prpLclaimLossDtoList;
	/** 操作状态信息 */
	private PrpLclaimStatusDto prpLclaimStatusDto;
	/** 文本信息 */
	private List<PrpLLTextDto> prpLltextDtoList;
	/** 关联表  */
	private PrpLRegistRPolicyDto prpLRegistRPolicyDto;
	 /** 立案耳标号信息表 */
    private List<PrpLCompensateEarRegistDto> prpLcompensateeartDtoList;
    /** 特殊赔案：垫支付 */
    private List<PrpLPrepayDto> prpLprepayDtoList;
    /** 索赔人信息 */
    private List<PrpLAccIPersonDto> prpLacciPersonDtoList;
    /** 事故者信息 */
    private List<PrpLAccIPersonDto> prplacciBenPersonDtoList;
    /** 估损金额 */
    private List<PrpLClaimFeeDto> prpLclaimFeeDtoList;
    /** 单证信息 */
    private List<PrpLDocDto> prpLdocDtoList;
    /** 报案信息补充说明 */
    private List<PrpLRegistExtDto> prpLregistExtDtoList;
    /** 立案信息扩展表  */
    private PrpLextDto prpLextDto;

	
	
	public PrpLclaimStatusDto getPrpLclaimStatusDto() {
		return prpLclaimStatusDto;
	}
	public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
		this.prpLclaimStatusDto = prpLclaimStatusDto;
	}
	public PrpLRegistRPolicyDto getPrpLRegistRPolicyDto() {
		return prpLRegistRPolicyDto;
	}
	public void setPrpLRegistRPolicyDto(PrpLRegistRPolicyDto prpLRegistRPolicyDto) {
		this.prpLRegistRPolicyDto = prpLRegistRPolicyDto;
	}
	public List<PrpLClaimLossDto> getPrpLclaimLossDtoList() {
		return prpLclaimLossDtoList;
	}
	public void setPrpLclaimLossDtoList(List<PrpLClaimLossDto> prpLclaimLossDtoList) {
		this.prpLclaimLossDtoList = prpLclaimLossDtoList;
	}
	public List<PrpLLTextDto> getPrpLltextDtoList() {
		return prpLltextDtoList;
	}
	public void setPrpLltextDtoList(List<PrpLLTextDto> prpLltextDtoList) {
		this.prpLltextDtoList = prpLltextDtoList;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
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
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public List<PrpLCompensateEarRegistDto> getPrpLcompensateeartDtoList() {
		return prpLcompensateeartDtoList;
	}
	public void setPrpLcompensateeartDtoList(List<PrpLCompensateEarRegistDto> prpLcompensateeartDtoList) {
		this.prpLcompensateeartDtoList = prpLcompensateeartDtoList;
	}
	public PrpLClaimDtoExt getPrpLClaimDto() {
		return prpLClaimDto;
	}
	public void setPrpLClaimDto(PrpLClaimDtoExt prpLClaimDto) {
		this.prpLClaimDto = prpLClaimDto;
	}
	public String getIfAuto() {
		return ifAuto;
	}
	public void setIfAuto(String ifAuto) {
		this.ifAuto = ifAuto;
	}
    public List<PrpLPrepayDto> getPrpLprepayDtoList() {
        return prpLprepayDtoList;
    }
    public void setPrpLprepayDtoList(List<PrpLPrepayDto> prpLprepayDtoList) {
        this.prpLprepayDtoList = prpLprepayDtoList;
    }
    public List<PrpLAccIPersonDto> getPrpLacciPersonDtoList() {
        return prpLacciPersonDtoList;
    }
    public void setPrpLacciPersonDtoList(List<PrpLAccIPersonDto> prpLacciPersonDtoList) {
        this.prpLacciPersonDtoList = prpLacciPersonDtoList;
    }
    public List<PrpLAccIPersonDto> getPrplacciBenPersonDtoList() {
        return prplacciBenPersonDtoList;
    }
    public void setPrplacciBenPersonDtoList(List<PrpLAccIPersonDto> prplacciBenPersonDtoList) {
        this.prplacciBenPersonDtoList = prplacciBenPersonDtoList;
    }
    public List<PrpLClaimFeeDto> getPrpLclaimFeeDtoList() {
        return prpLclaimFeeDtoList;
    }
    public void setPrpLclaimFeeDtoList(List<PrpLClaimFeeDto> prpLclaimFeeDtoList) {
        this.prpLclaimFeeDtoList = prpLclaimFeeDtoList;
    }
    public List<PrpLDocDto> getPrpLdocDtoList() {
        return prpLdocDtoList;
    }
    public void setPrpLdocDtoList(List<PrpLDocDto> prpLdocDtoList) {
        this.prpLdocDtoList = prpLdocDtoList;
    }
    public List<PrpLRegistExtDto> getPrpLregistExtDtoList() {
        return prpLregistExtDtoList;
    }
    public void setPrpLregistExtDtoList(List<PrpLRegistExtDto> prpLregistExtDtoList) {
        this.prpLregistExtDtoList = prpLregistExtDtoList;
    }
    public PrpLextDto getPrpLextDto() {
        return prpLextDto;
    }
    public void setPrpLextDto(PrpLextDto prpLextDto) {
        this.prpLextDto = prpLextDto;
    }
    
}
