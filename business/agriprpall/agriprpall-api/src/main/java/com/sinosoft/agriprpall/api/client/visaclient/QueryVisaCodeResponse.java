
package com.sinosoft.agriprpall.api.client.visaclient;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="queryVisaCodeReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "queryVisaCodeReturn"
})
@XmlRootElement(name = "queryVisaCodeResponse")
public class QueryVisaCodeResponse {

    @XmlElement(required = true)
    protected String queryVisaCodeReturn;

    /**
     * ��ȡqueryVisaCodeReturn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryVisaCodeReturn() {
        return queryVisaCodeReturn;
    }

    /**
     * ����queryVisaCodeReturn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryVisaCodeReturn(String value) {
        this.queryVisaCodeReturn = value;
    }

}
