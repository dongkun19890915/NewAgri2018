
package com.sinosoft.agriprpall.api.client.paymentclient;

import javax.xml.bind.annotation.*;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * <p>
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestXML" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "requestXML"
})
@XmlRootElement(name = "queryRelateRepolicyno")
public class QueryRelateRepolicyno {

    @XmlElement(required = true)
    protected String requestXML;

    /**
     * ��ȡrequestXML���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getRequestXML() {
        return requestXML;
    }

    /**
     * ����requestXML���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRequestXML(String value) {
        this.requestXML = value;
    }

}
