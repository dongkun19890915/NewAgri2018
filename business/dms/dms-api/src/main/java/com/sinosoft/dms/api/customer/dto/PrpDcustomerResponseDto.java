package com.sinosoft.dms.api.customer.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class PrpDcustomerResponseDto extends BaseRequest implements Serializable {
    /**客户总数*/
    private Integer CustomerCount;
    /**prpDcustomerIdvDto*/
    private  PrpDcustomerIdvDto prpDcustomerIdvDto;
    /**prpDcustomerUnitDto*/
    private  PrpDcustomerUnitDto prpDcustomerUnitDto;
    /**prpDCustomerTaxPayInfoDto*/
    private PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto;

    public Integer getCustomerCount() {
        return CustomerCount;
    }

    public void setCustomerCount(Integer customerCount) {
        CustomerCount = customerCount;
    }

    public PrpDcustomerIdvDto getPrpDcustomerIdvDto() {
        return prpDcustomerIdvDto;
    }

    public void setPrpDcustomerIdvDto(PrpDcustomerIdvDto prpDcustomerIdvDto) {
        this.prpDcustomerIdvDto = prpDcustomerIdvDto;
    }

    public PrpDcustomerUnitDto getPrpDcustomerUnitDto() {
        return prpDcustomerUnitDto;
    }

    public void setPrpDcustomerUnitDto(PrpDcustomerUnitDto prpDcustomerUnitDto) {
        this.prpDcustomerUnitDto = prpDcustomerUnitDto;
    }

    public PrpDcustomerTaxPayInfoDto getPrpDcustomerTaxPayInfoDto() {
        return prpDcustomerTaxPayInfoDto;
    }

    public void setPrpDcustomerTaxPayInfoDto(PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto) {
        this.prpDcustomerTaxPayInfoDto = prpDcustomerTaxPayInfoDto;
    }
}
