package com.sinosoft.agriprpall.api.paymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-05-14 12:56:29.895
 * 银行支付录入表Api操作对象
 */
public class PrpDBankBranchDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性联行号/联行号
     */
    private String bankNumber;
    /**
     * 属性支行名称/支行名称
     */
    private String bankName;
    /**
     * 属性银行类型代码/银行类型代码
     */
    private String bankTypeCode;
    /**
     * 属性银行类型名称/银行类型名称
     */
    private String bankTypeName;
    /**
     * 属性备用字段1/备用字段1
     */
    private String bankClearCode;
    /**
     * 属性备用字段2/备用字段2
     */
    private String cpcc;
    /**
     * 属性省份代码/省份代码
     */
    private String provCode;
    /**
     * 属性备用字段3/备用字段3
     */
    private String bankClearName;
    /**
     * 属性省份名称/省份名称
     */
    private String provName;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 属性创建日期/创建日期
     */
    private String creationDate;
    /**
     * 属性最后更新者/最后更新者
     */
    private String lastUpdateBy;
    /**
     * 属性最后更新日期/最后更新日期
     */
    private String lastUpdateDate;
    /**
     * 属性银行大类代码/银行大类代码
     */
    private String belongBankValue;
    /**
     * 属性银行大类名称/银行大类名称
     */
    private String belongBankName;
    /**
     * 属性序号/序号
     */
    private String id;
    /**
     * 属性城市代码/城市代码
     */
    private String cityCode;
    /**
     * 属性城市名称/城市名称
     */
    private String cityName;
    /**
     * 属性维护标志:0:系统维护,1:人工维护/维护标志:0:系统维护,1:人工维护
     */
    private String headBankFlag;
    /**
     * 属性备用字段4/备用字段4
     */
    private String detailBankCode;
    /**
     * 属性银行大类代码2/银行大类代码2
     */
    private String detalBankCode;
    /**
     * 属性银行大类名称2/银行大类名称2
     */
    private String detalBankName;
    /**
     * 属性备用字段5/备用字段5
     */
    private String routingNumber;
    /**
     * 属性归属国家代码/归属国家代码
     */
    private String country;

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankTypeCode() {
        return bankTypeCode;
    }

    public void setBankTypeCode(String bankTypeCode) {
        this.bankTypeCode = bankTypeCode;
    }

    public String getBankTypeName() {
        return bankTypeName;
    }

    public void setBankTypeName(String bankTypeName) {
        this.bankTypeName = bankTypeName;
    }

    public String getBankClearCode() {
        return bankClearCode;
    }

    public void setBankClearCode(String bankClearCode) {
        this.bankClearCode = bankClearCode;
    }

    public String getCpcc() {
        return cpcc;
    }

    public void setCpcc(String cpcc) {
        this.cpcc = cpcc;
    }

    public String getProvCode() {
        return provCode;
    }

    public void setProvCode(String provCode) {
        this.provCode = provCode;
    }

    public String getBankClearName() {
        return bankClearName;
    }

    public void setBankClearName(String bankClearName) {
        this.bankClearName = bankClearName;
    }

    public String getProvName() {
        return provName;
    }

    public void setProvName(String provName) {
        this.provName = provName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getBelongBankValue() {
        return belongBankValue;
    }

    public void setBelongBankValue(String belongBankValue) {
        this.belongBankValue = belongBankValue;
    }

    public String getBelongBankName() {
        return belongBankName;
    }

    public void setBelongBankName(String belongBankName) {
        this.belongBankName = belongBankName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getHeadBankFlag() {
        return headBankFlag;
    }

    public void setHeadBankFlag(String headBankFlag) {
        this.headBankFlag = headBankFlag;
    }

    public String getDetailBankCode() {
        return detailBankCode;
    }

    public void setDetailBankCode(String detailBankCode) {
        this.detailBankCode = detailBankCode;
    }

    public String getDetalBankCode() {
        return detalBankCode;
    }

    public void setDetalBankCode(String detalBankCode) {
        this.detalBankCode = detalBankCode;
    }

    public String getDetalBankName() {
        return detalBankName;
    }

    public void setDetalBankName(String detalBankName) {
        this.detalBankName = detalBankName;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
