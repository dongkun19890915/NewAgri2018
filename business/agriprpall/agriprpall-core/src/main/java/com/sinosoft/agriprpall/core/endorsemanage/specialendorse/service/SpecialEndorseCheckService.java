package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.SpecialEndorseCheckDto;
/**
 * 允许特殊批改校验
 * @Author: 李冬松
 * @Date: 2018/1/9 18:50
 */
public interface SpecialEndorseCheckService {
    /**
     * 允许特殊批改校验
     * @param specialEndorseCheckDto 允许特殊批改校验入参DTO
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 10:51 2018/1/19
     */

    public String specialEndorseCheck(SpecialEndorseCheckDto specialEndorseCheckDto)throws Exception;

}
