
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
 *         &lt;element name="claimPaySubmitReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "claimPaySubmitReturn"
})
@XmlRootElement(name = "claimPaySubmitResponse")
public class ClaimPaySubmitResponse {

    @XmlElement(required = true)
    protected String claimPaySubmitReturn;

    /**
     * 获取claimPaySubmitReturn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaimPaySubmitReturn() {
        return claimPaySubmitReturn;
    }

    /**
     * 设置claimPaySubmitReturn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaimPaySubmitReturn(String value) {
        this.claimPaySubmitReturn = value;
    }

}
