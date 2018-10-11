package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.EndorseConditionDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;

public interface SpecialEndorse19Service {
    /**
     * 保单注销
     * @param blEndorseDto 批单大对象
     * @param endorseConditionDto 批改条件
     * @return PolicyEndorseDto 新旧保单、批单大对象
     * @throws Exception
     * @author 王保良
     * @time 2017-12-22
     */
    public PolicyEndorseDto specialEndorse19(BLEndorseDto blEndorseDto, EndorseConditionDto endorseConditionDto)throws Exception;
}
