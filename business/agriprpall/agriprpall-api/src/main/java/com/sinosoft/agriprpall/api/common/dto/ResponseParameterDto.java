package com.sinosoft.agriprpall.api.common.dto;

import com.sinosoft.dms.api.customer.dto.RCustomerInfoDto;
import com.sinosoft.dms.api.dict.dto.AreasDto;
import com.sinosoft.dms.api.dict.dto.PrpDcurrencyDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.kernel.dto.PrpDagentDto;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.pms.api.kernel.dto.PrpDclauseDto;
import com.sinosoft.pms.api.kernel.dto.PrpDitemAgriDto;
import com.sinosoft.pms.api.kernel.dto.PrpDkindAgriDto;

import java.util.List;

public class ResponseParameterDto {

    //归属业务员返参
    private List<PrpDuserDto> prpDuserDtoList;
    //代理人/经纪人信息返参
    private List<PrpDagentDto> prpDagentDtoList;
    //归属机构查询返参
    private List<PrpDcompanyDto> prpDcompanyDtoList;
    //客户查询返参
    private PageInfo<RCustomerInfoDto> rCustomerInfoDtoPageInfo;
    //币别查询返参
    private  List<PrpDcurrencyDto> prpDcurrencyDtoList;
    //特约及附加信息返参
    private List<PrpDclauseDto> prpDclauseDtoList;
    //主险附加险别信息返参
    private List<PrpDkindAgriDto> prpDkindDtoList;
    //归属区域
    private Object object;
    ////查询主险标的信息/附加险
    private List<PrpDitemAgriDto> prpDitemDtoList0;
    private List<PrpDitemAgriDto> prpDitemDtoList1;
    //承保清单归属区域信息查询
    private List<AreasDto> areasDtoList;


    public List<PrpDitemAgriDto> getPrpDitemDtoList0() {
        return prpDitemDtoList0;
    }

    public void setPrpDitemDtoList0(List<PrpDitemAgriDto> prpDitemDtoList0) {
        this.prpDitemDtoList0 = prpDitemDtoList0;
    }

    public List<PrpDitemAgriDto> getPrpDitemDtoList1() {
        return prpDitemDtoList1;
    }

    public void setPrpDitemDtoList1(List<PrpDitemAgriDto> prpDitemDtoList1) {
        this.prpDitemDtoList1 = prpDitemDtoList1;
    }

    public List<AreasDto> getAreasDtoList() {
        return areasDtoList;
    }

    public void setAreasDtoList(List<AreasDto> areasDtoList) {
        this.areasDtoList = areasDtoList;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public List<PrpDkindAgriDto> getPrpDkindDtoList() {
        return prpDkindDtoList;
    }

    public void setPrpDkindDtoList(List<PrpDkindAgriDto> prpDkindDtoList) {
        this.prpDkindDtoList = prpDkindDtoList;
    }

    public List<PrpDclauseDto> getPrpDclauseDtoList() {
        return prpDclauseDtoList;
    }

    public void setPrpDclauseDtoList(List<PrpDclauseDto> prpDclauseDtoList) {
        this.prpDclauseDtoList = prpDclauseDtoList;
    }

    public List<PrpDcurrencyDto> getPrpDcurrencyDtoList() {
        return prpDcurrencyDtoList;
    }

    public void setPrpDcurrencyDtoList(List<PrpDcurrencyDto> prpDcurrencyDtoList) {
        this.prpDcurrencyDtoList = prpDcurrencyDtoList;
    }

    public PageInfo<RCustomerInfoDto> getrCustomerInfoDtoPageInfo() {
        return rCustomerInfoDtoPageInfo;
    }

    public void setrCustomerInfoDtoPageInfo(PageInfo<RCustomerInfoDto> rCustomerInfoDtoPageInfo) {
        this.rCustomerInfoDtoPageInfo = rCustomerInfoDtoPageInfo;
    }

    public List<PrpDcompanyDto> getPrpDcompanyDtoList() {
        return prpDcompanyDtoList;
    }

    public void setPrpDcompanyDtoList(List<PrpDcompanyDto> prpDcompanyDtoList) {
        this.prpDcompanyDtoList = prpDcompanyDtoList;
    }

    public List<PrpDagentDto> getPrpDagentDtoList() {
        return prpDagentDtoList;
    }

    public void setPrpDagentDtoList(List<PrpDagentDto> prpDagentDtoList) {
        this.prpDagentDtoList = prpDagentDtoList;
    }

    public List<PrpDuserDto> getPrpDuserDtoList() {
        return prpDuserDtoList;
    }

    public void setPrpDuserDtoList(List<PrpDuserDto> prpDuserDtoList) {
        this.prpDuserDtoList = prpDuserDtoList;
    }
}
