package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.EndorseConditionDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.RequestSpecialEndorseDto;

import java.util.List;

public interface SpecialEndorseService {
    /**
     * 特殊批改批量处理总接口
     * @param blEndorseDtoList 批单对象集合
     * @param endorseConditionDto 批改条件
     * @return List<PolicyEndorseDto>新旧保单、批单大对象集合
     * @throws Exception
     * @author 王心洋
     * @time 2017-12-22
     */
    public List<PolicyEndorseDto> specialEndorse(RequestSpecialEndorseDto requestSpecialEndorseDto)throws Exception;
}
