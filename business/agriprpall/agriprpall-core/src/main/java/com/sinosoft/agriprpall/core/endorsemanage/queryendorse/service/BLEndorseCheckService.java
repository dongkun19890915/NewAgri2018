package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
/**
 * 普通批改保存前校验类
 * @Author: 李冬松
 * @Date: 9:00 2017/11/17
 */
public interface BLEndorseCheckService {
    /**
     * @param blEndorseDto
     * @description: CP表数据质量检测
     * @author: 李东东
     * @date: 2017/10/27 10:46
     */
    public void checkCPData(BLEndorseDto blEndorseDto) throws Exception;
    /**
     * 保存前的校验
     * @param policyEndorseDto 保单批单大对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 9:21 2017/11/7
     */
    public void checkBeforeSave(PolicyEndorseDto policyEndorseDto) throws Exception;
}
