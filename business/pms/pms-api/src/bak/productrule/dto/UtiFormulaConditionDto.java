/**
 * 
 */
package com.sinosoft.pms.api.productrule.dto;


import com.sinosoft.framework.dto.BaseDto;


/**
 * @description 查询产品公式输入类
 * @author 王志伟
 * @date 2016年9月17日上午10:03:22
 */
public class UtiFormulaConditionDto extends BaseDto implements java.io.Serializable
{

    private static final long serialVersionUID = 1L;

    /**
     * 机构代码
     */
    private String comCode;

    /**
     * 产品代码
     */
    private String riskCode;

    /**
     * 条款代码
     */
    private String clauseCode;

    /**
     * 责任代码
     */
    private String kindCode;

    /**
     * 公式类型
     */
    private String formulaType;

    /**
     * 构造方法
     */
    public UtiFormulaConditionDto()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the comCode
     */
    public String getComCode()
    {
        return comCode;
    }

    /**
     * @param comCode
     *            the comCode to set
     */
    public void setComCode(String comCode)
    {
        this.comCode = comCode;
    }

    /**
     * @return the riskCode
     */
    public String getRiskCode()
    {
        return riskCode;
    }

    /**
     * @param riskCode
     *            the riskCode to set
     */
    public void setRiskCode(String riskCode)
    {
        this.riskCode = riskCode;
    }

    /**
     * @return the clauseCode
     */
    public String getClauseCode()
    {
        return clauseCode;
    }

    /**
     * @param clauseCode
     *            the clauseCode to set
     */
    public void setClauseCode(String clauseCode)
    {
        this.clauseCode = clauseCode;
    }

    /**
     * @return the kindCode
     */
    public String getKindCode()
    {
        return kindCode;
    }

    /**
     * @param kindCode
     *            the kindCode to set
     */
    public void setKindCode(String kindCode)
    {
        this.kindCode = kindCode;
    }

    /**
     * @return the formulaType
     */
    public String getFormulaType()
    {
        return formulaType;
    }

    /**
     * @param formulaType
     *            the formulaType to set
     */
    public void setFormulaType(String formulaType)
    {
        this.formulaType = formulaType;
    }

}
