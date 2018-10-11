package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;


import com.sinosoft.agriprpall.api.endorsemanage.dto.CheckEndorseConditionDto;

public interface CheckEndorseNextService {
    /**
    * 允许批改校验
    * @param policyNo 保单号
    * @return java.lang.String 版本号
    * @throws   Exception
    * @author 李冬松
    * @date 14:01 2017/11/10
    */
    public String checkEndorse(CheckEndorseConditionDto checkEndorseConditionDto)throws Exception;
}
