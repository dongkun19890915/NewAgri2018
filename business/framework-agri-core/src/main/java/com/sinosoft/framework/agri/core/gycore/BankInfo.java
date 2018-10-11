package com.sinosoft.framework.agri.core.gycore;

import com.sinosoft.framework.core.utils.StringUtils;

/**
 * description:客户银行及基本信息
 *
 * @outhor wq
 * @create 2018-03-13 15:14
 */
public class BankInfo {
    //客户代码
    private String farmCode;

    //证件类型
    private String fidType;

    //证件号码
    private String fidCard;

    //联系手机
    private String fPhone;

    //开户银行大类
    private String bankType;

    //开户银行
    private String bank;

    //银行卡号
    private String bankNo;

    public String getFarmCode() {
        return farmCode;
    }

    public void setFarmCode(String farmCode) {
        this.farmCode = farmCode;
    }

    public String getFidType() {
        return fidType;
    }

    public void setFidType(String fidType) {
        this.fidType = fidType;
    }

    public String getFidCard() {
        return fidCard;
    }

    public void setFidCard(String fidCard) {
        this.fidCard = fidCard;
    }

    public String getfPhone() {
        return fPhone;
    }

    public void setfPhone(String fPhone) {
        this.fPhone = fPhone;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public BankInfo() {
    }

    private BankInfo(Builder builder) {
        this.farmCode = builder.farmCode;
        this.fidType = builder.fidType;
        this.fidCard = builder.fidCard;
        this.fPhone = builder.fPhone;
        this.bankType = builder.bankType;
        this.bank = builder.bank;
        this.bankNo = builder.bankNo;
    }

    public static Builder newBankInfo() {
        return new Builder();
    }


    public static final class Builder {
        private String farmCode;
        private String fidType;
        private String fidCard;
        private String fPhone;
        private String bankType;
        private String bank;
        private String bankNo;

        private Builder() {
        }

        public BankInfo build() {
            return new BankInfo(this);
        }

        public Builder farmCode(String farmCode) {
            if (StringUtils.isEmpty(farmCode)) {
                this.farmCode = "";
            } else {
                this.farmCode = farmCode;
            }
            return this;
        }

        public Builder fidType(String fidType) {
            if (StringUtils.isEmpty(fidType)) {
                this.fidType = "";
            } else {
                this.fidType = fidType;
            }
            return this;
        }

        public Builder fidCard(String fidCard) {
            if (StringUtils.isEmpty(fidCard)) {
                this.fidCard = "";
            } else {
                this.fidCard = fidCard;
            }
            return this;
        }

        public Builder fPhone(String fPhone) {
            if (StringUtils.isEmpty(fPhone)) {
                this.fPhone = "";
            } else {
                this.fPhone = fPhone;
            }
            return this;
        }

        public Builder bankType(String bankType) {
            if (StringUtils.isEmpty(bankType)) {
                this.bankType = "";
            } else {
                this.bankType = bankType;
            }
            return this;
        }

        public Builder bank(String bank) {
            if (StringUtils.isEmpty(bank)) {
                this.bank = "";
            } else {
                this.bank = bank;
            }
            return this;
        }

        public Builder bankNo(String bankNo) {
            if (StringUtils.isEmpty(bankNo)) {
                this.bankNo = "";
            } else {
                this.bankNo = bankNo;
            }
            return this;
        }
    }
}
