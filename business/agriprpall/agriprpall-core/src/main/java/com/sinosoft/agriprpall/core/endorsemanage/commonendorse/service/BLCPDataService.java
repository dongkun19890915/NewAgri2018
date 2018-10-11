package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;

public interface BLCPDataService {
    /**
     * @description: 保存CP表
     * @author: 李东东
     * @date: 2017/10/27 11:05
     * @param blEndorseDto
     */
    public void saveCP(BLEndorseDto blEndorseDto)throws Exception;
    /**
     * @description: 根据保单号删除CP表数据
     * @author: 李东东
     * @date: 2017/10/27 11:17
     * @param policyNo
     */
    public void deleteCP(String policyNo)throws Exception;
    /**
     *  CP表的赋值方法
     * @param blPolicyDtoNew 前端传入的对象
     * @param blEndorseDto 要保存的对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 14:31 2017/11/11
     */
    public void evaluateFromCToCP(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto,ResponseQueryPolicyInfoDto blPolicyDtoOld)throws Exception;
}
