
package com.sinosoft.agriprpall.api.client.undwrtclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DBManager complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DBManager">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DSName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bytes" type="{http://www.w3.org/2001/XMLSchema}base64Binary" maxOccurs="unbounded"/>
 *         &lt;element name="connection" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="dateTime" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded"/>
 *         &lt;element name="double" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded"/>
 *         &lt;element name="int" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded"/>
 *         &lt;element name="long" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded"/>
 *         &lt;element name="resultSetConcurrency" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="resultSetType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="statement" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="string" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="useTrim" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DBManager", namespace = "http://reference.sysframework.sinosoft.com", propOrder = {
    "dsName",
    "bytes",
    "connection",
    "dateTime",
    "_double",
    "_int",
    "_long",
    "resultSetConcurrency",
    "resultSetType",
    "statement",
    "string",
    "useTrim"
})
public class DBManager {

    @XmlElement(name = "DSName", required = true, nillable = true)
    protected String dsName;
    @XmlElement(required = true, nillable = true)
    protected List<byte[]> bytes;
    @XmlElement(required = true, nillable = true)
    protected Object connection;
    @XmlElement(required = true, nillable = true)
    protected List<Object> dateTime;
    @XmlElement(name = "double", type = Double.class)
    protected List<Double> _double;
    @XmlElement(name = "int", type = Integer.class)
    protected List<Integer> _int;
    @XmlElement(name = "long", type = Long.class)
    protected List<Long> _long;
    protected int resultSetConcurrency;
    protected int resultSetType;
    @XmlElement(required = true, nillable = true)
    protected Object statement;
    @XmlElement(required = true, nillable = true)
    protected List<String> string;
    protected boolean useTrim;

    /**
     * ��ȡdsName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDSName() {
        return dsName;
    }

    /**
     * ����dsName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDSName(String value) {
        this.dsName = value;
    }

    /**
     * Gets the value of the bytes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bytes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBytes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * byte[]
     * 
     */
    public List<byte[]> getBytes() {
        if (bytes == null) {
            bytes = new ArrayList<byte[]>();
        }
        return this.bytes;
    }

    /**
     * ��ȡconnection���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getConnection() {
        return connection;
    }

    /**
     * ����connection���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setConnection(Object value) {
        this.connection = value;
    }

    /**
     * Gets the value of the dateTime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dateTime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDateTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getDateTime() {
        if (dateTime == null) {
            dateTime = new ArrayList<Object>();
        }
        return this.dateTime;
    }

    /**
     * Gets the value of the double property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the double property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDouble().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getDouble() {
        if (_double == null) {
            _double = new ArrayList<Double>();
        }
        return this._double;
    }

    /**
     * Gets the value of the int property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the int property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getInt() {
        if (_int == null) {
            _int = new ArrayList<Integer>();
        }
        return this._int;
    }

    /**
     * Gets the value of the long property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the long property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLong().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getLong() {
        if (_long == null) {
            _long = new ArrayList<Long>();
        }
        return this._long;
    }

    /**
     * ��ȡresultSetConcurrency���Ե�ֵ��
     * 
     */
    public int getResultSetConcurrency() {
        return resultSetConcurrency;
    }

    /**
     * ����resultSetConcurrency���Ե�ֵ��
     * 
     */
    public void setResultSetConcurrency(int value) {
        this.resultSetConcurrency = value;
    }

    /**
     * ��ȡresultSetType���Ե�ֵ��
     * 
     */
    public int getResultSetType() {
        return resultSetType;
    }

    /**
     * ����resultSetType���Ե�ֵ��
     * 
     */
    public void setResultSetType(int value) {
        this.resultSetType = value;
    }

    /**
     * ��ȡstatement���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getStatement() {
        return statement;
    }

    /**
     * ����statement���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setStatement(Object value) {
        this.statement = value;
    }

    /**
     * Gets the value of the string property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the string property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getString().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getString() {
        if (string == null) {
            string = new ArrayList<String>();
        }
        return this.string;
    }

    /**
     * ��ȡuseTrim���Ե�ֵ��
     * 
     */
    public boolean isUseTrim() {
        return useTrim;
    }

    /**
     * ����useTrim���Ե�ֵ��
     * 
     */
    public void setUseTrim(boolean value) {
        this.useTrim = value;
    }

}
