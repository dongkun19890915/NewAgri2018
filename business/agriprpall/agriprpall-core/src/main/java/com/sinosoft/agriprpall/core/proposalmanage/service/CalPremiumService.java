package com.sinosoft.agriprpall.core.proposalmanage.service;

import com.sinosoft.agriprpall.api.proposalmanage.dto.CalPremiumDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.CalPremiumResponseDto;
import com.sinosoft.framework.dto.ResponseDto;

import java.util.List;

public interface CalPremiumService {

    /**
     * 种植险、养殖险公用计算方法（点击币别确认时）
     * @author: 田健
     * @date: 2017/12/20 20:47
     * @param calPremiumDto 计算费用请求入参：包含清单号、金禾清单号、险别、标的、总保额、费率、补贴比例等信息
     * @return CalPremiumResponseDto 计算返回信息
     * @throws Exception
     */
    public CalPremiumResponseDto CurrencyEnsure(CalPremiumDto calPremiumDto) throws Exception;
}
