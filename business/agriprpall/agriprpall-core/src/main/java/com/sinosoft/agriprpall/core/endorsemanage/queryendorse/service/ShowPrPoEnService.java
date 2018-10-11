package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.RequestShowPrPoEnDto;

/**
 * 根据出险日期查询当期批单
 * @author 王保良,刘曼曼
 * @date 2017年10月28日
 */
public interface ShowPrPoEnService {

    /**
     * 根据出险日期查询批单号
     * @param requestShowPrPoEnDto 查询所需参数Dto
     * @author 王保良,刘曼曼
     * @return ResponseQueryPolicyInfoDto 保单大对象
     * @throws Exception
     */
    public PolicyEndorseDto showPrPoEnInfo(RequestShowPrPoEnDto requestShowPrPoEnDto) throws Exception;
}
