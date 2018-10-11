package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;

public interface BLPDataService {

    /**
     * @description: 保存P表
     * @author: 李东东
     * @date: 2017/10/27 11:05
     * @param blEndorseDto
     */
    public void saveP(PolicyEndorseDto policyEndorseDto) throws Exception;

    public void saveOth(PolicyEndorseDto policyEndorseDto) throws Exception;
    /**
     * 根据批单号删除P表数据
     * @param endorseNo
     */
    public void deleteP(String endorseNo) throws Exception;
}
