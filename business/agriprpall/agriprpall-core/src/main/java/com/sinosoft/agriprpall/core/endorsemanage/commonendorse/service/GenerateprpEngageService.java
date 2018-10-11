package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCengageDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;

import java.util.List;
import java.util.Map;

public interface GenerateprpEngageService {
    /**
     * @description
     * @param [blPolicyDto]
     * @return com.sinosoft.agriprpall.api.policymanage.dto.PrpCengageDto[]
     * @throws
     * @author 李冬松
     * @date 12:07 2017/11/10
     */

    public  PrpCengageDto[] ungroup(ResponseQueryPolicyInfoDto blPolicyDto) throws Exception;
    /**
     * @description
     * @param [blPolicyDto]
     * @return java.util.Map
     * @throws
     * @author 李冬松
     * @date 12:07 2017/11/10
     */
    public Map getGroupedEngages(ResponseQueryPolicyInfoDto blPolicyDto) throws Exception;
    /**
     * @description
     * @param [flag, newEngagesList, blEndorseDto]
     * @return void
     * @throws
     * @author 李冬松
     * @date 12:07 2017/11/10
     */
    public  void addPEngage(String flag, List newEngagesList, BLEndorseDto blEndorseDto)
            throws Exception;
}
