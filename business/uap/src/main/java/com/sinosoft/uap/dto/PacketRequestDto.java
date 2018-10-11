package com.sinosoft.uap.dto;



public class PacketRequestDto<T> {

    private HeadRequestDto head;
    private T body;
    public PacketRequestDto() {
        head = new HeadRequestDto();
    }

    public HeadRequestDto getHead() {
        return head;
    }

    public void setHead(HeadRequestDto head) {
        this.head = head;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }


}
