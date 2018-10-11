package com.sinosoft.notice.core.model.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author 潘峰
 * @date 2017/11/22 上午10:06
 */
public class SmsContentKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    private String id;

    public SmsContentKey(String id) {
        this.id = id;
    }

    public SmsContentKey() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
