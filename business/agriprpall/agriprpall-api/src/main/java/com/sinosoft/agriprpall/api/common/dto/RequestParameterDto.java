package com.sinosoft.agriprpall.api.common.dto;

import com.sinosoft.dms.api.customer.dto.CustomerInfoDto;
import com.sinosoft.dms.api.dict.dto.AreasParamsDto;
import com.sinosoft.dms.api.dict.dto.PrpDcurrencyRequestDto;
import com.sinosoft.ims.api.kernel.dto.AgentReqDto;
import com.sinosoft.ims.api.kernel.dto.QueryComCodeInfoDto;
import com.sinosoft.ims.api.kernel.dto.RequestPrpDuserDto;
import com.sinosoft.pms.api.kernel.dto.PrpDItemRequestParamsDto;

public class RequestParameterDto {
    private String selectType; //判断类型

    //归属区域参数
    private String codeType;//代码种类
    private String fieldExt;//上级区域代码
    //归属业务员参数
    private RequestPrpDuserDto requestPrpDuserDto; //归属业务员参数大对象
    //归属机构
    private QueryComCodeInfoDto queryComCodeInfoDto;//归属机构入参大对象
    //代理人/经纪人信息
    private AgentReqDto agentReqDto;//代理人/经纪人信息入参大对象
    //客户查询
    private CustomerInfoDto customerInfoDto;//客户查询入参大对象
    //币别查询
    private PrpDcurrencyRequestDto prpDcurrencyRequestDto;//币别查询入参大对象
    //承保清单归属区域信息查询
    private AreasParamsDto areasParamsDto;//承保清单归属区域信息查询入参大对象
    //特约及附加信息查询
    private String riskCode;//险种
    //主险附加险别信息  riskcode ,kindCName, codeType   险种代码  险种中文名称 险别类型1主险2附加险
    private String kindCName;//险种中文名称
    //主险标的信息,附加险标的信息
    private PrpDItemRequestParamsDto prpDItemRequestParamsDto;

    public PrpDItemRequestParamsDto getPrpDItemRequestParamsDto() {
        return prpDItemRequestParamsDto;
    }

    public void setPrpDItemRequestParamsDto(PrpDItemRequestParamsDto prpDItemRequestParamsDto) {
        this.prpDItemRequestParamsDto = prpDItemRequestParamsDto;
    }

    public String getKindCName() {
        return kindCName;
    }

    public void setKindCName(String kindCName) {
        this.kindCName = kindCName;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public AreasParamsDto getAreasParamsDto() {
        return areasParamsDto;
    }

    public void setAreasParamsDto(AreasParamsDto areasParamsDto) {
        this.areasParamsDto = areasParamsDto;
    }

    public PrpDcurrencyRequestDto getPrpDcurrencyRequestDto() {
        return prpDcurrencyRequestDto;
    }

    public void setPrpDcurrencyRequestDto(PrpDcurrencyRequestDto prpDcurrencyRequestDto) {
        this.prpDcurrencyRequestDto = prpDcurrencyRequestDto;
    }

    public CustomerInfoDto getCustomerInfoDto() {
        return customerInfoDto;
    }

    public void setCustomerInfoDto(CustomerInfoDto customerInfoDto) {
        this.customerInfoDto = customerInfoDto;
    }

    public AgentReqDto getAgentReqDto() {
        return agentReqDto;
    }

    public void setAgentReqDto(AgentReqDto agentReqDto) {
        this.agentReqDto = agentReqDto;
    }

    public QueryComCodeInfoDto getQueryComCodeInfoDto() {
        return queryComCodeInfoDto;
    }

    public void setQueryComCodeInfoDto(QueryComCodeInfoDto queryComCodeInfoDto) {
        this.queryComCodeInfoDto = queryComCodeInfoDto;
    }

    public RequestPrpDuserDto getRequestPrpDuserDto() {
        return requestPrpDuserDto;
    }

    public void setRequestPrpDuserDto(RequestPrpDuserDto requestPrpDuserDto) {
        this.requestPrpDuserDto = requestPrpDuserDto;
    }

    public String getSelectType() {
        return selectType;
    }

    public void setSelectType(String selectType) {
        this.selectType = selectType;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getFieldExt() {
        return fieldExt;
    }

    public void setFieldExt(String fieldExt) {
        this.fieldExt = fieldExt;
    }


}
