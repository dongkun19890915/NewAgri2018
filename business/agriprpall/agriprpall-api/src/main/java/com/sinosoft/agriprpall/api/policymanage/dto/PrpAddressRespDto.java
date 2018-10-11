package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTaddressDto;

import java.util.ArrayList;
import java.util.List;

/**
* @Description: 返回返回标的地址打印信息的Dto
* @Author: 宋振振
* @Date: 14:32 2017/11/3
*/
public class PrpAddressRespDto {
    /**保单号*/
    private String policyNo;
    /**签单日期*/
    private String signDate;
    /**投保单保险地址表信息*/
    private List<PrpTaddressDto> prpTaddressDtoList=new ArrayList<PrpTaddressDto>();
    /**保单保险地址信息*/
    private List<PrpCaddressDto> prpCaddressDtoList=new ArrayList<PrpCaddressDto>();

    public List<PrpTaddressDto> getPrpTaddressDtoList() {
        return prpTaddressDtoList;
    }

    public void setPrpTaddressDtoList(List<PrpTaddressDto> prpTaddressDtoList) {
        this.prpTaddressDtoList = prpTaddressDtoList;
    }

    public List<PrpCaddressDto> getPrpCaddressDtoList() {
        return prpCaddressDtoList;
    }

    public void setPrpCaddressDtoList(List<PrpCaddressDto> prpCaddressDtoList) {
        this.prpCaddressDtoList = prpCaddressDtoList;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }
}
