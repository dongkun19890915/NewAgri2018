package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.client.dto.ResponseQueryTraceInfoDto;
import com.sinosoft.framework.dto.ResponseDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 04:00:52.059 
 * @description
 */
public interface ViewTraceService {
    /**
     * @description: 核保信息查询
     * @author: 钱浩
     * @date: 2017/10/17 14:18
     * @param proposalNo 投保单号
     * @return ResponseDto： 审批意见集合
     * @throws Exception
     */
    public  List<ResponseQueryTraceInfoDto> getViewTrace(String proposalNo)throws Exception;
}