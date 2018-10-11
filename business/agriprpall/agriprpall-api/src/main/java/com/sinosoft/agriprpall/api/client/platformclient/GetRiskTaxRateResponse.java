
package com.sinosoft.agriprpall.api.client.platformclient;

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
 *         &lt;element name="getRiskTaxRateReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "getRiskTaxRateReturn"
})
@XmlRootElement(name = "getRiskTaxRateResponse")
public class GetRiskTaxRateResponse {

    @XmlElement(required = true)
    protected String getRiskTaxRateReturn;

    /**
     * ��ȡgetRiskTaxRateReturn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetRiskTaxRateReturn() {
        return getRiskTaxRateReturn;
    }

    /**
     * ����getRiskTaxRateReturn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetRiskTaxRateReturn(String value) {
        this.getRiskTaxRateReturn = value;
    }

}
