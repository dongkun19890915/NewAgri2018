package com.sinosoft.agriclaim.api.workflowmanage.dto;

import java.io.Serializable;
import java.util.List;

import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-02-03 批量分配模板所需险种名称、公司名称对象
 */
public class ResponseRiskAndCompanyDto extends BaseRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 代码号 */
	private String codecode;
	/** 代码名称 */
	private String codecname;

	public String getCodecode() {
		return codecode;
	}

	public void setCodecode(String codecode) {
		this.codecode = codecode;
	}

	public String getCodecname() {
		return codecname;
	}

	public void setCodecname(String codecname) {
		this.codecname = codecname;
	}

}
