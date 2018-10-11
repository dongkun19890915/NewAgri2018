package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.EndorseConditionDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;

import java.util.List;

public interface SpecialEndorse21Service {
    /**
     * 全单退保
     * @param blEndorseDto 批单大对象
     * @param endorseConditionDto 批改条件
     * @return PolicyEndorseDto 新旧保单、批单大对象
     * @throws Exception
     * @author 王保良
     * @time 2017-12-20
     */
    public PolicyEndorseDto specialEndorse21(BLEndorseDto blEndorseDto, EndorseConditionDto endorseConditionDto) throws Exception ;
    }
