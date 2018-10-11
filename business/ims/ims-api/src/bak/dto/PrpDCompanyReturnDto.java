package com.sinosoft.ims.api.kernel.dto;

import java.util.ArrayList;
import java.util.List;

import com.sinosoft.framework.dto.ResponseDto;

public class PrpDCompanyReturnDto extends ResponseDto implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	List<PrpDCompanyDto> prpDCompanyList = new ArrayList<PrpDCompanyDto>();

    public List<PrpDCompanyDto> getPrpDCompanyList()
    {
        return prpDCompanyList;
    }

    public void setPrpDCompanyList(List<PrpDCompanyDto> prpDCompanyList)
    {
        this.prpDCompanyList = prpDCompanyList;
    }
	
	
	
}
