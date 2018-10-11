package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLPolicyDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;

public interface QueryPolicyTxnListService {
    /**
    * 保单和清单信息查询
    * @param policyNo 保单号
    * @return com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto 保单大对象
    * @throws Exception
    * @author 李冬松
    * @date 16:42 2017/12/22
    */
    public ResponseQueryPolicyInfoDto queryPolicyAndTxnListInfo(String policyNo)throws Exception;
}
