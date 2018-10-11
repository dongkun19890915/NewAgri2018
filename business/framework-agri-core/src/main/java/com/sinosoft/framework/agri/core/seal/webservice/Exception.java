
package com.sinosoft.framework.agri.core.seal.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;


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
 *         &lt;element name="Exception" type="{http://serv}Exception" minOccurs="0"/>
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
    "exception"
})
@XmlRootElement(name = "Exception")
public class Exception {

    @XmlElementRef(name = "Exception", namespace = "http://serv", type = JAXBElement.class, required = false)
    protected JAXBElement<Exception2> exception;

    /**
     * 获取exception属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Exception2 }{@code >}
     *     
     */
    public JAXBElement<Exception2> getException() {
        return exception;
    }

    /**
     * 设置exception属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Exception2 }{@code >}
     *     
     */
    public void setException(JAXBElement<Exception2> value) {
        this.exception = value;
    }

}
