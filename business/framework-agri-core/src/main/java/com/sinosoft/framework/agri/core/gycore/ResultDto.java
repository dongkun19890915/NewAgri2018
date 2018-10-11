package com.sinosoft.framework.agri.core.gycore;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-04-02 16:11
 */
public class ResultDto {
    private boolean sucess;
    private String msg;

    public ResultDto() {
    }

    public ResultDto(boolean sucess, String msg) {
        this.sucess = sucess;
        this.msg = msg;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
