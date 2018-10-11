
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
 *         &lt;element name="readyRegistInfoXML" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "readyRegistInfoXML"
})
@XmlRootElement(name = "addReadyRegistInfo")
public class AddReadyRegistInfo {

    protected String readyRegistInfoXML;

    /**
     * 获取readyRegistInfoXML属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReadyRegistInfoXML() {
        return readyRegistInfoXML;
    }

    /**
     * 设置readyRegistInfoXML属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReadyRegistInfoXML(String value) {
        this.readyRegistInfoXML = value;
    }

}
