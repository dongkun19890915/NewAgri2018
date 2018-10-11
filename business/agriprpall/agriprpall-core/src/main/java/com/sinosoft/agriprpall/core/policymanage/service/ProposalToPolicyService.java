package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.framework.dto.ResponseDto;

public interface ProposalToPolicyService {

    /**
     * 转保单(通过投保单号查询投保单相关表,然后将投保单相关表的数据转储到保单相关表)
     * @author: 宋振振
     * @date: 2017/10/25 20:56
     * @param proposalNo 投保单号
     * @param  userCode 员工代码
     * @return policyNo 保单号
     * @throws Exception
     */
    public String proposalToPolicy(String proposalNo,String userCode)throws Exception;

}
