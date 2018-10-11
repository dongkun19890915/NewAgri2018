
package com.sinosoft.agriprpall.api.client.visaclient;

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
 *         &lt;element name="trashTransReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "trashTransReturn"
})
@XmlRootElement(name = "trashTransResponse")
public class TrashTransResponse {

    @XmlElement(required = true)
    protected String trashTransReturn;

    /**
     * ��ȡtrashTransReturn���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getTrashTransReturn() {
        return trashTransReturn;
    }

    /**
     * ����trashTransReturn���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTrashTransReturn(String value) {
        this.trashTransReturn = value;
    }

}
