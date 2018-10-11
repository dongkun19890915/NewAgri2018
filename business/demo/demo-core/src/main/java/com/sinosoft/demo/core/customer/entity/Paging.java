package com.sinosoft.demo.core.customer.entity;

import java.util.List;

public class Paging<T> {
    private Integer total;
    private List<T> content;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
