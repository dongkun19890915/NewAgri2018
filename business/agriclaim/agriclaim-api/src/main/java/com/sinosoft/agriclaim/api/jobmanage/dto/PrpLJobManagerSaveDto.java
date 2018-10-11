package com.sinosoft.agriclaim.api.jobmanage.dto;

import java.io.Serializable;
import java.util.List;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * 自定义DTO
 *@Author:李文刚
 *@Date：2017/11/3 10:35
 */



public class PrpLJobManagerSaveDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;

    private List<PrpLJobManagerDto> prpLJobManagerDtoList;
    private List<PrpLJobLinkerDto> prpLJobLinkerDtoList;

    public List<PrpLJobManagerDto> getPrpLJobManagerDtoList() {
        return prpLJobManagerDtoList;
    }

    public void setPrpLJobManagerDtoList(List<PrpLJobManagerDto> prpLJobManagerDtoList) {
        this.prpLJobManagerDtoList = prpLJobManagerDtoList;
    }

    public List<PrpLJobLinkerDto> getPrpLJobLinkerDtoList() {
        return prpLJobLinkerDtoList;
    }

    public void setPrpLJobLinkerDtoList(List<PrpLJobLinkerDto> prpLJobLinkerDtoList) {
        this.prpLJobLinkerDtoList = prpLJobLinkerDtoList;
    }

}
