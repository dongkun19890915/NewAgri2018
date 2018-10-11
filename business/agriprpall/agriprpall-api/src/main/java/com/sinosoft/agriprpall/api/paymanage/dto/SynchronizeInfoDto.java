package com.sinosoft.agriprpall.api.paymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * 同步账户信息返回数据的Dto
 *
 * @Author: 何伟东
 * @Date: 2018/1/16 18:04
 */
public class SynchronizeInfoDto extends BaseRequest implements Serializable {
    /**
     * 账户属性（个人，单位）
     */
    private String insuredType;
    /**
     * 开户银行
     */
    private String bank;
    /**
     * 银行账号
     */
    private String account;

    public String getInsuredType() {
        return insuredType;
    }

    public void setInsuredType(String insuredType) {
        this.insuredType = insuredType;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
