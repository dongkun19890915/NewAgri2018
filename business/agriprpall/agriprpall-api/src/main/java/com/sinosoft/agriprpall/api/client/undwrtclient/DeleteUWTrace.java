
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
 *         &lt;element name="dbManager" type="{http://reference.sysframework.sinosoft.com}DBManager"/>
 *         &lt;element name="businessNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "dbManager",
    "businessNo"
})
@XmlRootElement(name = "deleteUWTrace")
public class DeleteUWTrace {

    @XmlElement(required = true)
    protected DBManager dbManager;
    @XmlElement(required = true)
    protected String businessNo;

    /**
     * ��ȡdbManager���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DBManager }
     *     
     */
    public DBManager getDbManager() {
        return dbManager;
    }

    /**
     * ����dbManager���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DBManager }
     *     
     */
    public void setDbManager(DBManager value) {
        this.dbManager = value;
    }

    /**
     * ��ȡbusinessNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessNo() {
        return businessNo;
    }

    /**
     * ����businessNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessNo(String value) {
        this.businessNo = value;
    }

}
