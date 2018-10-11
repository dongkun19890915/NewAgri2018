
package com.sinosoft.agriclaim.core.common.undwrtClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>UserException complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="UserException">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errorCatalog" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="errorModule" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="errorNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserException", namespace = "http://error.utility.sinosoft.com", propOrder = {
    "errorCatalog",
    "errorMessage",
    "errorModule",
    "errorNo"
})
public class UserException {

    protected int errorCatalog;
    @XmlElement(required = true, nillable = true)
    protected String errorMessage;
    @XmlElement(required = true, nillable = true)
    protected String errorModule;
    protected int errorNo;

    /**
     * 获取errorCatalog属性的值。
     * 
     */
    public int getErrorCatalog() {
        return errorCatalog;
    }

    /**
     * 设置errorCatalog属性的值。
     * 
     */
    public void setErrorCatalog(int value) {
        this.errorCatalog = value;
    }

    /**
     * 获取errorMessage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * 设置errorMessage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * 获取errorModule属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorModule() {
        return errorModule;
    }

    /**
     * 设置errorModule属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorModule(String value) {
        this.errorModule = value;
    }

    /**
     * 获取errorNo属性的值。
     * 
     */
    public int getErrorNo() {
        return errorNo;
    }

    /**
     * 设置errorNo属性的值。
     * 
     */
    public void setErrorNo(int value) {
        this.errorNo = value;
    }

}
