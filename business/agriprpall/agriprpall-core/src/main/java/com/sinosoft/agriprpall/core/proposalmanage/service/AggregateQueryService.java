package com.sinosoft.agriprpall.core.proposalmanage.service;



import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainDto;

import java.util.List;

/**
 *（汇总查询）
 * @Author: 陈道洋
 * @Date: 2017/11/9 10:37
 */
public interface AggregateQueryService {

    /**
    * @Description:根据条件进行汇总查询
    * @Author: 陈道洋
    * @Date: 2017/10/16 8:28
    */
    public List<PrpTmainDto> queryPrpTmainByCondition(PrpTmainDto prptmainDto) throws Exception;
}