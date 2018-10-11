package com.sinosoft.agriclaim.api.paymentmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/***（暂存任务查询页面的处理意见栏dto）
* @Author: 王志文
* @Date: 2017/12/26 17:40
*/
public class PayPurposeDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 清单号 */
    private String billNo;
    /** 支付编号 */
    private String paymentNo;
    /** 处理节点 */
    private String nodeName;
    /** 流出时间 */
    private String outputTime;
    /** 占用时间 */
    private String occupyTime;
    /** 操作人员 */
    private String operatorName;
    /** 处理机构 */
    private String comName;
    /** 处理意见 */
    private String notionName;
    /** 补充说明 */
    private String context;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getOutputTime() {
        return outputTime;
    }

    public void setOutputTime(String outputTime) {
        this.outputTime = outputTime;
    }

    public String getOccupyTime() {
        return occupyTime;
    }

    public void setOccupyTime(String occupyTime) {
        this.occupyTime = occupyTime;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getNotionName() {
        return notionName;
    }

    public void setNotionName(String notionName) {
        this.notionName = notionName;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
