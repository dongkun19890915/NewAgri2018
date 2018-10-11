package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;
import java.util.List;

public class RequestNyxEffectiveAmountDto extends BasePageableRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /*有效保额表*/
    private List<NyxEffectiveAmountDto> nyxEffectiveAmountDtoList;

    /*判断批增批减及理赔变化标识*/
    private String judgeFlag;

    public List<NyxEffectiveAmountDto> getNyxEffectiveAmountDtoList() {
        return nyxEffectiveAmountDtoList;
    }

    public void setNyxEffectiveAmountDtoList(List<NyxEffectiveAmountDto> nyxEffectiveAmountDtoList) {
        this.nyxEffectiveAmountDtoList = nyxEffectiveAmountDtoList;
    }

    public String getJudgeFlag() {
        return judgeFlag;
    }

    public void setJudgeFlag(String judgeFlag) {
        this.judgeFlag = judgeFlag;
    }


}
