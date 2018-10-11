
package com.sinosoft.agriprpall.api.client.changepassword;

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
 *         &lt;element name="updatePassWordReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "updatePassWordReturn"
})
@XmlRootElement(name = "updatePassWordResponse")
public class UpdatePassWordResponse {

    @XmlElement(required = true)
    protected String updatePassWordReturn;

    /**
     * ��ȡupdatePassWordReturn���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getUpdatePassWordReturn() {
        return updatePassWordReturn;
    }

    /**
     * ����updatePassWordReturn���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUpdatePassWordReturn(String value) {
        this.updatePassWordReturn = value;
    }

}
