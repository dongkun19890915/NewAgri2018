
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
 *         &lt;element name="queryVisaCodesAndVisaSerialNosReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "queryVisaCodesAndVisaSerialNosReturn"
})
@XmlRootElement(name = "queryVisaCodesAndVisaSerialNosResponse")
public class QueryVisaCodesAndVisaSerialNosResponse {

    @XmlElement(required = true)
    protected String queryVisaCodesAndVisaSerialNosReturn;

    /**
     * ��ȡqueryVisaCodesAndVisaSerialNosReturn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryVisaCodesAndVisaSerialNosReturn() {
        return queryVisaCodesAndVisaSerialNosReturn;
    }

    /**
     * ����queryVisaCodesAndVisaSerialNosReturn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryVisaCodesAndVisaSerialNosReturn(String value) {
        this.queryVisaCodesAndVisaSerialNosReturn = value;
    }

}
