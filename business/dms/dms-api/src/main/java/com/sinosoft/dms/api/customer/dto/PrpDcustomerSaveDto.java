package com.sinosoft.dms.api.customer.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @description:客户增加或删除Dto类
 * @author: 钱浩
 * @date: 2017/10/21 15:07
 *  * @param userCode
 *  comCode 客户机构
 *  customerType 客户类型：1代表个体客户
 * prpDcustomerIdvDto 个体客户dto
 * prpDcustomerUnitDto 集体客户dto
 *  prpDcustomerTaxPayInfoDto 纳税人dto
 */
public class PrpDcustomerSaveDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    private String userCode;
    private String comCode;
    private String customerType;
    private  PrpDcustomerIdvDto prpDcustomerIdvDto;
    private PrpDcustomerUnitDto prpDcustomerUnitDto;
    private PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
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
