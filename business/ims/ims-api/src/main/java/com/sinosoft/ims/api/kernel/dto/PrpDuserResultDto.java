package com.sinosoft.ims.api.kernel.dto;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-03-16 09:59
 */
public class PrpDuserResultDto {
    private String msg;
    private  PrpDuserDto prpDuserDto;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public PrpDuserDto getPrpDuserDto() {
        return prpDuserDto;
    }

    public void setPrpDuserDto(PrpDuserDto prpDuserDto) {
        this.prpDuserDto = prpDuserDto;
    }
}
