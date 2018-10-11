package com.sinosoft.dms.api.model.dto;

import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.pms.api.kernel.dto.CompanyListDto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class PrpMmodelMainInfoDto extends BaseRequest implements Serializable {
    //判断模板号是否存在
    private HashMap<String,String> map;
    //金禾清单编号
    private String gisInsureListCode;
    //清单序列号
    private Integer serialNo;
    /**
     * 属性清单归属区域（省级）名称-标准区划代码/清单归属区域（省级）名称-标准区划代码
     */
    private String fProvinceName;
    /**
     * 属性清单归属区域（市级）名称-标准区划代码/清单归属区域（市级）名称-标准区划代码
     */
    private String fCityName;
    /**
     * 属性清单归属区域（县/区级）名称-标准区划代码/清单归属区域（县/区级）名称-标准区划代码
     */
    private String fCountyName;
    /**
     * 属性清单归属区域（镇级）名称-标准区划代码/清单归属区域（镇级）名称-标准区划代码
     */
    private String fTownName;
    /**
     * 属性清单归属区域（村级）名称-标准区划代码/清单归属区域（村级）名称-标准区划代码
     */
    private String fVillageName;
    /** 属性清单类型/清单类型 */
    private String valicity ;
    /** 属性清单备注/清单备注 */
    private String remark ;
    /** 属性清单编号/清单编号 */
    private String insureListCode ;
    /** 属性承保清单归属区域/承保清单归属区域 */
    private String fareaCode ;
    private String listTypeFlag;
    //险类名称
    private String className;
    //险种名称
    private String riskCname;
    //操作人名称
    private String operatorName;
    //最近修改名称
    private String updaterName;
    private String currency2Name;
    //模板配置主表Dto
    private PrpMmodelMainDto prpMmodelMainDto;
    //模板机构配置表Dto集合
    private List<PrpMmodelComDto> prpMmodelComDtoList;
    //模板机构树
    private List<CompanyListDto> companyListDtoList;
    //模板机构配置表Dto
    private PrpMmodelComDto prpMmodelComDto;
    //模板保险地址表Dto
    private PrpModelAddressSubDto prpModelAddressSubDto;
    //模板共保信息表Dto
    private  List<PrpModelCoinsSubDto> prpModelCoinsSubDtoList;
    //模板客户纳税人信息表
    private  PrpModelCustomerTaxPayInfoSubDto prpModelCustomerTaxPayInfoSubDto;
    //模板特别约定表
    private List<PrpModelEngageSubDto> prpModelEngageSubDtoList;
    //投保人关系人表
    private PrpModelInsuredSubDto appliInsuredDto;
    //被保险人关系人表
    private PrpModelInsuredSubDto insuredDto;
    //模板农业险保单信息
    private  PrpModelMainAgriSubDto prpModelMainAgriSubDto;
    //保单基本信息表
    private PrpModelMainSubDto prpModelMainSubDto;
    //标的子险
    private List<PrpModelItemKindDto> prpModelItemKindDtoList;
    //模板农险标的附加表
    private List<PrpModelItemKindAgriDto> prpModelItemKindAgriDtoList;
    //员工代码
    private String  userCode;

    //共保细节表
    private List<PrpModelCoinsDetailDto> prpModelCoinsDetailDtoList;

    //保单保额保费表
    private PrpModelFeeSubDto prpModelFeeSubDto;

    //共保方收费信息表
    private List<PrpModelPlanCoinsDto> prpModelPlanCoinsDtoList;

    //收费计划表
    private List<PrpModelPlanSubDto> prpModelPlanSubDtoList;

    //补贴信息表
    private List<PrpModelSubsidyDto> prpModelSubsidyDtoList;
   //查询特约详细信息返回
    private List<QueryModelPrpTengageDto> queryModelPrpTengageDtoList;





    public PrpMmodelMainDto getPrpMmodelMainDto() {
        return prpMmodelMainDto;
    }

    public void setPrpMmodelMainDto(PrpMmodelMainDto prpMmodelMainDto) {
        this.prpMmodelMainDto = prpMmodelMainDto;
    }

    public List<PrpMmodelComDto> getPrpMmodelComDtoList() {
        return prpMmodelComDtoList;
    }

    public void setPrpMmodelComDtoList(List<PrpMmodelComDto> prpMmodelComDtoList) {
        this.prpMmodelComDtoList = prpMmodelComDtoList;
    }

    public PrpModelAddressSubDto getPrpModelAddressSubDto() {
        return prpModelAddressSubDto;
    }

    public void setPrpModelAddressSubDto(PrpModelAddressSubDto prpModelAddressSubDto) {
        this.prpModelAddressSubDto = prpModelAddressSubDto;
    }


    public PrpModelCustomerTaxPayInfoSubDto getPrpModelCustomerTaxPayInfoSubDto() {
        return prpModelCustomerTaxPayInfoSubDto;
    }

    public void setPrpModelCustomerTaxPayInfoSubDto(PrpModelCustomerTaxPayInfoSubDto prpModelCustomerTaxPayInfoSubDto) {
        this.prpModelCustomerTaxPayInfoSubDto = prpModelCustomerTaxPayInfoSubDto;
    }

    public PrpModelInsuredSubDto getAppliInsuredDto() {
        return appliInsuredDto;
    }

    public void setAppliInsuredDto(PrpModelInsuredSubDto appliInsuredDto) {
        this.appliInsuredDto = appliInsuredDto;
    }

    public PrpModelInsuredSubDto getInsuredDto() {
        return insuredDto;
    }

    public void setInsuredDto(PrpModelInsuredSubDto insuredDto) {
        this.insuredDto = insuredDto;
    }

    public PrpModelMainAgriSubDto getPrpModelMainAgriSubDto() {
        return prpModelMainAgriSubDto;
    }

    public void setPrpModelMainAgriSubDto(PrpModelMainAgriSubDto prpModelMainAgriSubDto) {
        this.prpModelMainAgriSubDto = prpModelMainAgriSubDto;
    }

    public PrpModelMainSubDto getPrpModelMainSubDto() {
        return prpModelMainSubDto;
    }

    public void setPrpModelMainSubDto(PrpModelMainSubDto prpModelMainSubDto) {
        this.prpModelMainSubDto = prpModelMainSubDto;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public PrpMmodelComDto getPrpMmodelComDto() {
        return prpMmodelComDto;
    }

    public void setPrpMmodelComDto(PrpMmodelComDto prpMmodelComDto) {
        this.prpMmodelComDto = prpMmodelComDto;
    }

    public List<PrpModelCoinsSubDto> getPrpModelCoinsSubDtoList() {
        return prpModelCoinsSubDtoList;
    }

    public void setPrpModelCoinsSubDtoList(List<PrpModelCoinsSubDto> prpModelCoinsSubDtoList) {
        this.prpModelCoinsSubDtoList = prpModelCoinsSubDtoList;
    }

    public List<PrpModelEngageSubDto> getPrpModelEngageSubDtoList() {
        return prpModelEngageSubDtoList;
    }

    public void setPrpModelEngageSubDtoList(List<PrpModelEngageSubDto> prpModelEngageSubDtoList) {
        this.prpModelEngageSubDtoList = prpModelEngageSubDtoList;
    }

    public List<PrpModelItemKindDto> getPrpModelItemKindDtoList() {
        return prpModelItemKindDtoList;
    }

    public void setPrpModelItemKindDtoList(List<PrpModelItemKindDto> prpModelItemKindDtoList) {
        this.prpModelItemKindDtoList = prpModelItemKindDtoList;
    }

    public List<PrpModelItemKindAgriDto> getPrpModelItemKindAgriDtoList() {
        return prpModelItemKindAgriDtoList;
    }

    public void setPrpModelItemKindAgriDtoList(List<PrpModelItemKindAgriDto> prpModelItemKindAgriDtoList) {
        this.prpModelItemKindAgriDtoList = prpModelItemKindAgriDtoList;
    }

    public List<PrpModelCoinsDetailDto> getPrpModelCoinsDetailDtoList() {
        return prpModelCoinsDetailDtoList;
    }

    public void setPrpModelCoinsDetailDtoList(List<PrpModelCoinsDetailDto> prpModelCoinsDetailDtoList) {
        this.prpModelCoinsDetailDtoList = prpModelCoinsDetailDtoList;
    }

    public PrpModelFeeSubDto getPrpModelFeeSubDto() {
        return prpModelFeeSubDto;
    }

    public void setPrpModelFeeSubDto(PrpModelFeeSubDto prpModelFeeSubDto) {
        this.prpModelFeeSubDto = prpModelFeeSubDto;
    }

    public List<PrpModelPlanCoinsDto> getPrpModelPlanCoinsDtoList() {
        return prpModelPlanCoinsDtoList;
    }

    public void setPrpModelPlanCoinsDtoList(List<PrpModelPlanCoinsDto> prpModelPlanCoinsDtoList) {
        this.prpModelPlanCoinsDtoList = prpModelPlanCoinsDtoList;
    }

    public List<PrpModelPlanSubDto> getPrpModelPlanSubDtoList() {
        return prpModelPlanSubDtoList;
    }

    public void setPrpModelPlanSubDtoList(List<PrpModelPlanSubDto> prpModelPlanSubDtoList) {
        this.prpModelPlanSubDtoList = prpModelPlanSubDtoList;
    }

    public List<PrpModelSubsidyDto> getPrpModelSubsidyDtoList() {
        return prpModelSubsidyDtoList;
    }

    public void setPrpModelSubsidyDtoList(List<PrpModelSubsidyDto> prpModelSubsidyDtoList) {
        this.prpModelSubsidyDtoList = prpModelSubsidyDtoList;
    }

    public String getCurrency2Name() {
        return currency2Name;
    }

    public void setCurrency2Name(String currency2Name) {
        this.currency2Name = currency2Name;
    }

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRiskCname() {
        return riskCname;
    }

    public void setRiskCname(String riskCname) {
        this.riskCname = riskCname;
    }

    public List<QueryModelPrpTengageDto> getQueryModelPrpTengageDtoList() {
        return queryModelPrpTengageDtoList;
    }

    public void setQueryModelPrpTengageDtoList(List<QueryModelPrpTengageDto> queryModelPrpTengageDtoList) {
        this.queryModelPrpTengageDtoList = queryModelPrpTengageDtoList;
    }

    public String getValicity() {
        return valicity;
    }

    public void setValicity(String valicity) {
        this.valicity = valicity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInsureListCode() {
        return insureListCode;
    }

    public void setInsureListCode(String insureListCode) {
        this.insureListCode = insureListCode;
    }

    public String getFareaCode() {
        return fareaCode;
    }

    public void setFareaCode(String fareaCode) {
        this.fareaCode = fareaCode;
    }

    public String getListTypeFlag() {
        return listTypeFlag;
    }

    public void setListTypeFlag(String listTypeFlag) {
        this.listTypeFlag = listTypeFlag;
    }

    public String getfProvinceName() {
        return fProvinceName;
    }

    public void setfProvinceName(String fProvinceName) {
        this.fProvinceName = fProvinceName;
    }

    public String getfCityName() {
        return fCityName;
    }

    public void setfCityName(String fCityName) {
        this.fCityName = fCityName;
    }

    public String getfCountyName() {
        return fCountyName;
    }

    public void setfCountyName(String fCountyName) {
        this.fCountyName = fCountyName;
    }

    public String getfTownName() {
        return fTownName;
    }

    public void setfTownName(String fTownName) {
        this.fTownName = fTownName;
    }

    public String getfVillageName() {
        return fVillageName;
    }

    public void setfVillageName(String fVillageName) {
        this.fVillageName = fVillageName;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getGisInsureListCode() {
        return gisInsureListCode;
    }

    public void setGisInsureListCode(String gisInsureListCode) {
        this.gisInsureListCode = gisInsureListCode;
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }

    public List<CompanyListDto> getCompanyListDtoList() {
        return companyListDtoList;
    }

    public void setCompanyListDtoList(List<CompanyListDto> companyListDtoList) {
        this.companyListDtoList = companyListDtoList;
    }
}
