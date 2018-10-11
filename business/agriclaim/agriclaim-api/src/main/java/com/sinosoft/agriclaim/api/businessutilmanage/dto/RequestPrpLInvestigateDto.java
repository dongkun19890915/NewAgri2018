package com.sinosoft.agriclaim.api.businessutilmanage.dto;

import java.io.Serializable;

/**
 * 接受流程查询的数据
 * @Author: 孙朋飞
 * @Date: 2018/3/7 10:49
 */
public class RequestPrpLInvestigateDto implements Serializable{
    /** 报案号*/
    private String registNo;
    /** 节点状态*/
    private String nodeStatus;
    /** 处理人代码*/
    private String handlerCode;
    /** 处理人名称*/
    private String handlerName;
    /** 用户机构代码*/
    private String userComCode;
    /** 用户机构名称*/
    private String userComCname;

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getUserComCode() {
        return userComCode;
    }

    public void setUserComCode(String userComCode) {
        this.userComCode = userComCode;
    }

    public String getUserComCname() {
        return userComCname;
    }

    public void setUserComCname(String userComCname) {
        this.userComCname = userComCname;
    }

    public String getNodeStatus() {
        return nodeStatus;
    }

    public void setNodeStatus(String nodeStatus) {
        this.nodeStatus = nodeStatus;
    }
}
