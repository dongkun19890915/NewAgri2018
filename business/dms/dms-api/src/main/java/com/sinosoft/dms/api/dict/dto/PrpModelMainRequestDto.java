package com.sinosoft.dms.api.dict.dto;

import com.sinosoft.dms.api.model.dto.PrpMmodelComDto;
import com.sinosoft.dms.api.model.dto.PrpMmodelMainDto;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class PrpModelMainRequestDto extends PrpMmodelMainDto implements Serializable {
    //模板主板Dto
    private  PrpMmodelMainDto prpMmodelMainDto;
   //模板配置机构表Dto
    private PrpMmodelComDto prpMmodelComDto;
   //页码
    private int pageNo;
    //每页数量
    private int pageSize;

    public PrpMmodelMainDto getPrpMmodelMainDto() {
        return prpMmodelMainDto;
    }

    public void setPrpMmodelMainDto(PrpMmodelMainDto prpMmodelMainDto) {
        this.prpMmodelMainDto = prpMmodelMainDto;
    }

    public PrpMmodelComDto getPrpMmodelComDto() {
        return prpMmodelComDto;
    }

    public void setPrpMmodelComDto(PrpMmodelComDto prpMmodelComDto) {
        this.prpMmodelComDto = prpMmodelComDto;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
