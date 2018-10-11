package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntity;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time 2016-09-23 17:19:21.110
 * 岗位表-Saa_Grade   基础数据对象
 */

@Entity
@Table(name = "Saa_Grade")
@IdClass(SaaGradeKey.class)
public class SaaGrade implements BaseEntity, java.io.Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性岗位代码/
     */
    private String gradeCode;
    /**
     * 属性岗位简体中文名称/
     */
    private String gradeCName;
    /**
     * 属性岗位繁体中文名称/
     */
    private String gradeTName;
    /**
     * 属性岗位英文名称/
     */
    private String gradeEName;
    /**
     * 属性岗位模板ID/
     */
    private String gradeTemplID;
    /**
     * 属性有效标志/
     */
    private String validStatus;
    /**
     * 属性标志字段/
     */
    private String flag;
    /**
     * 属性信息创建日期/
     */
    private java.util.Date createDate;
    /**
     * 属性信息创建人员/
     */
    private String creatorCode;
    /**
     * 属性最新更新操作日期/
     */
    private java.util.Date updateDate;
    /**
     * 属性最新更新操作人员/
     */
    private String updaterCode;
    /** 属性ID/ */
    @Id
    @Column(name = "id")
    private String iD ;
    /**
     * 属性ID/的getter方法
     */
    public String getID() {
        return iD;
    }
    /**
     * 属性ID/的setter方法
     */
    public void setID(String iD) {
        this.iD = iD;
    }

    /**
     * 属性岗位代码/的getter方法
     */
    public String getGradeCode() {
        return gradeCode;
    }

    /**
     * 属性岗位代码/的setter方法
     */
    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    /**
     * 属性岗位简体中文名称/的getter方法
     */
    public String getGradeCName() {
        return gradeCName;
    }

    /**
     * 属性岗位简体中文名称/的setter方法
     */
    public void setGradeCName(String gradeCName) {
        this.gradeCName = gradeCName;
    }

    /**
     * 属性岗位繁体中文名称/的getter方法
     */
    public String getGradeTName() {
        return gradeTName;
    }

    /**
     * 属性岗位繁体中文名称/的setter方法
     */
    public void setGradeTName(String gradeTName) {
        this.gradeTName = gradeTName;
    }

    /**
     * 属性岗位英文名称/的getter方法
     */
    public String getGradeEName() {
        return gradeEName;
    }

    /**
     * 属性岗位英文名称/的setter方法
     */
    public void setGradeEName(String gradeEName) {
        this.gradeEName = gradeEName;
    }

    /**
     * 属性岗位模板ID/的getter方法
     */
    public String getGradeTemplID() {
        return gradeTemplID;
    }

    /**
     * 属性岗位模板ID/的setter方法
     */
    public void setGradeTemplID(String gradeTemplID) {
        this.gradeTemplID = gradeTemplID;
    }

    /**
     * 属性有效标志/的getter方法
     */
    public String getValidStatus() {
        return validStatus;
    }

    /**
     * 属性有效标志/的setter方法
     */
    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus;
    }

    /**
     * 属性标志字段/的getter方法
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 属性标志字段/的setter方法
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * 属性信息创建日期/的getter方法
     */
    public java.util.Date getCreateDate() {
        return createDate;
    }

    /**
     * 属性信息创建日期/的setter方法
     */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 属性信息创建人员/的getter方法
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     * 属性信息创建人员/的setter方法
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    }

    /**
     * 属性最新更新操作日期/的getter方法
     */
    public java.util.Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 属性最新更新操作日期/的setter方法
     */
    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 属性最新更新操作人员/的getter方法
     */
    public String getUpdaterCode() {
        return updaterCode;
    }

    /**
     * 属性最新更新操作人员/的setter方法
     */
    public void setUpdaterCode(String updaterCode) {
        this.updaterCode = updaterCode;
    }
}