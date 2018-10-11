package com.sinosoft.agriclaim.api.paymentmanage.dto;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:43:17.258
 * 支付处理意见表dto操作对象
 */
public class PrpLPayExtDto extends BaseEntityImpl {
    private static final long serialVersionUID = 1L;
    /** 属性收付编号/收付编号 */
    private String paymentNo;
    /** 属性序号/序号 */
    private int serialNo;
    /** 属性处理时间/处理时间 */
    private Date inputDate;
    /** 属性处理人代码/处理人代码 */
    private String operatorCode;
    /** 属性意见内容/意见内容 */
    private String context;
    /** 属性处理机构/处理机构 */
    private String comCode;
    /** 属性处理节点/处理节点 */
    private String nodeType;
    /** 属性处理节点名称/处理节点名称 */
    private String nodeName;
    /** 属性处理意见代码/处理意见代码 */
    private String notionCode;
    /** 属性处理意见名字/处理意见名字 */
    private String notionName;
    /** 属性暂存标志/暂存标志 */
    private String flag;

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNotionCode() {
        return notionCode;
    }

    public void setNotionCode(String notionCode) {
        this.notionCode = notionCode;
    }

    public String getNotionName() {
        return notionName;
    }

    public void setNotionName(String notionName) {
        this.notionName = notionName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
