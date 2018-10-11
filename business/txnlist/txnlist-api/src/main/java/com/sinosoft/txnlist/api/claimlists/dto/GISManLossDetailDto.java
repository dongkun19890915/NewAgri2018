package com.sinosoft.txnlist.api.claimlists.dto;

/**
 * 理赔损失清单农户标的损失清单信息（种植组合险连带被保险人信息）
 * @author 王心洋
 * @time 2018-01-18
 */
public class GISManLossDetailDto {
    private static final long serialVersionUID = 1L;
    String idType   ;//证件类型
    String idCode   ;//证件号码
    String name     ;//姓名
    String sex      ;//性别
    String relation ;//与农户关系

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
