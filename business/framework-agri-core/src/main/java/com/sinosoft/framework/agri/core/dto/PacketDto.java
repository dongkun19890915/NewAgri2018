package com.sinosoft.framework.agri.core.dto;

public class PacketDto<T> {
    private HeadDto head;
    private T body;
    public PacketDto() {
        head = new HeadDto();
    }

    public HeadDto getHead() {
        return head;
    }

    public void setHead(HeadDto head) {
        this.head = head;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
