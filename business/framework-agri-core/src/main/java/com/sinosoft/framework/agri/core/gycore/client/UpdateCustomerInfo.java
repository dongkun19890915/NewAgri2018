
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
 *         &lt;element name="customerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerinfoXML" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "customerCode",
    "customerType",
    "customerinfoXML"
})
@XmlRootElement(name = "updateCustomerInfo")
public class UpdateCustomerInfo {

    protected String customerCode;
    protected String customerType;
    protected String customerinfoXML;

    /**
     * 获取customerCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * 设置customerCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerCode(String value) {
        this.customerCode = value;
    }

    /**
     * 获取customerType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * 设置customerType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerType(String value) {
        this.customerType = value;
    }

    /**
     * 获取customerinfoXML属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerinfoXML() {
        return customerinfoXML;
    }

    /**
     * 设置customerinfoXML属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerinfoXML(String value) {
        this.customerinfoXML = value;
    }

}
