package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
/**
 * 普通批改生成批文类
 * @Author: 李冬松
 * @Date: 9:00 2017/11/17
 */
public interface GeneratePtextService {
    /**
    * 生成批文
    * @param policyEndorseDto 保单批单大对象
    * @return com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto 批单大对象
    * @throws Exception
    * @author 李冬松
    * @date 18:57 2017/12/5
    */
    public BLEndorseDto generateUsual(PolicyEndorseDto policyEndorseDto) throws Exception;
}
