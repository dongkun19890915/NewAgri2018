package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
/**
 * 普通批改itemkind表处理service接口类
 * @Author: 李冬松
 * @Date: 9:00 2017/11/17
 */
public interface GeneratePrpItemKindService {
    /**
    * 更新prpCitemKind信息
    * @param policyEndorseDto 保单批单大对象封装
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 18:35 2017/12/5
    */
    public void updatePrpCitemKindNew(PolicyEndorseDto policyEndorseDto) throws Exception;
}
