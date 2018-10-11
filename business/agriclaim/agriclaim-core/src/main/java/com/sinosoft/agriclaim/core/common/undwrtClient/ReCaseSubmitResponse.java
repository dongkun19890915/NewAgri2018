
package com.sinosoft.agriclaim.core.common.undwrtClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="reCaseSubmitReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "reCaseSubmitReturn"
})
@XmlRootElement(name = "reCaseSubmitResponse")
public class ReCaseSubmitResponse {

    @XmlElement(required = true)
    protected String reCaseSubmitReturn;

    /**
     * 获取reCaseSubmitReturn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReCaseSubmitReturn() {
        return reCaseSubmitReturn;
    }

    /**
     * 设置reCaseSubmitReturn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReCaseSubmitReturn(String value) {
        this.reCaseSubmitReturn = value;
    }

}
