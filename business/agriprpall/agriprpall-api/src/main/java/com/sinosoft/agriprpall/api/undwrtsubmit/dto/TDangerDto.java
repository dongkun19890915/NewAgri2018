package com.sinosoft.agriprpall.api.undwrtsubmit.dto;

import java.io.Serializable;
import java.util.Collection;

/**
 * @description:
 * @author: 钱浩
 * @date: 2017/10/18 14:43
 * 自定义帐单Dto对象
 * <p>Title: ZBWEB</p>
 * <p>Description: 再保系统样本程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author liuyang
 * @version 1.0
 */


public class TDangerDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private PrpTdangerUnitDto PrpTdangerUnitDto       = null;
    private Collection PrpTdangerItemDtoList  = null;
    private Collection PrpTdangerTotDtoList   = null;
    private Collection PrpTdangerPlanDtoList  = null;
    private Collection PrpTdangerCoinsDtoList = null;
    private Collection PrpTdangerRiskDtoList  = null;

    public com.sinosoft.agriprpall.api.undwrtsubmit.dto.PrpTdangerUnitDto getPrpTdangerUnitDto() {
        return PrpTdangerUnitDto;
    }

    public void setPrpTdangerUnitDto(com.sinosoft.agriprpall.api.undwrtsubmit.dto.PrpTdangerUnitDto prpTdangerUnitDto) {
        PrpTdangerUnitDto = prpTdangerUnitDto;
    }

    public Collection getPrpTdangerItemDtoList() {
        return PrpTdangerItemDtoList;
    }

    public void setPrpTdangerItemDtoList(Collection prpTdangerItemDtoList) {
        PrpTdangerItemDtoList = prpTdangerItemDtoList;
    }

    public Collection getPrpTdangerTotDtoList() {
        return PrpTdangerTotDtoList;
    }

    public void setPrpTdangerTotDtoList(Collection prpTdangerTotDtoList) {
        PrpTdangerTotDtoList = prpTdangerTotDtoList;
    }

    public Collection getPrpTdangerPlanDtoList() {
        return PrpTdangerPlanDtoList;
    }

    public void setPrpTdangerPlanDtoList(Collection prpTdangerPlanDtoList) {
        PrpTdangerPlanDtoList = prpTdangerPlanDtoList;
    }

    public Collection getPrpTdangerCoinsDtoList() {
        return PrpTdangerCoinsDtoList;
    }

    public void setPrpTdangerCoinsDtoList(Collection prpTdangerCoinsDtoList) {
        PrpTdangerCoinsDtoList = prpTdangerCoinsDtoList;
    }

    public Collection getPrpTdangerRiskDtoList() {
        return PrpTdangerRiskDtoList;
    }

    public void setPrpTdangerRiskDtoList(Collection prpTdangerRiskDtoList) {
        PrpTdangerRiskDtoList = prpTdangerRiskDtoList;
    }
}
