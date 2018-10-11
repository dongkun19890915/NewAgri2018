package com.sinosoft.txnlist.api.makeuplist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 潘峰
 * @date 24/01/2018 9:31 AM
 */
public class CodeKeyDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fCode;

    private String itemCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CodeKeyDto that = (CodeKeyDto) o;
        return Objects.equals(fCode, that.fCode) &&
                Objects.equals(itemCode, that.itemCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fCode, itemCode);
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public CodeKeyDto() {
    }

    public CodeKeyDto(String fCode, String itemCode) {
        this.fCode = fCode;
        this.itemCode = itemCode;
    }
}
