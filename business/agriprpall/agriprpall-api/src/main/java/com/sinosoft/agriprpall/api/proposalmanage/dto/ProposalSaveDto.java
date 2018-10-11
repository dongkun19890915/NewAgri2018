package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.dms.api.customer.dto.PrpDcustomerTaxPayInfoDto;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

/**
 * 投保单保存大对象
 * @Author: 何伟东
 * @Date: 2017/11/3 9:45
 */
public class ProposalSaveDto extends BaseRequest implements Serializable {

    /**投保单基本信息表dto */
    private PrpTmainDto prpTmainDto;
    /**续保表dto*/
    private PrpTrenewalDto prpTrenewalDto;
     /**投保人保险关系人表dto*/
    private AppliInsuredDto appliInsuredDto;
    /**被保险人保险关系人表dto*/
    private InsuredDto insuredDto;
     /**保险地址表*/
    private PrpTaddressDto prpTaddressDto;
     /**共保信息明细表dto*/
    private List<PrpTcoinsDetailDto> prpTcoinsDetailDtoList;
     /**共保信息表dto*/
    private List<PrpTcoinsDto> prpTcoinsDtoList;
     /**特别约定表dto*/
    private List<PrpTengageDto> prpTengageDtoList;
     /**税表dto*/
    private PrpTexpenseDto prpTexpenseDto;
     /**保单保额保费表dto*/
    private PrpTfeeDto prpTfeeDto;
     /**大户田块信息dto*/
    private List<PrpTfeildDto> prpTfeildDtoList;
     /**农险标的信息表dto*/
    private List<PrpTitemKindAgriDto> prpTitemKindAgriDtoList;
     /**标的子险信息dto*/
    private List<PrpTitemKindDto> prpTitemKindDtoList;
     /**农业险投保单信息表Dto*/
    private PrpTmainAgriDto prpTmainAgriDto;
     /**贷款保险保单信息dto*/
    private PrpTmainLoanDto prpTmainLoanDto;
     /**共保方收费计划表dto*/
    private List<PrpTplanCoinsDto> prpTplanCoinsDtoList;
     /**收费计划表dto*/
    private List<PrpTplanDto> prpTplanDtoList;
     /**补贴表dto*/
    private List<PrpTsubsidyDto> prpTsubsidyDtoList;
    /** 客户信息*/
    private PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto;
    /** 投保单保存类型 I新保,R续保 */
    private String editType;
    /** 续保保单号 */
    private String oldPolicyNo;
    /**暂存、保存标志*/
    private  String isSaveFlag;
    /** 金禾清单编号 */
    private String gisInsureListCode;
    /** 清单序列号*/
    private String serialNo;
    /** 区分是录入的保存还是修改的保存*/
    private String addEditExamine;

    public String getAddEditExamine() {
        return addEditExamine;
    }

    public void setAddEditExamine(String addEditExamine) {
        this.addEditExamine = addEditExamine;
    }

    public String getGisInsureListCode() {        return gisInsureListCode;    }

    public void setGisInsureListCode(String gisInsureListCode) {        this.gisInsureListCode = gisInsureListCode;    }

    public String getSerialNo() {        return serialNo;    }

    public void setSerialNo(String serialNo) {        this.serialNo = serialNo;    }

    public PrpTmainDto getPrpTmainDto() {
        return prpTmainDto;
    }

    public void setPrpTmainDto(PrpTmainDto prpTmainDto) {
        this.prpTmainDto = prpTmainDto;
    }

    public PrpTrenewalDto getPrpTrenewalDto() {
        return prpTrenewalDto;
    }

    public void setPrpTrenewalDto(PrpTrenewalDto prpTrenewalDto) {
        this.prpTrenewalDto = prpTrenewalDto;
    }

    public AppliInsuredDto getAppliInsuredDto() {        return appliInsuredDto;    }

    public void setAppliInsuredDto(AppliInsuredDto appliInsuredDto) {        this.appliInsuredDto = appliInsuredDto;    }

    public InsuredDto getInsuredDto() {        return insuredDto;    }

    public void setInsuredDto(InsuredDto insuredDto) {        this.insuredDto = insuredDto;    }

    public PrpTaddressDto getPrpTaddressDto() {
        return prpTaddressDto;
    }

    public void setPrpTaddressDto(PrpTaddressDto prpTaddressDto) {
        this.prpTaddressDto = prpTaddressDto;
    }

    public List<PrpTcoinsDetailDto> getPrpTcoinsDetailDtoList() {
        return prpTcoinsDetailDtoList;
    }

    public void setPrpTcoinsDetailDtoList(List<PrpTcoinsDetailDto> prpTcoinsDetailDtoList) {
        this.prpTcoinsDetailDtoList = prpTcoinsDetailDtoList;
    }

    public List<PrpTcoinsDto> getPrpTcoinsDtoList() {
        return prpTcoinsDtoList;
    }

    public void setPrpTcoinsDtoList(List<PrpTcoinsDto> prpTcoinsDtoList) {
        this.prpTcoinsDtoList = prpTcoinsDtoList;
    }

    public List<PrpTengageDto> getPrpTengageDtoList() {
        return prpTengageDtoList;
    }

    public void setPrpTengageDtoList(List<PrpTengageDto> prpTengageDtoList) {
        this.prpTengageDtoList = prpTengageDtoList;
    }

    public PrpTexpenseDto getPrpTexpenseDto() {        return prpTexpenseDto;    }

    public void setPrpTexpenseDto(PrpTexpenseDto prpTexpenseDto) {        this.prpTexpenseDto = prpTexpenseDto;    }

    public PrpTfeeDto getPrpTfeeDto() {
        return prpTfeeDto;
    }

    public void setPrpTfeeDto(PrpTfeeDto prpTfeeDto) {
        this.prpTfeeDto = prpTfeeDto;
    }

    public List<PrpTfeildDto> getPrpTfeildDtoList() {
        return prpTfeildDtoList;
    }

    public void setPrpTfeildDtoList(List<PrpTfeildDto> prpTfeildDtoList) {
        this.prpTfeildDtoList = prpTfeildDtoList;
    }

    public List<PrpTitemKindAgriDto> getPrpTitemKindAgriDtoList() {
        return prpTitemKindAgriDtoList;
    }

    public void setPrpTitemKindAgriDtoList(List<PrpTitemKindAgriDto> prpTitemKindAgriDtoList) {
        this.prpTitemKindAgriDtoList = prpTitemKindAgriDtoList;
    }

    public List<PrpTitemKindDto> getPrpTitemKindDtoList() {
        return prpTitemKindDtoList;
    }

    public void setPrpTitemKindDtoList(List<PrpTitemKindDto> prpTitemKindDtoList) {
        this.prpTitemKindDtoList = prpTitemKindDtoList;
    }

    public PrpTmainAgriDto getPrpTmainAgriDto() {
        return prpTmainAgriDto;
    }

    public void setPrpTmainAgriDto(PrpTmainAgriDto prpTmainAgriDto) {
        this.prpTmainAgriDto = prpTmainAgriDto;
    }

    public PrpTmainLoanDto getPrpTmainLoanDto() {
        return prpTmainLoanDto;
    }

    public void setPrpTmainLoanDto(PrpTmainLoanDto prpTmainLoanDto) {
        this.prpTmainLoanDto = prpTmainLoanDto;
    }

    public List<PrpTplanCoinsDto> getPrpTplanCoinsDtoList() {
        return prpTplanCoinsDtoList;
    }

    public void setPrpTplanCoinsDtoList(List<PrpTplanCoinsDto> prpTplanCoinsDtoList) {
        this.prpTplanCoinsDtoList = prpTplanCoinsDtoList;
    }

    public List<PrpTplanDto> getPrpTplanDtoList() {
        return prpTplanDtoList;
    }

    public void setPrpTplanDtoList(List<PrpTplanDto> prpTplanDtoList) {
        this.prpTplanDtoList = prpTplanDtoList;
    }

    public List<PrpTsubsidyDto> getPrpTsubsidyDtoList() {
        return prpTsubsidyDtoList;
    }

    public void setPrpTsubsidyDtoList(List<PrpTsubsidyDto> prpTsubsidyDtoList) {
        this.prpTsubsidyDtoList = prpTsubsidyDtoList;
    }

    public String getEditType() {
        return editType;
    }

    public void setEditType(String editType) {
        this.editType = editType;
    }

    public String getOldPolicyNo() {
        return oldPolicyNo;
    }

    public void setOldPolicyNo(String oldPolicyNo) {
        this.oldPolicyNo = oldPolicyNo;
    }

    public String getIsSaveFlag() {
        return isSaveFlag;
    }

    public void setIsSaveFlag(String isSaveFlag) {
        this.isSaveFlag = isSaveFlag;
    }

    public PrpDcustomerTaxPayInfoDto getPrpDcustomerTaxPayInfoDto() {        return prpDcustomerTaxPayInfoDto;    }

    public void setPrpDcustomerTaxPayInfoDto(PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto) {        this.prpDcustomerTaxPayInfoDto = prpDcustomerTaxPayInfoDto;    }
}