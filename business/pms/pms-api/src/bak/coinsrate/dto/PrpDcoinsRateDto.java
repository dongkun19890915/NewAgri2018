package com.sinosoft.pms.api.coinsrate.dto;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @description 查询共保比例时传入参数时使用
 * @author yinqingzhu
 * @date 2016年9月28日下午9:40:46
 */
public class PrpDcoinsRateDto implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;
    //共保体公司代码
    String comCode;
    //产品代码
    String riskCode;
    //版次号
    String versionNo;
    //页面传入的日期
    Date issueDate;

    /** 属性RiskName/产品名称 */
    private String riskName;

    /** 属性ComCName/成员公司名称 */
    private String comCName;

    /** 属性EffectDate/生效日期 */
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date effectDate;

    /** 属性InvalidDate/失效日期 */
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date invalidDate;

    /** 属性CoinsRate/共保比例 */
    private Double coinsRate;

    /** 属性Flag/标志 */
    private String flag;

    /** 属性Remark/备注 */
    private String remark;

    /** 属性CreateTime/创建时间 */
    private Date createTime;

    /** 属性CreateBy/创建人 */
    private String createBy;

    /** 属性UpdateTime/更新时间 */
    private Date updateTime;

    /** 属性UpdateBy/更新人 */
    private String updateBy;

    public String getRiskName()
    {
        return riskName;
    }

    public void setRiskName(String riskName)
    {
        this.riskName = riskName;
    }

    public String getComCName()
    {
        return comCName;
    }

    public void setComCName(String comCName)
    {
        this.comCName = comCName;
    }

    public Date getEffectDate()
    {
        return effectDate;
    }

    public void setEffectDate(Date effectDate)
    {
        this.effectDate = effectDate;
    }

    public Date getInvalidDate()
    {
        return invalidDate;
    }

    public void setInvalidDate(Date invalidDate)
    {
        this.invalidDate = invalidDate;
    }

    public Double getCoinsRate()
    {
        return coinsRate;
    }

    public void setCoinsRate(Double coinsRate)
    {
        this.coinsRate = coinsRate;
    }

    public String getFlag()
    {
        return flag;
    }

    public void setFlag(String flag)
    {
        this.flag = flag;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getCreateBy()
    {
        return createBy;
    }

    public void setCreateBy(String createBy)
    {
        this.createBy = createBy;
    }

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

    public String getUpdateBy()
    {
        return updateBy;
    }

    public void setUpdateBy(String updateBy)
    {
        this.updateBy = updateBy;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    public String getComCode()
    {
        return comCode;
    }

    public void setComCode(String comCode)
    {
        this.comCode = comCode;
    }

    public String getRiskCode()
    {
        return riskCode;
    }

    public void setRiskCode(String riskCode)
    {
        this.riskCode = riskCode;
    }

    public String getVersionNo()
    {
        return versionNo;
    }

    public void setVersionNo(String versionNo)
    {
        this.versionNo = versionNo;
    }

    public Date getIssueDate()
    {
        return issueDate;
    }

    public void setIssueDate(Date issueDate)
    {
        this.issueDate = issueDate;
    }
    
}
