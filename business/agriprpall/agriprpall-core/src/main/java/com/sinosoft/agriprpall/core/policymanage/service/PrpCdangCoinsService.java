package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.policymanage.dto.PrpCdangerCoinsDto;

import java.util.List;

/**
 * *PrpCcoins 共保信息表的Core接口
 *
 * @Author: qh
 * @Date: 2017/11/20 16:24
 */

public interface PrpCdangCoinsService {


    /**
     * （queryCdangerCoinsDtos 服务）
     *
     * @return
     * @throws Exception
     * @author: qh
     * @date: 2018/4/12 18:08
     */

    List<PrpCdangerCoinsDto> queryCdangerCoinsDtos(String policyNo) throws Exception;
}
