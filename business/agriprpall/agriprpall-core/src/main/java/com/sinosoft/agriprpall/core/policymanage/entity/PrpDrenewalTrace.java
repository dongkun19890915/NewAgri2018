package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PrpDrenewalTrace")
@IdClass(PrpDrenewalTraceKey.class)
public class PrpDrenewalTrace extends BaseEntityImpl {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "policyNo")
    private String policyNo;

    @Column(name = "oldPolicyNo")
    private String oldPolicyNo;

    @Column(name = "renewalDate")
    private Date renewalDate;

    @Column(name = "flag")
    private String flag;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getOldPolicyNo() {
        return oldPolicyNo;
    }

    public void setOldPolicyNo(String oldPolicyNo) {
        this.oldPolicyNo = oldPolicyNo;
    }

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
