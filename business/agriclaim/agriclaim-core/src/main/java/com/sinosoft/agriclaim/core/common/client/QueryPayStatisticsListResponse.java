
package com.sinosoft.agriclaim.core.common.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="queryPayStatisticsListReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "queryPayStatisticsListReturn"
})
@XmlRootElement(name = "queryPayStatisticsListResponse")
public class QueryPayStatisticsListResponse {

    @XmlElement(required = true)
    protected String queryPayStatisticsListReturn;

    /**
     * 获取queryPayStatisticsListReturn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryPayStatisticsListReturn() {
        return queryPayStatisticsListReturn;
    }

    /**
     * 设置queryPayStatisticsListReturn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryPayStatisticsListReturn(String value) {
        this.queryPayStatisticsListReturn = value;
    }

}
