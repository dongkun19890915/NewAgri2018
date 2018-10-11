package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.endorsemanage.dto.UndwrtEndorSubmitDto;
import com.sinosoft.framework.dto.ResponseDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 04:00:52.059 
 * @description 工作流主表Core接口
 */
public interface UndwrtSubmitService {
    /**
     * 提交核保接口
     * @author: 钱浩
     * @date: 2017/10/17 14:18
     * @param undwrtEndorSubmitDto 入参对象
     * @return ResponseDto 提交核保状态与工作流号
     * @throws Exception
     */
    public List submitUndwrtByProposal(UndwrtEndorSubmitDto undwrtEndorSubmitDto) throws Exception;
}