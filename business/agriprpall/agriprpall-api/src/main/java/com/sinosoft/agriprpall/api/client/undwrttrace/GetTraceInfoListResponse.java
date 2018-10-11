
package com.sinosoft.agriprpall.api.client.undwrttrace;

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
 *         &lt;element name="getTraceInfoListReturn" type="{http://server.webservice.indiv.sinosoft.com}ArrayOf_xsd_anyType"/>
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
    "getTraceInfoListReturn"
})
@XmlRootElement(name = "getTraceInfoListResponse")
public class GetTraceInfoListResponse {

    @XmlElement(required = true)
    protected ArrayOfXsdAnyType getTraceInfoListReturn;

    /**
     * ��ȡgetTraceInfoListReturn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfXsdAnyType }
     *     
     */
    public ArrayOfXsdAnyType getGetTraceInfoListReturn() {
        return getTraceInfoListReturn;
    }

    /**
     * ����getTraceInfoListReturn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfXsdAnyType }
     *     
     */
    public void setGetTraceInfoListReturn(ArrayOfXsdAnyType value) {
        this.getTraceInfoListReturn = value;
    }

}
