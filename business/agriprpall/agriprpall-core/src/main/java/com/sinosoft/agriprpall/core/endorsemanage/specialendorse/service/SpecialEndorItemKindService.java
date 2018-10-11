package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service;
import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.EndorseConditionDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCsubsidyDto;
import com.sinosoft.pms.api.kernel.dto.PrpDshortRateDto;


import java.util.List;


/**
 * @Description: 特殊批改处理类--单位保额批改
 * @Author: 王心洋
 * @Date: 2017/12/12
 */
public interface SpecialEndorItemKindService {
    /**
     * 变更保险期限批改方法
     * @author 王心洋
     * @time 2017-12-12
     * @param blEndorseDto 批单大对象集合
     * @param endorseConditionDto 批单条件
     * @return List<EndorsePolicyDto> 新旧保单对象、批单对象
     * @throws Exception
     */
    public PolicyEndorseDto specialEndorse01(BLEndorseDto blEndorseDto, EndorseConditionDto endorseConditionDto,
                                             List<PrpCsubsidyDto> prpCsubsidyDtoList, List<PrpCitemKindDto> prpCitemKindDtoList) throws Exception;

    public PrpDshortRateDto queryPrpDshortRateDto(String strRiskCode, Integer intMonth) throws Exception;
}
