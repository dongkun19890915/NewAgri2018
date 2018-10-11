
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
 *         &lt;element name="QueryAndDeleteExchangeInfoReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "queryAndDeleteExchangeInfoReturn"
})
@XmlRootElement(name = "QueryAndDeleteExchangeInfoResponse")
public class QueryAndDeleteExchangeInfoResponse {

    @XmlElement(name = "QueryAndDeleteExchangeInfoReturn", required = true)
    protected String queryAndDeleteExchangeInfoReturn;

    /**
     * ��ȡqueryAndDeleteExchangeInfoReturn���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getQueryAndDeleteExchangeInfoReturn() {
        return queryAndDeleteExchangeInfoReturn;
    }

    /**
     * ����queryAndDeleteExchangeInfoReturn���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setQueryAndDeleteExchangeInfoReturn(String value) {
        this.queryAndDeleteExchangeInfoReturn = value;
    }

}
