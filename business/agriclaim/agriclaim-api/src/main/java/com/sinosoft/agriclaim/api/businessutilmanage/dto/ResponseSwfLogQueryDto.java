package com.sinosoft.agriclaim.api.businessutilmanage.dto;

import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfPathLogDto;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;
/**
 *响应给页面的数据-流程查询页面
 * @Author: 孙朋飞
 * @Date: 2017/12/19 20:26
 */
public class ResponseSwfLogQueryDto extends BaseRequest implements Serializable{
    private String insuredName;//被保险人
    private String payReffee;//已支付赔款总额
    private String payRefdate;//最后支付日期
    private String compensateNo;//理算书号

    private String flowStatusName;//该流程的状态中文
    private String isSpecialCase;//是否特殊赔案
    private String creatDateName;//创建时间名称
    private String closeDateName;//关闭时间名称

    private List<SwfLogDto> swfLogDtoTreeList;
    private Integer countNum;//日志表的条数
    private List<SwfPathLogDto> swfPathLogList;

    public List<SwfLogDto> getSwfLogDtoTreeList() {
        return swfLogDtoTreeList;
    }

    public void setSwfLogDtoTreeList(List<SwfLogDto> swfLogDtoTreeList) {
        this.swfLogDtoTreeList = swfLogDtoTreeList;
    }

    public List<SwfPathLogDto> getSwfPathLogList() {
        return swfPathLogList;
    }

    public void setSwfPathLogList(List<SwfPathLogDto> swfPathLogList) {
        this.swfPathLogList = swfPathLogList;
    }

    public String getPayReffee() {
        return payReffee;
    }

    public void setPayReffee(String payReffee) {
        this.payReffee = payReffee;
    }

    public String getPayRefdate() {
        return payRefdate;
    }

    public void setPayRefdate(String payRefdate) {
        this.payRefdate = payRefdate;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getFlowStatusName() {
        return flowStatusName;
    }

    public void setFlowStatusName(String flowStatusName) {
        this.flowStatusName = flowStatusName;
    }

    public String getIsSpecialCase() {
        return isSpecialCase;
    }

    public void setIsSpecialCase(String isSpecialCase) {
        this.isSpecialCase = isSpecialCase;
    }

    public String getCreatDateName() {
        return creatDateName;
    }

    public void setCreatDateName(String creatDateName) {
        this.creatDateName = creatDateName;
    }

    public String getCloseDateName() {
        return closeDateName;
    }

    public void setCloseDateName(String closeDateName) {
        this.closeDateName = closeDateName;
    }

    public Integer getCountNum() {
        return countNum;
    }

    public void setCountNum(Integer countNum) {
        this.countNum = countNum;
    }

    public String getCompensateNo() {
        return compensateNo;
    }

    public void setCompensateNo(String compensateNo) {
        this.compensateNo = compensateNo;
    }
}
