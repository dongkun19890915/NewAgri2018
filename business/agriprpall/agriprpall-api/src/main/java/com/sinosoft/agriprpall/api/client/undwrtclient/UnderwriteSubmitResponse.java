
package com.sinosoft.agriprpall.api.client.undwrtclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="underwriteSubmitReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "underwriteSubmitReturn"
})
@XmlRootElement(name = "underwriteSubmitResponse")
public class UnderwriteSubmitResponse {

    @XmlElement(required = true)
    protected String underwriteSubmitReturn;

    /**
     * ��ȡunderwriteSubmitReturn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnderwriteSubmitReturn() {
        return underwriteSubmitReturn;
    }

    /**
     * ����underwriteSubmitReturn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnderwriteSubmitReturn(String value) {
        this.underwriteSubmitReturn = value;
    }

}
