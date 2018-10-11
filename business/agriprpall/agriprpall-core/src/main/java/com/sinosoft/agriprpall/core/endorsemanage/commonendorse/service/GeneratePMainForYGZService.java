package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;

public interface GeneratePMainForYGZService {
    /**
     *  批单价税分离
     * @author: 王心洋
     * @date: 2017/10/26 16:18
     * @param blPolicyDtoNew 页面传入保单数据
     * @param blEndorseDto 页面传入批单数据
     */
    public void dealPMainForYGZ(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto) throws Exception ;
}
