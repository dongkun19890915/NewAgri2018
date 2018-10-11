package com.sinosoft.agriprpall.core.proposalmanage.service;

import com.sinosoft.agriprpall.api.proposalmanage.dto.QueryRelationResponseDto;
import com.sinosoft.framework.dto.ResponseDto;

public interface QueryRelationService {
    /**
     * 投保单关联查询(根据投保单号关联查询)
     * @author: 宋振振
     * @date: 2017/11/5 17:30
     * @param proposalNo 投保单号
     * @return QueryRelationResponseDto 返回与投保单号相关联的单号的Dto
     * @throws Exception
     */
    public QueryRelationResponseDto queryRelateByProposalNo(String proposalNo)throws Exception;
    /**
     * 保单/批单关联查询(根据保单号关联查询)
     * @author: 宋振振
     * @date: 2017/11/10 9:55
     * @param bizNo 业务号，传保单号
     * @return 返回与保单号相关联的单号的Dto
     * @throws Exception
     */
    public QueryRelationResponseDto queryRelateByBizNo(String bizNo)throws Exception;
}
