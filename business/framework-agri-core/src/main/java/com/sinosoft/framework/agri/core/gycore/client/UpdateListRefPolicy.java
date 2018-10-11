
package com.sinosoft.framework.agri.core.gycore.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="insuranceListCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="insurancePolicyNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="policyNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="batchPolicyNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "insuranceListCode",
    "insurancePolicyNo",
    "policyNo",
    "batchPolicyNo",
    "listCode"
})
@XmlRootElement(name = "updateListRefPolicy")
public class UpdateListRefPolicy {

    protected String insuranceListCode;
    protected String insurancePolicyNo;
    protected String policyNo;
    protected String batchPolicyNo;
    protected String listCode;

    /**
     * 获取insuranceListCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsuranceListCode() {
        return insuranceListCode;
    }

    /**
     * 设置insuranceListCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsuranceListCode(String value) {
        this.insuranceListCode = value;
    }

    /**
     * 获取insurancePolicyNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsurancePolicyNo() {
        return insurancePolicyNo;
    }

    /**
     * 设置insurancePolicyNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsurancePolicyNo(String value) {
        this.insurancePolicyNo = value;
    }

    /**
     * 获取policyNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyNo() {
        return policyNo;
    }

    /**
     * 设置policyNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyNo(String value) {
        this.policyNo = value;
    }

    /**
     * 获取batchPolicyNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchPolicyNo() {
        return batchPolicyNo;
    }

    /**
     * 设置batchPolicyNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchPolicyNo(String value) {
        this.batchPolicyNo = value;
    }

    /**
     * 获取listCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListCode() {
        return listCode;
    }

    /**
     * 设置listCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListCode(String value) {
        this.listCode = value;
    }

}
