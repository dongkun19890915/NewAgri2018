package com.sinosoft.dms.api.customer.dto;

import java.io.Serializable;
import java.util.List;

public class PrpDcustomerIdvUnitDto  implements Serializable {
    private static final long serialVersionUID = 1L;
    List<PrpDcustomerIdvDto> prpDcustomerIdvDtoList;
    List<PrpDcustomerUnitDto> prpDcustomerUnitDtoList;


    public List<PrpDcustomerIdvDto> getPrpDcustomerIdvDtoList() {
        return prpDcustomerIdvDtoList;
    }

    public void setPrpDcustomerIdvDtoList(List<PrpDcustomerIdvDto> prpDcustomerIdvDtoList) {
        this.prpDcustomerIdvDtoList = prpDcustomerIdvDtoList;
    }

    public List<PrpDcustomerUnitDto> getPrpDcustomerUnitDtoList() {
        return prpDcustomerUnitDtoList;
    }

    public void setPrpDcustomerUnitDtoList(List<PrpDcustomerUnitDto> prpDcustomerUnitDtoList) {
        this.prpDcustomerUnitDtoList = prpDcustomerUnitDtoList;
    }
}
