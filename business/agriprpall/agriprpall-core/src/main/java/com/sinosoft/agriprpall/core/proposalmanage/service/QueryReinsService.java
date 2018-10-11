package com.sinosoft.agriprpall.core.proposalmanage.service;



import com.sinosoft.agriprpall.api.client.dto.ResponseQueryRepolicyNoInfoDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainDto;

import java.util.List;

/**
 * 单号详细信息查询
 * @author: 钱浩
 * @date: 2017/11/30 下午 14:39
 */
public interface QueryReinsService {

    /**
     *  根据分保保单号查询详细信息
     * @author: 钱浩
     * @date: 2017/11/30 下午 14:51
     * @param reinsNo 分保保单号
     * @return 分保保单Dto
     * @throws Exception
     */
    public List<ResponseQueryRepolicyNoInfoDto> queryByReinNo( String reinsNo)throws Exception;}