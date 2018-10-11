package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.impl;

import com.ctc.wstx.util.StringUtil;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import org.apache.commons.lang3.StringUtils;

public class GeneratePrpFeeServiceImpl {
    /**
    * @description
    * @param blPolicyDto, currency
    * @return int
    * @throws
    * @author 李冬松
    * @date 12:07 2017/11/10
    */
    public  int search(ResponseQueryPolicyInfoDto blPolicyDto, String currency) throws Exception
    {
        int icurr =0;
        int iFindFlag = 0;
        for(int i=0;i<blPolicyDto.getPrpCfeeDtoList().size();i++) {
            if (StringUtils.isNotEmpty(blPolicyDto.getPrpCfeeDtoList().get(i).getCurrency())
                    && blPolicyDto.getPrpCfeeDtoList().get(i).getCurrency().trim().equals(currency)) {
                icurr = i;
                iFindFlag = 1;
            }
        }
        if (iFindFlag ==0)
        { icurr = -1;}
        return icurr;

    }
}
