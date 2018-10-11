package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureMainListDto;

import java.io.Serializable;

/**
 * @Description: 投保单查询详细信息responseDtoApi操作对象
 * @Author: 何伟东
 * @Date: 2017/10/19 8:12
 */
public class ResponseQueryProposalInfoDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 投保单基本信息 */
    private PrpTmainDto prpTmainDto;

    /** 合同信息 */
    private ContractinfoDto contractinfoDto;

    /** 投保人/被保人信息 */
    private CustomerInfoDto customerDto;

    /** 其他信息 */
    private OtherInfoDto otherInfoDto;

    private GisInsureMainListDto gisInsureMainListDto;

    public GisInsureMainListDto getGisInsureMainListDto() {
        return gisInsureMainListDto;
    }

    public void setGisInsureMainListDto(GisInsureMainListDto gisInsureMainListDto) {
        this.gisInsureMainListDto = gisInsureMainListDto;
    }

    public PrpTmainDto getPrpTmainDto() {
        return prpTmainDto;
    }

    public void setPrpTmainDto(PrpTmainDto prpTmainDto) {
        this.prpTmainDto = prpTmainDto;
    }

    public ContractinfoDto getContractinfoDto() {
        return contractinfoDto;
    }

    public void setContractinfoDto(ContractinfoDto contractinfoDto) {
        this.contractinfoDto = contractinfoDto;
    }

    public CustomerInfoDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerInfoDto customerDto) {
        this.customerDto = customerDto;
    }

    public OtherInfoDto getOtherInfoDto() {
        return otherInfoDto;
    }

    public void setOtherInfoDto(OtherInfoDto otherInfoDto) {
        this.otherInfoDto = otherInfoDto;
    }
}
